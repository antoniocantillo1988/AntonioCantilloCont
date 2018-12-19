package es.hubiqus.contenedores.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.contenedores.model.Factura;
import es.hubiqus.contenedores.model.dao.FacturaDao;
import es.hubiqus.contenedores.service.FacturaSvc;
import es.hubiqus.contenedores.service.SvcException;

/**
 * Implementación del servicio, marcar con @Service
 * @author ajurado
 *
 */
@Service
@Transactional
public class FacturaSvcImpl implements FacturaSvc{
	
	@Autowired
	private FacturaDao dao;

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Factura factura) throws SvcException {
		try{
			dao.save(factura);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
	}

	@Override
	public Iterable<Factura> listarFacturas(int idusuarios) throws SvcException {
		Iterable<Factura> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Optional<Factura> comprobarMes(int mes) throws SvcException {
		Optional<Factura> res = null;
		
		try{
			res = dao.findMonth(mes); 
			
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
		
	}
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Factura factura) throws SvcException {
		try{
			dao.save(factura);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
	}

	@Override
	public void eliminar(Factura factura) throws SvcException {
		try{
			dao.delete(factura);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
	}
	

	
	
}//fin clase