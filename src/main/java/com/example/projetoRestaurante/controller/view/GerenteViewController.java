package com.example.projetoRestaurante.controller.view;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoRestaurante.model.Gerente;
import com.example.projetoRestaurante.model.Venda;
import com.example.projetoRestaurante.model.Vendedor;
import com.example.projetoRestaurante.repository.PermissaoRepository;
import com.example.projetoRestaurante.service.GerenteService;
import com.example.projetoRestaurante.service.VendaService;
import com.example.projetoRestaurante.service.VendedorService;

@Controller
@RequestMapping(path = "/gerentes")
public class GerenteViewController {
	@Autowired
	private GerenteService service;
	
	@Autowired
	private PermissaoRepository permissaoRepo;
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("gerentes", service.findAll());
		return "gerentes";
	}
	

	
	@GetMapping(path = "/gerente")
	public String cadastro(Model model) {
		model.addAttribute("gerente", new Gerente());
		model.addAttribute("permissoes", permissaoRepo.findAll());
		return "formGerente";
	}
	
	@PostMapping(path = "gerente")
	public String save(@Valid @ModelAttribute Gerente gerente, BindingResult result, Model model) {
		model.addAttribute("permissao", permissaoRepo.findAll());
		if(result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "formGerente";
		}
		gerente.setId(null);
		try {
			service.save(gerente);
			model.addAttribute("msgSucesso", "Venda cadastrada com sucesso");
			model.addAttribute("gerente", new Gerente());
			return "formGerente";
			
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Gerente", e.getMessage()));
			return "formGerente";
		}
		
		
	}
	@GetMapping(path = "{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/gerentes";
		
	}

}
