package es.hubiqus.contenedores.model.dao;

import es.hubiqus.contenedores.model.Privilegios;

public interface PrivilegiosDao {

	
//	/**
//	 * Consulta los privilegios del usuario
//	 * @param idusuarios
//	 * @return Privilegios
//	 * @throws DaoException
//	 */
//	public Privilegios find() throws DaoException;
	
	/**
	 * Consulta los privilegios del usuario
	 * @return Privilegios
	 * @throws DaoException
	 */
	public Iterable<Privilegios> findAll() throws DaoException;
	
}
