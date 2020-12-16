package com.example.projetoRestaurante.controller.view;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoRestaurante.model.Estoque;

import com.example.projetoRestaurante.service.EstoqueService;

import com.example.projetoRestaurante.service.GerenteService;


@Controller
@RequestMapping(path = "/estoques")
public class EstoqueViewController {
	@Autowired
	private EstoqueService service;
	@Autowired
	private GerenteService gerenteService;
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("estoques", service.findAll());
		return "estoques";
	}
	
	
	@GetMapping(path = "/estoque")
	public String cadastro(@AuthenticationPrincipal User user, Model model) {
		gerenteService.findAll();
		model.addAttribute("estoque", new Estoque());
		model.addAttribute("gerentes", gerenteService.findAll());
		return "formEstoque";
	}
	
	@PostMapping(path = "/estoque")
	public String save(@Valid @ModelAttribute Estoque estoque, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "formEstoque";
		}
		estoque.setId(null);
		try {
			
			gerenteService.findAll();
			model.addAttribute("gerentes", gerenteService.findAll());
			model.addAttribute("msgSucesso", "Venda cadastrada com sucesso");
			model.addAttribute("estoque", new Estoque());
			service.save(estoque);
			return "formEstoque";
			
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Estoque", e.getMessage()));
			return "formEstoque";
		}
		
		
	}
	@GetMapping(path = "{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/estoques";
		
	}
	

}
