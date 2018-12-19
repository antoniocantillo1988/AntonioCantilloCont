package es.hubiqus.contenedores.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.model.dao.DaoException;
import es.hubiqus.contenedores.model.dao.UsuarioDao;

/**
 * Implementación del dao, marcar con @Repository
 * @author ajurado
 *
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUser() throws DaoException{
		List<Usuario> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("from Usuario").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public void save(Usuario usuario)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().save(usuario);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@Override
	public void update(Usuario usuario)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(usuario);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@Override
	public void delete(Usuario usuario)  throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(usuario);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findClients()  throws DaoException {
		List<Usuario> res = null;
		
		try{
			res = sessionFactory.getCurrentSession().createQuery("FROM Usuario WHERE Privilegios.idprivilegios = 1").list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
	
	@Override
	public Usuario findByDniAndClave(String dni, String contrasenya) throws DaoException {
		Usuario res = null;
		
		try{					
			String hql = "FROM Usuario u WHERE u.dni = :dni AND u.contrasenya = :contrasenya";
			
			res = (Usuario) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("dni", dni)
					.setParameter("contrasenya", contrasenya)
					.uniqueResult();
	
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}	
		
		return res;
	}


	@Override
	public Usuario findById(int id) throws DaoException {
		Usuario res = null;
		
		try{					
			res = (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
	
	
	
}
