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
import com.example.projetoRestaurante.service.GerenteService;
import com.example.projetoRestaurante.service.VendaService;
import com.example.projetoRestaurante.service.VendedorService;

@Controller
@RequestMapping(path = "/vendedores")
public class VendedorViewController {
	@Autowired
	private VendedorService service;
	private GerenteService gerenteService;
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vendedores", service.findAll());
		return "vendedores";
	}
	

	
	@GetMapping(path = "/vendedor")
	public String cadastro(Model model) {
		model.addAttribute("vendedor", new Vendedor());
		return "formVendedor";
	}
	
	@PostMapping(path = "/vendedor")
	public String save(@Valid @ModelAttribute Vendedor vendedor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "formVendedor";
		}
		vendedor.setId(null);
		try {
			service.save(vendedor);
			model.addAttribute("msgSucesso", "Vendedor cadastrado com sucesso");
			model.addAttribute("vendedor", new Vendedor());
			return "formVendedor";
			
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Vendedor", e.getMessage()));
			return "formVendedor";
		}
		
		
	}
	@GetMapping(path = "{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/vendedores";
		
	}

}
