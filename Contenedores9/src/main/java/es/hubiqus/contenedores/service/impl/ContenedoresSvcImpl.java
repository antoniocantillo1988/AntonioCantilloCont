package es.hubiqus.contenedores.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.contenedores.model.Contenedor;
import es.hubiqus.contenedores.model.dao.ContenedoresDao;
import es.hubiqus.contenedores.service.ContenedoresSvc;
import es.hubiqus.contenedores.service.SvcException;

/**
 * Implementación del servicio, marcar con @Service
 * @author ajurado
 *
 */
@Service
@Transactional
public class ContenedoresSvcImpl implements ContenedoresSvc{
		
	@Autowired
	private ContenedoresDao dao;	

	@Override
	public Iterable<Contenedor> listarContenedores() throws SvcException {
		Iterable<Contenedor> res = null;
		
		try{
			res = dao.listAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	
	@Override
	public Iterable<Contenedor> listarContenedoresDisponibles() throws SvcException {
		Iterable<Contenedor> res = null;
		
		try{
			res = dao.listAvaiable();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Contenedor contenedor) throws SvcException {
		try{
			dao.save(contenedor);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}


	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Contenedor contenedor) throws SvcException {
		try{
			dao.update(contenedor);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Contenedor contenedor) throws SvcException {		
		try{
//			producto = buscar(producto.getId());
			dao.delete(contenedor);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
		
//		return producto;
		
	}
	
	
}//fin clase