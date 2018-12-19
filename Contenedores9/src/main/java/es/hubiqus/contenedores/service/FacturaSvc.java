package es.hubiqus.contenedores.service;

import java.util.Optional;

import es.hubiqus.contenedores.model.Factura;


public interface FacturaSvc {

	/**
	 * @param Factura factura
	 * @throws SvcException
	 */
	public void guardar(Factura factura) throws SvcException;

	/**
	 * @param id usuarios
	 * @return Lista facturas
	 * @throws SvcException
	 */
	public Iterable<Factura> listarFacturas(int idusuarios) throws SvcException;

	/**
	 * @param idusuarios
	 * @return boolean
	 * @throws SvcException
	 */
	public Optional<Factura> comprobarMes(int mes) throws SvcException;

	/**
	 * @throws SvcException
	 * @param factura
	 * @throws SvcException
	 */
	public void modificar(Factura factura) throws SvcException;
	
	/**
	 * Eliminar Factura
	 * @param factura
	 * @throws SvcException
	 */
	public void eliminar(Factura factura) throws SvcException;
	
}
