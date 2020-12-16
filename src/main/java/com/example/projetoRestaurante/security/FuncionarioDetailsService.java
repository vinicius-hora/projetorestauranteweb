package com.example.projetoRestaurante.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.projetoRestaurante.model.Gerente;
import com.example.projetoRestaurante.model.Permissao;
import com.example.projetoRestaurante.repository.GerenteRepository;

@Service
public class FuncionarioDetailsService  implements UserDetailsService{
	
	@Autowired
	private GerenteRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Gerente gerente = repo.findByUsuario(usuario);
		if(gerente == null) {
			throw new UsernameNotFoundException ("Gerente não cadastrado com esse login: "+usuario);
		}
		return new User(gerente.getUsuario(), gerente.getSenha(), getAuthorities(gerente.getPermissoes()));
		
	}
	
	private List<GrantedAuthority> getAuthorities(List<Permissao> lista){
		List<GrantedAuthority> l = new ArrayList<>();
		for(Permissao p: lista) {
			l.add(new SimpleGrantedAuthority("ROLE_"+p.getNome()));
		}
		return l;
		
	}
	

}
