package com.example.javadb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity   //indica a JPA che questa classe è una classe entità
@Table(name="regioni") //Specifica il nome della tabella del database a cui l'entità è mappata.
public class Regione implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id // Primary KEY
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // il database gestirà la generazione del valore della chiave primaria.
	private Integer id; 
	
	private String nome;
	private Double latitudine;
	private Double longitudine;

	/*
	 * Costruttore vuoto necessario per JPA
	 * per garantire che le entità possano essere 
	 * istanziate correttamente e gestite dal framework
	 */
	public Regione() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}

	public Double getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, latitudine, longitudine, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regione other = (Regione) obj;
		return Objects.equals(id, other.id) && Objects.equals(latitudine, other.latitudine)
				&& Objects.equals(longitudine, other.longitudine) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Regione [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", latitudine=");
		builder.append(latitudine);
		builder.append(", longitudine=");
		builder.append(longitudine);
		builder.append("]");
		return builder.toString();
	}
	
	

}
