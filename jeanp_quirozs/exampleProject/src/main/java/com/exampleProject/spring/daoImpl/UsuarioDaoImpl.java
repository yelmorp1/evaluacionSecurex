package com.exampleProject.spring.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.exampleProject.spring.dao.UsuarioDao;
import com.exampleProject.spring.models.Cajero;
import com.exampleProject.spring.models.CajeroExcl;
import com.exampleProject.spring.models.CajeroPref;
import com.exampleProject.spring.models.Usuario;

@Repository("UsuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource datasource){
		jdbcTemplate = new JdbcTemplate(datasource);
    }

	public List<Usuario> listarUsuarios(Usuario us) {
		String sql="select * from monitortickets ";
    	
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Usuario>>() {
    		
    		public List<Usuario> extractData(ResultSet rs) throws SQLException, DataAccessException{
    			List<Usuario> list = new ArrayList<Usuario>();
    			while(rs.next()) {
    				Usuario us = new Usuario();
    				/*us.setId_usuario(rs.getString(1));
    				us.setUser(rs.getString(2));
    				us.setPass(rs.getString(3));
    				us.setDescripcion(rs.getString(4));
    				us.setEstado(rs.getString(9));*/
    				
    				us.setIdCajero(rs.getString(1));
    				us.setUsuario(rs.getString(2));
    				
    				if(rs.getString(3).equals("0")) {
    					us.setExcl("INACTIVO");
    					us.setClaseBoot1("btn-outline-secondary");
    				}else{
    					us.setExcl("ACTIVO");
    					us.setClaseBoot1("btn-primary");
    				}
    				
    				if(rs.getString(4).equals("0")) {
    					us.setNormal("INACTIVO");
    					us.setClaseBoot2("btn-outline-secondary");
    				}
    				else{
    					us.setNormal("ACTIVO");
    					us.setClaseBoot2("btn-primary");
    				}
    				
    				if(rs.getString(5).equals("0")) {
    					us.setAtencionpref("INACTIVO");
    					us.setClaseBoot3("btn-outline-secondary");
    				}
    				else{
    					us.setAtencionpref("ACTIVO");
    					us.setClaseBoot3("btn-danger");
    				}

    				list.add(us);
    			}
    			return list;
    		}
    	});
	}

	public void insertarUsuario(Usuario us) {
		jdbcTemplate.update("insert into usuarios (user,pass,descripcion,estado) values(?,?,?,?) ",
                us.getUser(),us.getPass(),us.getDescripcion(),1);
		
	}

	public Usuario obtenerUsuarioById(String id) {
		String sql="select * from usuarios u where u.id_usuario='"+id+"' ";
		
		return (Usuario) jdbcTemplate.query(sql, new ResultSetExtractor<Usuario>() {
    		public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException{
    			Usuario us = new Usuario();
    			while(rs.next()) {
    				us.setId_usuario(rs.getString(1));
    				us.setUser(rs.getString(2));
    				us.setPass(rs.getString(3));
    				us.setDescripcion(rs.getString(4));
    				us.setEstado(rs.getString(9));
    			}
    			return us;
    		}
    	});
	}

	public void modificarUsuario(Usuario us) {
		jdbcTemplate.update("update usuarios set user=?,pass=?,descripcion=? where id_usuario=? ", 
				us.getUser(),us.getPass(),us.getDescripcion(),us.getId_usuario());
		
	}

	public void eliminarUsuario(String id) {
		jdbcTemplate.update("update usuarios set estado=0 where id_usuario=? ", id);
	}
	
	public void asignarCajeroActivo(Usuario us) {
		
		jdbcTemplate.update("update monitortickets set usuario=? where idcajero=?",
				us.getUser(),us.getIdCajero());
		
	}
	
	
	public List<Cajero> listarCajerosActivosNormal(Cajero c) {
		
		String sql="select * from monitortickets where normal=1 and usuario='' ";
    	
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Cajero>>() {
    		
    		public List<Cajero> extractData(ResultSet rs) throws SQLException, DataAccessException{
    			List<Cajero> list = new ArrayList<Cajero>();
    			while(rs.next()) {
    				Cajero c = new Cajero();

    				if(rs.getString(1)==null) {
    					c.setIdcajero("0");
    				}else {
    					c.setIdcajero(rs.getString(1));
    					c.setUsuario(rs.getString(2));
    				}
    				list.add(c);
    			}
    			return list;
    		}
    	});
	}
	
	public List<CajeroPref> listarCajerosActivosPref(CajeroPref cf) {
		
		String sql="select * from monitortickets where atencionpref=1 and usuario='' ";
    	
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<CajeroPref>>() {
    		
    		public List<CajeroPref> extractData(ResultSet rs) throws SQLException, DataAccessException{
    			List<CajeroPref> list = new ArrayList<CajeroPref>();
    			while(rs.next()) {
    				CajeroPref cf = new CajeroPref();

    				if(rs.getString(1)==null) {
    					cf.setIdcajero("0");
    				}else {
    					cf.setIdcajero(rs.getString(1));
    					cf.setUsuario(rs.getString(2));
    				}
    				list.add(cf);
    			}
    			return list;
    		}
    	});
	}
	
	public List<CajeroExcl> listarCajerosActivosExcl(CajeroExcl ce) {
		
		String sql="select * from monitortickets where excl=1 and usuario='' ";
    	
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<CajeroExcl>>() {
    		
    		public List<CajeroExcl> extractData(ResultSet rs) throws SQLException, DataAccessException{
    			List<CajeroExcl> list = new ArrayList<CajeroExcl>();
    			while(rs.next()) {
    				CajeroExcl ce = new CajeroExcl();

    				if(rs.getString(1)==null) {
    					ce.setIdcajero("0");
    				}else {
    					ce.setIdcajero(rs.getString(1));
    					ce.setUsuario(rs.getString(2));
    				}
    				list.add(ce);
    			}
    			return list;
    		}
    	});
	}

}
