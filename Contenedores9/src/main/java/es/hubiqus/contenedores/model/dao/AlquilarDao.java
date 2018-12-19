package es.hubiqus.contenedores.model.dao;

import java.util.List;
import java.util.Optional;

import es.hubiqus.contenedores.model.Alquilar;

public interface AlquilarDao {

	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return Alquiler encontrado, null si no lo encuentra
	 * @throws DaoException error de bdd
	 */
	public Optional<Alquilar> findById(int id) throws DaoException;
	
	/**
	 * Mostrar todos
	 * @return Lista de usuarios
	 * @throws DaoException error de bdd
	 */
	public List<Alquilar> findAll() throws DaoException;

	/**
	 * Guardar ALQUILER
	 * @param usuario
	 * @throws DaoException
	 */
	public void save(Alquilar alquilar) throws DaoException;
	
	/**
	 * ELiminar ALQUILER
	 * @param usuario
	 * @throws DaoException
	 */
	public void delete(Alquilar alquilar) throws DaoException;

	
	
}
