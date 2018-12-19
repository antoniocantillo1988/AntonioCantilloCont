package es.hubiqus.contenedores.model.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.contenedores.model.Privilegios;
import es.hubiqus.contenedores.model.dao.DaoException;
import es.hubiqus.contenedores.model.dao.PrivilegiosDao;

/**
 * Implementación del dao, marcar con @Repository
 * @author ajurado
 *
 */
@Repository
public class PrivilegiosDaoImpl implements PrivilegiosDao{

	@Autowired
	private SessionFactory sessionFactory;
	

//	@Override
//	public Privilegios find() throws DaoException {
//		Privilegios res = null;
//		
//		try{					
//			//res = (Privilegios) sessionFactory.getCurrentSession().get(Privilegios.class, tipo);
//			
//			res = (Privilegios) sessionFactory.getCurrentSession().createQuery("FROM Privilegios WHERE Privilegios.idprivilegios = 1").uniqueResult();
//				
//			
//		}catch (Exception ex){
//			throw new DaoException(ex);
//		}
//		
//		return res;
//	}


	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Privilegios> findAll() throws DaoException {
		Iterable<Privilegios> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("from Privilegios").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
