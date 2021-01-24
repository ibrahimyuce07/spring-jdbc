package com.jdbc.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kayit_tablosu")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "isim")
	private String isim;

	@Column(name = "soyisim")
	private String soyisim;

	@Column(name = "kan_grubu")
	private String kanGrubu;

	@Column(name = "cep_telefonu")
	private String cepTel;

	@Column(name = "adres")
	private String adres;

	// Constructor
	public Person(int id, String isim, String soyisim, String kanGrubu, String cepTel, String adres) {
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		this.kanGrubu = kanGrubu;
		this.cepTel = cepTel;
		this.adres = adres;
	}

	public Person() {

	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getKanGrubu() {
		return kanGrubu;
	}

	public void setKanGrubu(String kanGrubu) {
		this.kanGrubu = kanGrubu;
	}

	public String getCepTel() {
		return cepTel;
	}

	public void setCepTel(String cepTel) {
		this.cepTel = cepTel;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

}
