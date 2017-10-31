package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Analiti {

	@Id
	@GeneratedValue
	private int id;

	private String dataPrestazione;

	private String codPrest;

	private String valore1;

	private String valore2;

	private String valore3;

	private String valore4;

	private String valore5;

	@ManyToOne(fetch = FetchType.EAGER)
	private Paziente paziente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataPrestazione() {
		return dataPrestazione;
	}

	public void setDataPrestazione(String dataPrestazione) {
		this.dataPrestazione = dataPrestazione;
	}

	public String getCodPrest() {
		return codPrest;
	}

	public void setCodPrest(String codPrest) {
		this.codPrest = codPrest;
	}

	public String getValore1() {
		return valore1;
	}

	public void setValore1(String valore1) {
		this.valore1 = valore1;
	}

	public String getValore2() {
		return valore2;
	}

	public void setValore2(String valore2) {
		this.valore2 = valore2;
	}

	public String getValore3() {
		return valore3;
	}

	public void setValore3(String valore3) {
		this.valore3 = valore3;
	}

	public String getValore4() {
		return valore4;
	}

	public void setValore4(String valore4) {
		this.valore4 = valore4;
	}

	public String getValore5() {
		return valore5;
	}

	public void setValore5(String valore5) {
		this.valore5 = valore5;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	@Override
	public String toString() {
		if (valore2 == null)
			return codPrest + ": " + valore1;
		else if (valore3 == null)
			return codPrest + ": " + valore1 + ", " + valore2;
		else if (valore4 == null)
			return codPrest + ": " + valore1 + ", " + valore2 + ", " + valore3;
		else if (valore5 == null)
			return codPrest + ": " + valore1 + ", " + valore2 + ", " + valore3 + ", " + valore4;
		else
			return codPrest + ": " + valore1 + ", " + valore2 + ", " + valore3 + ", " + valore4 + ", " + valore5;
	}

}
