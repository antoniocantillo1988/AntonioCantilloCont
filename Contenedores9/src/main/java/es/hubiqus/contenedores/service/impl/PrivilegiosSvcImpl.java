package es.hubiqus.contenedores.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.contenedores.model.Privilegios;
import es.hubiqus.contenedores.model.dao.PrivilegiosDao;
import es.hubiqus.contenedores.service.PrivilegiosSvc;
import es.hubiqus.contenedores.service.SvcException;

/**
 * Implementación del servicio, marcar con @Service
 * @author ajurado
 *
 */
@Service
@Transactional
public class PrivilegiosSvcImpl implements PrivilegiosSvc{
	
	@Autowired
	private PrivilegiosDao dao;

//	@Override
//	public Privilegios comprobarPrivilegios() throws SvcException {
//		Privilegios res = null;
//		
//		try{
//			res = dao.find();
//		}catch (Exception ex){
//			throw new SvcException(ex);
//		}
//		
//		return res;
//	}

	@Override
	public Iterable<Privilegios> listar() throws SvcException {
		Iterable<Privilegios> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
