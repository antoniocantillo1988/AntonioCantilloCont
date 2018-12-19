package es.hubiqus.contenedores.model.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.contenedores.model.Factura;
import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.model.dao.DaoException;
import es.hubiqus.contenedores.model.dao.FacturaDao;

/**
 * Implementación del dao, marcar con @Repository
 * @author ajurado
 *
 */
@Repository
public class FacturaDaoImpl implements FacturaDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> findAll() throws DaoException{
		List<Factura> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("from Factura").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public void save(Factura usuario)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().save(usuario);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	
	@Override
	public void delete(Factura usuario)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(usuario);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public Factura findById(Usuario idusuarios) throws DaoException {
		Factura res = null;
		
		try{					
			String hql = "FROM Factura u WHERE u.idfactura = :idfactura";
			
			res = (Factura) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("idusuarios", idusuarios)
					.uniqueResult();
	
		}catch (Exception ex){
			throw new DaoException(ex);
		}	
		
		return res;
	}
	
			
			
	@Override
	public Optional<Factura> findMonth(int mes) throws DaoException {
		Optional<Factura> res = Optional.empty();	
		
		try{
			String hql = "FROM tabla WHERE MONTH(fechaactual) = :mes";
			
			Factura item = (Factura) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("mes", mes)
					.uniqueResult();
			
			if (item != null) {
				res = Optional.of(item);
			}
		}catch (Exception ex){
			throw new DaoException(ex);
		}
						
		return res;
	}
	
	
}
