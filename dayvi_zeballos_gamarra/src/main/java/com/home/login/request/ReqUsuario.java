package com.home.login.request;

import java.util.ArrayList;
import java.util.List;

import com.home.login.model.TblRole;

import lombok.Data;

@Data
public class ReqUsuario {

	private Long id;
	
	private String username;
	
	private String pasword;
	
	private List<TblRole> roles = new ArrayList<>();
}
