package es.hubiqus.contenedores.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.contenedores.model.Contenedor;
import es.hubiqus.contenedores.model.dao.ContenedoresDao;
import es.hubiqus.contenedores.model.dao.DaoException;

/**
 * Implementación del dao, marcar con @Repository
 * @author ajurado
 *
 */
@Repository
public class ContenedoresDaoImpl implements ContenedoresDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contenedor> listAll() throws DaoException{
		List<Contenedor> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("FROM Contenedor").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public void save(Contenedor contenedor)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().save(contenedor);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@Override
	public void update(Contenedor contenedor)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(contenedor);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@Override
	public void delete(Contenedor contenedor)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(contenedor);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Contenedor> listAvaiable()  throws DaoException {
		List<Contenedor> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("FROM Contenedor WHERE disponibilidad = 1").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
	
}