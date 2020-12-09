package com.example.projetoRestaurante;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.projetoRestaurante.model.Estoque;
import com.example.projetoRestaurante.model.Gerente;
import com.example.projetoRestaurante.model.Permissao;
import com.example.projetoRestaurante.model.Venda;
import com.example.projetoRestaurante.model.Vendedor;
import com.example.projetoRestaurante.repository.EstoqueRepository;
import com.example.projetoRestaurante.repository.FuncionarioRepository;
import com.example.projetoRestaurante.repository.GerenteRepository;
import com.example.projetoRestaurante.repository.PermissaoRepository;
import com.example.projetoRestaurante.repository.VendaRepository;
import com.example.projetoRestaurante.repository.VendedorRepository;

@SpringBootApplication
public class ProjetoRestauranteApplication implements CommandLineRunner {
	
	@Autowired
	private EstoqueRepository estoqueRepo;
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	@Autowired
	private GerenteRepository gerenteRepo;
	@Autowired
	private VendaRepository vendaRepo;
	@Autowired
	private VendedorRepository vendedorRepo;
	
	@Autowired
	private PermissaoRepository permissaoRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoRestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//permissão
		Permissao p1 = new Permissao();
		p1.setNome("ADMIN");
		permissaoRepo.saveAll(List.of(p1));
		//gerente
		Gerente g1 = new Gerente();
		g1.setCpf("07680544514");
		g1.setNome("Marcos");
		g1.setUsuario("administrador");
		g1.setSenha(new BCryptPasswordEncoder().encode("0123456789"));
		g1.setTelefone("22999999988");
		g1.setPermissoes(List.of(p1));
		//vendedor
		Vendedor v1 = new Vendedor();
		v1.setCpf("97581918459");
		v1.setNome("vinicus");
		v1.setSalario(1500);
		v1.setTelefone("22999999999");
		//venda
		Venda ven1 = new Venda();
		ven1.setItem("pizza");
		ven1.setValor(50);
		Calendar Data = Calendar.getInstance();
		ven1.setData(Data);
		ven1.setVendedor(v1);
		//estoque
		Estoque est1 = new Estoque();
		est1.setValor(100);
		est1.setItem("Temperos");
		est1.setNota_fiscal("28457455");
		est1.setData(Data);
		est1.setGerente(g1);
		
		
		gerenteRepo.save(g1);
		vendedorRepo.save(v1);
		vendaRepo.save(ven1);
		estoqueRepo.save(est1);
		
		
		
		
		
		
		
		
		
	}
	
	

}
