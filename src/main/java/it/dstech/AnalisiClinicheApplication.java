package it.dstech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.dstech.model.Analiti;
import it.dstech.model.Paziente;
import it.dstech.repo.AnalitiRepo;
import it.dstech.repo.PazienteRepo;

@SpringBootApplication
public class AnalisiClinicheApplication {

	private static PazienteRepo pazienteRepo;

	@Autowired
	private PazienteRepo stPazienteRepo;

	@PostConstruct
	public void initP() {
		AnalisiClinicheApplication.pazienteRepo = stPazienteRepo;
	}

	private static AnalitiRepo analitiRepo;

	@Autowired
	private AnalitiRepo stAnalitiRepo;

	@PostConstruct
	public void initA() {
		AnalisiClinicheApplication.analitiRepo = stAnalitiRepo;
	}

	private static final String PATH = "/home/gianluca/Scrivania/test.txt";

	public static void main(String[] args) throws IOException, URISyntaxException {

		SpringApplication.run(AnalisiClinicheApplication.class, args);

		String[] records = readFromFile(PATH);

		generateData(records);

		readFromDatabase();

	}

	private static String[] readFromFile(String fileName) throws IOException {
		System.out.println("\nReading from file...\n--------------\n");
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				if (line != null) {
					sb.append(line);
					sb.append("\n");
					line = br.readLine();
					System.out.println(line + " -> Completed.");
				}
			}
			System.out.println("\nReading from file completed.\n--------------\n");
			return sb.toString().split("\n");
		} finally {
			br.close();
		}
	}

	private static void generateData(String[] records) {
		System.out.println("Start data processing...\n--------------\n");
		for (String record : records) {
			if (!record.isEmpty()) {
				String substring = record.substring(2);
				Paziente p = new Paziente();
				String[] campo = substring.trim().split(";");
				p.setId(campo[0]);
				System.out.println(p.getId() + " -> Saved.");
				p.setCod(campo[1]);
				p.setNome(campo[3]);
				p.setCognome(campo[4]);
				p.setDataNascita(campo[5]);
				p.setCodFisc(campo[6]);
				p.setSesso(campo[7]);
				pazienteRepo.save(p);

				for (int i = 9; i < campo.length; i++) {
					Analiti a = new Analiti();
					a.setDataPrestazione(campo[2]);
					String[] val = campo[i].split("\\^");
					if (1 < val.length && campo[i].matches(".*\\d.*")) {
						for (int k = 1; k < val.length; k++) {
							a.setCodPrest(val[0].trim());
							a.setValore1(val[1].trim());
							if (3 < val.length) {
								a.setValore1(val[2].trim());
								a.setValore2(val[3].trim());
							}
							if (4 < val.length)
								a.setValore3(val[4].trim());
							if (5 < val.length)
								a.setValore4(val[5].trim());
							if (6 < val.length)
								a.setValore5(val[6].trim());
						}
					} else
						continue;
					a.setPaziente(p);
					analitiRepo.save(a);
				}
			}
		}
		System.out.println("\nEnd data processing.\n--------------\n");
	}

	private static void readFromDatabase() {
		System.out.println("Reading from database...\n--------------\n");
		pazienteRepo.findAll().forEach(System.out::println);
		System.out.println("\nDONE!\n--------------");
	}

}
