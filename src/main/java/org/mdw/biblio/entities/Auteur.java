package org.mdw.biblio.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class Auteur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num;
	@NonNull
	@Size(min=4,max=20)
	private String nom;
	@Size(min=4,max=20)
	private String prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNais;
	@OneToMany(mappedBy="auteur")
	private Set<Livre> livres=new HashSet<>();
	
	
	
	public Set<Livre> getLivres() {
		return livres;
	}
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNais() {
		return dateNais;
	}
	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auteur(String nom, String prenom, Date dateNais) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
	}
	
	

}
