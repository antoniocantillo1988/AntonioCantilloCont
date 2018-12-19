package es.hubiqus.contenedores.service;

import es.hubiqus.contenedores.model.Contenedor;


public interface ContenedoresSvc {
	
	/**
	 * @return LIST
	 * @throws SvcException
	 */
	public Iterable<Contenedor> listarContenedores() throws SvcException;
	
	/**
	 * @return LIST
	 * @throws SvcException
	 */
	public Iterable<Contenedor> listarContenedoresDisponibles() throws SvcException;

	/**
	 * Modificar Contenedor
	 * @param contenedor
	 * @throws SvcException
	 */
	void modificar(Contenedor contenedor) throws SvcException;

	/**
	 * Guardar Contenedor
	 * @param contenedor
	 * @throws SvcException
	 */
	void guardar(Contenedor contenedor) throws SvcException;

	/**
	 * Eliminar Contenedor
	 * @param contenedor
	 * @throws SvcException
	 */
	void eliminar(Contenedor contenedor) throws SvcException;
	
	
}
