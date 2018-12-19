package es.hubiqus.contenedores.model.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.contenedores.model.Alquilar;
import es.hubiqus.contenedores.model.dao.AlquilarDao;
import es.hubiqus.contenedores.model.dao.DaoException;

/**
 * Implementación del dao, marcar con @Repository
 * @author ACR
 *
 */
@Repository
public class AlquilarDaoImpl implements AlquilarDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Alquilar> findAll() throws DaoException{
		List<Alquilar> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("from Alquilar").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public void save(Alquilar alquilar)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().save(alquilar);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@Override
	public void delete(Alquilar alquilar)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(alquilar);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}


	@Override
	public Optional<Alquilar> findById(int idusuarios) throws DaoException {
		Optional<Alquilar> res = Optional.empty();
		
		try{					
			String hql = "FROM Alquilar u WHERE u.idusuarios = :idusuarios";
			
			Alquilar item = (Alquilar) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("idusuarios", idusuarios)
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
