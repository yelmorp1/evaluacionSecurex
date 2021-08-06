package com.exampleProject.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.exampleProject.spring.models.Cajero;
import com.exampleProject.spring.models.CajeroExcl;
import com.exampleProject.spring.models.CajeroPref;
import com.exampleProject.spring.models.Usuario;
import com.exampleProject.spring.service.UsuarioService;


@RestController
public class UsuarioController {
	
	@Autowired
    UsuarioService usuarioService;
    
    @RequestMapping("/listUsuarios")
    public ModelAndView listUsuario(){
        List lista = new ArrayList();
        ModelAndView mav =  new ModelAndView();
        Usuario us = new Usuario();
        
        List<Usuario> listUsuarios=usuarioService.listarUsuarios(us);

        mav.addObject("usuList",listUsuarios);
        mav.setViewName("listUsuarios");
        return mav;
    }
    
    //ADD
    @RequestMapping(value="/addUsuario",method=RequestMethod.GET)
    public ModelAndView addUsuario(ModelMap model){

        Usuario us = new Usuario();
        model.addAttribute("usuario",us);

        return new ModelAndView("addUsuario");
    }
    
    @RequestMapping(value="/genticket",method=RequestMethod.GET)
    public ModelAndView genticket(ModelMap model){

        Usuario us = new Usuario();
        model.addAttribute("usuario",us);

        return new ModelAndView("genticket");
    }
    
    @RequestMapping(value="/insertar",method=RequestMethod.POST)
    public ModelAndView insertar(@ModelAttribute("usuario") Usuario u,HttpServletRequest request,BindingResult result,SessionStatus status){
    	
    	if(result.hasErrors()){
    		return new ModelAndView("addUsuario");
    	}else {
    		String idUsSession = (String) request.getSession().getAttribute("idUser");
    		usuarioService.insertarUsuario(u);
    	}
		
        return new ModelAndView("redirect:/listUsuarios"); 
    }
    
    @RequestMapping(value="/ingresarAlTicket",method=RequestMethod.POST)
    public ModelAndView ingresarAlTicket(@ModelAttribute("usuario") Usuario us,HttpServletRequest request,BindingResult result,SessionStatus status){
    	
    	Cajero c = new Cajero();
    	CajeroPref cf = new CajeroPref();
    	CajeroExcl ce = new CajeroExcl();
    	
    	System.out.println(us.getUser());
    	System.out.println(us.getEdad());
    	
    	String idcaj="";
    	
    	//Clientes Exclusivos
    	Integer multiplo3=Integer.parseInt(us.getEdad())%3;
    	System.out.println("multiplo3: "+multiplo3);
    	if(Integer.parseInt(us.getEdad())<60) {
    		
    		if(multiplo3==0) {
	    		List<CajeroExcl> listcajExcl=usuarioService.listarCajerosActivosExcl(ce);
	        	
	        	if(listcajExcl.size()==0) {
	        		idcaj="0";
	        		return new ModelAndView("redirect:/genticket");
	        	}else {
	        		idcaj=listcajExcl.get(0).getIdcajero();
	        	}
	        	
	        	//Setea el id del cajero a asignar
		    	us.setIdCajero(idcaj);
		    	
		    	usuarioService.asignarCajeroActivo(us);
    		}
    		return new ModelAndView("redirect:/listUsuarios");
    	}
    	
    	//Cliente Preferencial > 60
    	if(Integer.parseInt(us.getEdad())>=60) {
    		List<CajeroPref> listcajPref=usuarioService.listarCajerosActivosPref(cf);
        	
        	if(listcajPref.size()==0) {
        		idcaj="0";
        		return new ModelAndView("redirect:/genticket");
        	}else {
        		idcaj=listcajPref.get(0).getIdcajero();
        	}
        	
        	//Setea el id del cajero a asignar
	    	us.setIdCajero(idcaj);
	    	
	    	usuarioService.asignarCajeroActivo(us);
	    	
    	}else {
    	
	    	//Cliente Normal
	    	List<Cajero> listcaj=usuarioService.listarCajerosActivosNormal(c);
	    	
	    	if(listcaj.size()==0) {
	    		idcaj="0";
	    		return new ModelAndView("redirect:/genticket");
	    	}else {
	    		idcaj=listcaj.get(0).getIdcajero();
	    	}
	    	
	    	//Setea el id del cajero a asignar
	    	us.setIdCajero(idcaj);
	    	
	    	usuarioService.asignarCajeroActivo(us);
    	}
    	
    	
    	
    	
    	/*if(result.hasErrors()){
    		return new ModelAndView("addUsuario");
    	}else {
    		String idUsSession = (String) request.getSession().getAttribute("idUser");
    		usuarioService.insertarUsuario(u);
    	}*/
		
        return new ModelAndView("redirect:/listUsuarios"); 
    }
    
    
    //EDIT
    @RequestMapping(value="/edit@{id}",method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id,ModelMap model) {
       
        Usuario us=usuarioService.obtenerUsuarioById(id);
        model.addAttribute("usuario", us);

        return new ModelAndView("editUsuario");
    }
    
    @RequestMapping(value="/modificar",method=RequestMethod.POST)
    public ModelAndView modificar(@ModelAttribute("usuario") Usuario u,BindingResult result,SessionStatus status,HttpServletRequest request){
    	
    	String idUsSession = (String) request.getSession().getAttribute("idUser");
    	usuarioService.modificarUsuario(u);
		
        return new ModelAndView("redirect:/listUsuarios");
    }
    
    //DEL
    @RequestMapping(value="/delete@{id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable String id) {
    	
    	usuarioService.eliminarUsuario(id);
    	
    	return new ModelAndView("redirect:/listUsuarios");
    }

}
