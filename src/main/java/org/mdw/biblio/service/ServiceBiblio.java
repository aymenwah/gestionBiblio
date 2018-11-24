package org.mdw.biblio.service;

import java.util.List;

import org.mdw.biblio.dao.AuteursRepository;
import org.mdw.biblio.dao.EditeurRepository;
import org.mdw.biblio.dao.LivresRepository;
import org.mdw.biblio.entities.Auteur;
import org.mdw.biblio.entities.Editeur;
import org.mdw.biblio.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBiblio {
	@Autowired
	private AuteursRepository auteursRepository;
	@Autowired
	private LivresRepository livresRepository;
	@Autowired
	private EditeurRepository editeurRepository;
	
	@RequestMapping("/auteurs/save")
	public Auteur saveAuteur(Auteur a) {
		return auteursRepository.save(a);
		
	}
	@RequestMapping("/auteurs/auteurParNom")
	public Page<Auteur> auteurParNom(String nom,int np) {
		Page<Auteur> auteurs=auteursRepository.findByNom(nom, new PageRequest(np, 3));
		return auteurs;
		
		
	}
	@RequestMapping("/auteurs/auteurParPren")
	public List<Auteur> auteurParPren(String prenom) {
		List<Auteur> auteurs=auteursRepository.chercherParPren(prenom+"%");
		return auteurs;
		
		
	}
	@RequestMapping("/livres/livre")
	public Livre getLivre(String code) {
		
		return livresRepository.findById(code).get();
		
		
	}
	@RequestMapping("/livres/supprimer")
	public boolean suppLivre(String code) {
		
		Livre l=getLivre(code);
		if(l==null)
			return false;
		else 
			livresRepository.delete(l);
			return true;
		
		
	}
	@RequestMapping("/livres/livresSupPages")
	public List<Livre> livresSupPages(int nb) {
		List<Livre> livres=livresRepository.chercherSupPage(nb);
		return livres;
		
		
	}
	@RequestMapping("/editeurs/all")
	public List<Editeur> allEditeurs() {
		return editeurRepository.findAll();
		
		
	}
	@RequestMapping("/editeurs/modifier")
	public Editeur modifEditeur(Editeur e) {
		
		return editeurRepository.saveAndFlush(e);
		
		
	}
	
	@RequestMapping("/editeurs/editeurParNom")
	public Page<Editeur> editeurParNom(String nom,int np,int size) {
		Page<Editeur> editeurs=editeurRepository.chercherParNom("%"+nom+"%", new PageRequest(np, size));
		return editeurs;
		
		
	}
	
	
	
	
	
	

}
