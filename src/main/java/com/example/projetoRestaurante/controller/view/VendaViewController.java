package com.example.projetoRestaurante.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetoRestaurante.model.Venda;
import com.example.projetoRestaurante.service.VendaService;
import com.example.projetoRestaurante.service.VendedorService;

@Controller
@RequestMapping(path = "/vendas")
public class VendaViewController {
	@Autowired
	private VendaService service;
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("vendas", service.findAll());
		return "vendas";
	}
	
	
	@GetMapping(path = "/venda")
	public String cadastro(Model model) {
		model.addAttribute("venda", new Venda());
		model.addAttribute("vendedor", vendedorService.findAll());
		return "formVenda";
	}
	
	@PostMapping(path = "/venda")
	public String save(@Valid @ModelAttribute Venda venda, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "formVenda";
		}
		List<FieldError> list = new ArrayList<>();
		for(FieldError fe : result.getFieldErrors()) {
			if(!fe.getField().equals("data")) {
				list.add(fe);
			}
		}
		if(!list.isEmpty()) {
			model.addAttribute("MsgErrors",list);
			return "formVenda";
		}
		venda.setId(null);
		try {
			service.save(venda);
			model.addAttribute("msgSucesso", "Venda cadastrada com sucesso");
			model.addAttribute("venda", new Venda());
			model.addAttribute("vendedor", vendedorService.findAll());
			
			return "formVenda";
			
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Venda", e.getMessage()));
			return "formVenda";
		}
		
		
	}
	
	@GetMapping(path = "{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/vendas";
		
	}
	
	

}
