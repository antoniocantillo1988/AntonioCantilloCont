package es.hubiqus.contenedores.model.dao;

import java.util.List;
import es.hubiqus.contenedores.model.Contenedor;

public interface ContenedoresDao {

	/**
	 * Mostrar todos
	 * @return Lista de contenedores
	 * @throws DaoException error de bdd
	 */
	public List<Contenedor> listAll() throws DaoException;
	/**
	 * Guarda un contenedor 
	 * @param contenedor
	 * @throws DaoException
	 */
	public void save(Contenedor contenedor) throws DaoException;
	
	/**
	 * Modifica un contenedor
	 * @param contenedor
	 * @throws DaoException
	 */
	public void update(Contenedor contenedor) throws DaoException;

	/**
	 * Elimina un contnedor
	 * @param contnedor
	 * @throws DaoException
	 */
	public void delete(Contenedor contenedor) throws DaoException;
	
	/**
	 * Mostrar contenedores disponibles
	 * @return Lista de contenedores
	 * @throws DaoException error de bdd
	 */
	public List<Contenedor> listAvaiable() throws DaoException;

	
	
}
