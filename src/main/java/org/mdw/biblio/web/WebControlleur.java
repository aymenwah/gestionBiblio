package org.mdw.biblio.web;

import javax.validation.Valid;

import org.mdw.biblio.dao.AuteursRepository;
import org.mdw.biblio.dao.EditeurRepository;
import org.mdw.biblio.dao.LivresRepository;
import org.mdw.biblio.entities.Auteur;
import org.mdw.biblio.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebControlleur {
	@Autowired
	private AuteursRepository auteurRepository;
	@Autowired
	private LivresRepository livresRepository;
	@Autowired
	private EditeurRepository editeurRepository;
	@RequestMapping("livre/add")
	public String addLivre(Model model) {
		model.addAttribute("livre",new Livre() );
		model.addAttribute("auteurs",auteurRepository.findAll() );
		model.addAttribute("editeurs",editeurRepository.findAll() );
		return "addLivre";
	}
	@RequestMapping(value="livre/save",method=RequestMethod.POST)
	public String saveLivre(@Valid @ModelAttribute Livre l,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
		return "redirect:/livre/add";
			//return "addLivre";
		}
		//System.out.println(l.getAuteur().getNom());
		l.setAuteur(auteurRepository.findById(l.getAuteur().getNum()).get());
		l.setEditeur(editeurRepository.findById(l.getEditeur().getCodeEditeur()).get());
		livresRepository.save(l);
		
		return "redirect:/livre/lister";
	}
	@RequestMapping(value="livre/listerbytitre",method=RequestMethod.POST)
	public String livrelisterTitre(@ModelAttribute String titre,Model model) {
		model.
		addAttribute("livres",livresRepository.chercherParTitre("%"+titre+"%"));
		
		return "livres";
	}
	@RequestMapping("livre/lister")
	public String livrelister(Model model,int p) {
		Page<Livre> livres=livresRepository.
				findAll(new PageRequest(p,3));
		
		model.addAttribute("livres",
				livres );
		model.addAttribute("nbpages", livres.getTotalPages());
		return "livres";
	}
	@RequestMapping("livre/modifLivre")
	public String modifLivre(Model model,String codeLivre) {
		Livre l=livresRepository.findById(codeLivre).get();
		model.addAttribute("auteurs",auteurRepository.findAll() );
		model.addAttribute("editeurs",editeurRepository.findAll() );
		model.addAttribute("livre",l);
		return "modifLivre";
	}
	@RequestMapping("auteur/modifAuteur")
	public String modifAuteur(Model model,Long num) {
		Auteur a=auteurRepository.findById(num).get();
		model.addAttribute("auteur",a);
		return "modifAuteur";
	}
	@RequestMapping(value="livre/update",method=RequestMethod.POST)
	public String updateAuteur(@Valid @ModelAttribute Livre l,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			return "redirect:/livre/modifLivre";
		}
		l.setAuteur(auteurRepository.findById(l.getAuteur().getNum()).get());
		l.setEditeur(editeurRepository.findById(l.getEditeur().getCodeEditeur()).get());
		livresRepository.save(l);
		
		return "redirect:/livre/lister";
	}
	@RequestMapping(value="auteur/update",method=RequestMethod.POST)
	public String updateAuteur(@Valid @ModelAttribute Auteur a,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			return "modifAuteur";
		}
		auteurRepository.save(a);
		
		return "redirect:/auteur/lister";
	}
	@RequestMapping("/livre/supLivre")
	public String suppAuteur(Model model,String codeLivre) {
		livresRepository.deleteById(codeLivre);
		return "redirect:/livre/lister";
	}
	@RequestMapping("auteur/supAuteur")
	public String suppAuteur(Model model,Long num) {
		auteurRepository.deleteById(num);
		return "redirect:/auteur/lister";
	}
	@RequestMapping("auteur/lister")
	public String listAuteurs(Model model) {
		model.addAttribute("auteurs",
				auteurRepository.findAll() );
		return "auteurs";
	}
	@RequestMapping("auteur/add")
	public String addAuteur(Model model) {
		model.addAttribute("auteur",new Auteur() );
		return "addAuteur";
	}
	@RequestMapping(value="auteur/save",method=RequestMethod.POST)
	public String saveAuteur(@Valid @ModelAttribute Auteur a,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			return "addAuteur";
		}
		auteurRepository.save(a);
		
		return "redirect:/auteur/lister";
	}

}
