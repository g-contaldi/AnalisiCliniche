package it.dstech.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;


public class Paziente {

	@Id
	private String id;

	private String cod;

	private String nome;

	private String cognome;

	private String dataNascita;

	private String codFisc;

	private String sesso;

	private List<Analiti> listAnaliti = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public List<Analiti> getListAnaliti() {
		return listAnaliti;
	}

	public void setListAnaliti(List<Analiti> listAnaliti) {
		this.listAnaliti = listAnaliti;
	}

	@Override
	public String toString() {
		return id + ", " + cod + ", " + nome + " " + cognome + ", " + dataNascita + ", " + codFisc + ", " + sesso
				+ ", listAnaliti= " + listAnaliti;
	}

}
