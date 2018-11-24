package org.mdw.biblio.web;

import javax.validation.Valid;

import org.mdw.biblio.dao.AuteursRepository;
import org.mdw.biblio.entities.Auteur;
import org.springframework.beans.factory.annotation.Autowired;
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
