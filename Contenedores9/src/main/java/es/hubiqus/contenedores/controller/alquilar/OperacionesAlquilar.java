package es.hubiqus.contenedores.controller.alquilar;

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

import es.hubiqus.contenedores.model.Alquilar;
import es.hubiqus.contenedores.service.AlquilarSvc;
import es.hubiqus.contenedores.service.SvcException;

@Controller
@RequestMapping(value = "/alquilar")
public class OperacionesAlquilar {
	
	private static final Log log = LogFactory.getLog(OperacionesAlquilar.class);
	private static final String ATT_LISTA = "lista";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";
	
	private static final String ERROR = "error";
	private static final String FORM = "alquilarFormulario";		
	private static final String SUCCESS = "alquilarListado";
	
	@Autowired
	private AlquilarSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
		
	/**
	 * ALQUILAR/VERMIALQUILER, metodo que lista mis alquiler
	 * @param idusuarios
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/verMiAlquiler", method=RequestMethod.GET)
    public String listadoAlquiler(@RequestParam int idusuarios, Model model, Locale locale){
    	try {
			//Listado
			model.addAttribute(ATT_LISTA, svc.verMiAlquiler(idusuarios));
			
			return SUCCESS;
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	/**
	 * ALQUILAR/REGISTRAR GET:  Metodo que simplemente reedirige al formulario
	 * @param alquilar
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registrar", method=RequestMethod.GET)
    public String view(@ModelAttribute Alquilar alquilar, Model model) {
		return FORM;
	}
	
	/**
	 * ALQUILAR/REGISTRAR POST: METODO QUE GUARDA EL FORMULARIO COMPROBANDO QUE ESTE MES YA TIENE ALQUILER
	 * @param alquilar
	 * @param result
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/registrar", method=RequestMethod.POST)
    public String registro(@Valid Alquilar alquilar, BindingResult result, Model model, Locale locale){
		try{
			if (result.hasErrors()){
				return FORM;
			}else{
				
				svc.guardar(alquilar);
			
			}
				
			return SUCCESS;				
				
						
		}catch (SvcException ex){
			log.error(ex);
			
			return FORM;
		}catch (Exception ex){
			log.error(ex);
			
			return FORM;
		}
	}
	

}