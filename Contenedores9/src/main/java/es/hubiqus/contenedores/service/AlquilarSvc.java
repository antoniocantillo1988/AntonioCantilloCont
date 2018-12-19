package es.hubiqus.contenedores.service;

import es.hubiqus.contenedores.model.Alquilar;


public interface AlquilarSvc {

	/**
	 * @param alquilar
	 * @throws SvcException
	 */
	public void guardar(Alquilar alquilar) throws SvcException;
	
	/**
	 * @param alquilar
	 * @throws SvcException
	 */
	public void modificar(Alquilar alquilar) throws SvcException;

	/**
	 * 
	 * @param idusuarios
	 * @return
	 * @throws SvcException
	 */
	public Alquilar verMiAlquiler(int idusuarios)  throws SvcException;;


	
	
}
