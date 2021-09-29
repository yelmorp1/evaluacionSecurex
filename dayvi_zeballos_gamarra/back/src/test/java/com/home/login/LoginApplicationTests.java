package com.home.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.home.login.model.TblUsuario;
import com.home.login.repository.TblUsuarioRepository;

@SpringBootTest
class LoginApplicationTests {

	@Autowired
	TblUsuarioRepository tblUsuarioRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void contextLoads() {
		TblUsuario usuario=new TblUsuario();
		usuario.setId(5L);
		usuario.setUsername("Monica");
		usuario.setPasword(passwordEncoder.encode("123"));
		
		TblUsuario retorno = tblUsuarioRepository.save(usuario);
		
		assertTrue(retorno.getPasword().equals(usuario.getPasword()));
	}

}
