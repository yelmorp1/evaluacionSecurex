package com.home.login.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.login.model.TblRole;
import com.home.login.model.TblUsuario;
import com.home.login.repository.TblRolRepository;
import com.home.login.repository.TblUsuarioRepository;
import com.home.login.request.ReqRole;
import com.home.login.request.ReqUsuario;
import com.home.login.service.UsuarioService;

@Service 
@Transactional
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
	
	@Autowired
	TblUsuarioRepository tblUsuarioRepository;
	
	@Autowired
	TblRolRepository tblRolRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TblUsuario user = tblUsuarioRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("usuario no encontrado");
		}
		
		Collection<SimpleGrantedAuthority> collections = new ArrayList<>();
		user.getRoles().forEach( rol -> {
			collections.add(new SimpleGrantedAuthority(rol.getName()));
			});
		
		UserDetails userDet = new User(user.getUsername(), user.getPasword(), collections);
		return userDet;
	}
	
	@Override
	public TblUsuario saveUsuario(ReqUsuario request) {
		
		TblUsuario usuario = new TblUsuario();
		usuario.setId(request.getId());
		usuario.setUsername(request.getUsername());
		usuario.setPasword(passwordEncoder.encode(request.getPasword()));
		usuario.setRoles(request.getRoles());
		return tblUsuarioRepository.save(usuario);
		
	}

	@Override
	public TblRole saveRol(ReqRole request) {
		TblRole rol = new TblRole(request.getId(), request.getName());
		return tblRolRepository.save(rol);
	}

	@Override
	public void addRoleToUsuario(String username, String rolName) {
		TblUsuario usuario = tblUsuarioRepository.findByUsername(username);
		TblRole rol = tblRolRepository.findByName(rolName);
		usuario.getRoles().add(rol);
		
	}

	@Override
	public TblUsuario getUser(String username) {
		
		return tblUsuarioRepository.findByUsername(username);
	}

	@Override
	public List<TblUsuario> getUsers() {
		
		return tblUsuarioRepository.findAll();
	}

	

}
