package es.hubiqus.contenedores.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.contenedores.model.Privilegios;
import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.model.dao.UsuarioDao;
import es.hubiqus.contenedores.service.SvcException;
import es.hubiqus.contenedores.service.UsuarioSvc;

/**
 * Implementación del servicio, marcar con @Service
 * @author ajurado
 *
 */
@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc{
	
//	private static final String URI_INICIO = "inicio";
//	private static final String URI_ERROR = "error";
//	private static final String URI_FACTURA_FORM = "facturaFormulario";
//	private static final String URI_FACTURA_LIST = "facturaListado";
//	private static final String URI_ALQUILAR_FORM = "alquilarFormulario";
//	private static final String URI_ALQUILAR_LIST = "alquilarListado";
//	private static final String URI_CONTENEDOR_LIST_DISPONIBLES = "/listarDisponibilidad";
//	private static final String URI_LOGIN = "login";
	
	@Autowired
	private UsuarioDao dao;	

	@Override
	public Usuario identificar(Usuario usuario) throws SvcException {
		Usuario res = null;
		
		try{
			
			res = dao.findByDniAndClave(usuario.getDni(), usuario.getContrasenya());
			
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public boolean comprobar(Usuario usuario, String uri) throws SvcException {
		switch (usuario.getPrivilegios().getIdprivilegios()){
		case 1:
			return true;
		
		case 2:
			return true;
					
					
//					(uri.contains(URI_INICIO) || 
//					uri.contains(URI_ERROR) || 
//					uri.contains(URI_FACTURA_FORM) || 
//					uri.contains(URI_FACTURA_LIST) || 
//					uri.contains(URI_ALQUILAR_FORM) || 
//					uri.contains(URI_ALQUILAR_LIST) ||
//					uri.contains(URI_CONTENEDOR_LIST_DISPONIBLES) ||
//					uri.contains(URI_LOGIN));
		
		case 3:
			return true;
			
		default:
			return false;
		}
	}

	@Override
	public Iterable<Usuario> listar() throws SvcException {
		Iterable<Usuario> res = null;
		
		try{
			res = dao.findAllUser();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	
	@Override
	public Iterable<Usuario> listarClientes() throws SvcException {
		Iterable<Usuario> res = null;
		
		try{
			res = dao.findClients();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Usuario usuario) throws SvcException {
		try{
			
			System.out.println("usuario es "+ usuario);
			
			dao.save(usuario);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}


	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Usuario usuario) throws SvcException {
		try{
			dao.update(usuario);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Usuario usuario) throws SvcException {		
		try{

			dao.delete(usuario);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
		
		
	}
	
	
	@Override
	public Usuario buscar(int idusuarios) throws SvcException {
		Usuario res = null;
		
		try{
			res = dao.findById(idusuarios); 
			
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Privilegios privilegiosUsuario(int idusuarios) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}//fin clase