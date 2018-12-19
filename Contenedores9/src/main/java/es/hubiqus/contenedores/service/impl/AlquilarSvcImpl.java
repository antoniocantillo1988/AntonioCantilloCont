package es.hubiqus.contenedores.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.contenedores.model.Alquilar;
import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.model.dao.AlquilarDao;
import es.hubiqus.contenedores.service.AlquilarSvc;
import es.hubiqus.contenedores.service.SvcException;

/**
 * Implementación del servicio, marcar con @Service
 * @author ACR
 *
 */
@Service
@Transactional
public class AlquilarSvcImpl implements AlquilarSvc{
	
	@Autowired
	private AlquilarDao dao;
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Alquilar alquilar) throws SvcException {
		try{
			dao.save(alquilar);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Alquilar alquilar) throws SvcException {
		try{
			dao.save(alquilar);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
	}

	@Override
	public Alquilar verMiAlquiler(int idusuarios) throws SvcException {
		Alquilar res = null;
		
		try{
			dao.findById(idusuarios);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		return res;
	}

	
	

	
	
}//fin clase