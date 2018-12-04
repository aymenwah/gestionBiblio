package org.mdw.biblio.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class Livre implements Serializable{
	@Id
	@NotNull
	private String codeLivre;
	@NotNull
	private String titre;
	@Min(10)
	private int nbPages;
	@ManyToOne
	@JoinColumn(name="numAut")
	private Auteur auteur;
	@ManyToOne
	@JoinColumn(name="codeEd")
	private Editeur editeur;
	public Editeur getEditeur() {
		return editeur;
	}
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}
	public Auteur getAuteur() {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	public String getCodeLivre() {
		return codeLivre;
	}
	public void setCodeLivre(String codeLivre) {
		this.codeLivre = codeLivre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livre(String codeLivre, String titre, int nbPages) {
		super();
		this.codeLivre = codeLivre;
		this.titre = titre;
		this.nbPages = nbPages;
	}
	

}
