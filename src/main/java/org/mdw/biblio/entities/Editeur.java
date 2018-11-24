package org.mdw.biblio.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Editeur implements Serializable{
	@Id
	private String codeEditeur;
	private String nomEditeur;
	private Date dateCreation;
	@OneToMany(mappedBy="editeur")
	private Set<Livre>livres=new HashSet<>();
	public Set<Livre> getLivres() {
		return livres;
	}
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	public String getCodeEditeur() {
		return codeEditeur;
	}
	public void setCodeEditeur(String codeEditeur) {
		this.codeEditeur = codeEditeur;
	}
	public String getNomEditeur() {
		return nomEditeur;
	}
	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Editeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editeur(String codeEditeur, String nomEditeur, Date dateCreation) {
		super();
		this.codeEditeur = codeEditeur;
		this.nomEditeur = nomEditeur;
		this.dateCreation = dateCreation;
	}
	
}
