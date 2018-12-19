package es.hubiqus.contenedores.service;

import java.util.Optional;

import es.hubiqus.contenedores.model.Privilegios;
import es.hubiqus.contenedores.model.Usuario;


public interface UsuarioSvc {

	/**
	 * @param usuario
	 * @return Usuario encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Usuario identificar(Usuario usuario) throws SvcException;

	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Usuario> listar() throws SvcException;
	
	/**
	 * Listar todos los clientes
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Usuario> listarClientes() throws SvcException;
	
	/**
	 * Guardar un elemento
	 * @param usuario elemento a guardar
	 * @throws SvcException
	 */
	public void guardar(Usuario usuario) throws SvcException;
	
	/**
	 * Actualizar un elemento
	 * @param usuario elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Usuario usuario) throws SvcException;

	/**
	 * Eliminar un elemento
	 * @param usuasrio elemento a eliminar
	 * @throws SvcException
	 */
	public void eliminar(Usuario usuario) throws SvcException;
	
	
	/**
	 * Comprobar si un usuario dispone de permisos de acceso
	 * @param usuario usuario a comprobar
	 * @param uri recurso a comprobar
	 * @return true si dispone de permiso
	 * @throws SvcException
	 */
	public boolean comprobar(Usuario usuario, String uri) throws SvcException;

	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return usuario encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Usuario buscar(int idusuarios) throws SvcException;
	
	/**
	 * BUSCA PRIVILEGIOS DEL USUARIo
	 * @param idusuarios
	 * @return Privilegios
	 */
	public Privilegios privilegiosUsuario(int idusuarios);
	
	
	
}
