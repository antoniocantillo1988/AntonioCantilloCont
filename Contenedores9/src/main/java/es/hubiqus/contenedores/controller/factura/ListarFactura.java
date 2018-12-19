package es.hubiqus.contenedores.controller.factura;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.contenedores.service.FacturaSvc;

@Controller
public class ListarFactura {
	
	private static final Log log = LogFactory.getLog(ListarFactura.class);
	
	private static final String ATT_LISTA = "lista";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";
	
	private static final String SUCCESS = "facturaListado";
	private static final String ERROR = "error";
		
	@Autowired
	private FacturaSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
	
	/**
	 * LISTARMIFACTURA , metoodo que recibe un id y muestra la factura en factura/lista.jsp
	 * @param idusuarios
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/listarMiFactura", method=RequestMethod.GET)
    public String listadoFactura(@RequestAttribute int idusuarios, Model model, Locale locale){
    	try {
			//Listado
			model.addAttribute(ATT_LISTA, svc.listarFacturas(idusuarios));
			
			return SUCCESS;
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
}
