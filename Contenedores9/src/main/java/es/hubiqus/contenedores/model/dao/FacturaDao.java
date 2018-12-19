package es.hubiqus.contenedores.model.dao;

import java.util.List;
import java.util.Optional;

import es.hubiqus.contenedores.model.Factura;
import es.hubiqus.contenedores.model.Usuario;

public interface FacturaDao {

	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return usuario encontrado, null si no lo encuentra
	 * @throws DaoException error de bdd
	 */
	public Factura findById(Usuario idusuarios) throws DaoException;

	/**
	 * Mostrar todos
	 * @return Lista de usuarios
	 * @throws DaoException error de bdd
	 */
	public List<Factura> findAll() throws DaoException;
	
	/**
	 * Guardar
	 * @param factura
	 * @throws DaoException
	 */
	public void save(Factura factura) throws DaoException;
	
	/**
	 * ELIMINAR
	 * @param factura
	 * @throws DaoException
	 */
	public void delete(Factura factura) throws DaoException;

	/**
	 * CONSULTAMOS EL MES ACTUAl
	 * @param mes
	 * @return
	 * @throws DaoException
	 */
	public Optional<Factura> findMonth(int mes) throws DaoException;

	
	
}
