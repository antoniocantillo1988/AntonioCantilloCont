package es.hubiqus.contenedores.model.dao;

import java.util.List;
import es.hubiqus.contenedores.model.Usuario;

public interface UsuarioDao {

	/**
	 * Mostrar todos
	 * @return Lista de usuarios
	 * @throws DaoException error de bdd
	 */
	public List<Usuario> findAllUser() throws DaoException;
	/**
	 * Guarda un usuario 
	 * @param usuario
	 * @throws DaoException
	 */
	public void save(Usuario usuario) throws DaoException;
	
	/**
	 * Modifica un usuario
	 * @param usuario
	 * @throws DaoException
	 */
	public void update(Usuario usuario) throws DaoException;

	/**
	 * Elimina un usuario
	 * @param usuario
	 * @throws DaoException
	 */
	public void delete(Usuario usuario) throws DaoException;
	
	/**
	 * Busca un usuario
	 * @param  usuario
	 * @return optional usuario 
	 * @throws DaoException error de bdd
	 */
	public Usuario findByDniAndClave(String dni, String contrasenya) throws DaoException;
	
	/**
	 * Mostrar todoslos clientes
	 * @return Lista de usuaarios
	 * @throws DaoException error de bdd
	 */
	public List<Usuario> findClients() throws DaoException;
	
	/**
	 * Buscar por id
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Usuario findById(int id) throws DaoException;

	
	
}
