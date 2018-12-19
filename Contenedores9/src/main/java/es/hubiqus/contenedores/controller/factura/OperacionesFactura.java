package es.hubiqus.contenedores.controller.factura;

import java.util.Calendar;
import java.util.Locale;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.contenedores.model.Factura;
import es.hubiqus.contenedores.service.FacturaSvc;
import es.hubiqus.contenedores.service.SvcException;

@Controller
@RequestMapping(value = "/factura")
public class OperacionesFactura {
	
	Calendar fecha = Calendar.getInstance();
	private int mes = fecha.get(Calendar.MONTH) + 1;
	
	private static final Log log = LogFactory.getLog(OperacionesFactura.class);
	private static final String ATT_LISTA = "lista";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";
	private static final String MSG_FACTURA_DUPLICADA = "factura.error.duplicado";
	private static final String MSG_FACTURA_GUARDADA = "factura.guardada";
	
	private static final String ERROR = "error";
	private static final String FORM = "facturaFormulario";		
	private static final String SUCCESS = "facturaListado";
	
	@Autowired
	private FacturaSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
		
	/**
	 * FACTURA/VERMIFACTURA, metodo que lista mis factura
	 * @param idusuarios
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/verMiFactura", method=RequestMethod.GET)
    public String listadoFactura(@RequestParam int idusuarios, Model model, Locale locale){
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
	
	/**
	 * FACTURA/REGISTRAR GET:  Metodo que simplemente reedirige al formulario
	 * @param factura
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registrar", method=RequestMethod.GET)
    public String view(@ModelAttribute Factura factura, Model model) {
		return FORM;
	}
	
	/**
	 * FACTURA/REGISTRAR POST: METODO QUE GUARDA EL FORMULARIO COMPROBANDO QUE ESTE MES YA TIENE FACTURA
	 * @param factura
	 * @param result
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/registrar", method=RequestMethod.POST)
    public String registro(@Valid Factura factura, BindingResult result, Model model, Locale locale){
		try{
			if (result.hasErrors()){
				return FORM;
			}else{
				
				System.out.println("EL MES DE MI FACTURA ES" + svc.comprobarMes(mes));	
				//if(mes!= (svc.comprobarMes(factura.getIdusuario()).getFechaactual().getMonth())) {
				
				if(svc.comprobarMes(mes) == null) {
					
					System.out.println("GUARDAMOS la factura "+factura);
				
					svc.guardar(factura);
				
					model.addAttribute(ATT_MSG,
							messageSource.getMessage(MSG_FACTURA_GUARDADA, null, locale));
				
				}else {
					
					model.addAttribute(ATT_MSG,
							messageSource.getMessage(MSG_FACTURA_DUPLICADA, null, locale));
					
				}
				
				return SUCCESS;				
				
			}			
		}catch (SvcException ex){
			log.error(ex);
			
			return FORM;
		}catch (Exception ex){
			log.error(ex);
			
			return FORM;
		}
	}
	

}