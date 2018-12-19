package es.hubiqus.contenedores.service;

import es.hubiqus.contenedores.model.Privilegios;

public interface PrivilegiosSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Privilegios> listar() throws SvcException;

//	/**
//	 * Busca los privilegios del tipo de cliente introducido
//	 * @return Privilegios
//	 * @throws SvcException
//	 */
//	public Privilegios comprobarPrivilegios() throws SvcException;
	
	
}
