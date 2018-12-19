package es.hubiqus.contenedores.controller.alquilar;

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
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.contenedores.model.Alquilar;
import es.hubiqus.contenedores.service.AlquilarSvc;
import es.hubiqus.contenedores.service.ContenedoresSvc;

@Controller
public class ListarAlquilar {
	
	private static final Log log = LogFactory.getLog(ListarAlquilar.class);
	
	private static final String ATT_ITEM = "idusuarios";
	private static final String ATT_LISTA = "lista";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";
	
	private static final String FORM = "alquilarFormulario";
	private static final String SUCCESS = "alquilarListado";
	private static final String ERROR = "error";
		
	@Autowired
	private AlquilarSvc svc;
	
	@Autowired
	private ContenedoresSvc pSvc;
	
	@Autowired  
    private MessageSource messageSource;
	
	/**
	 * LISTAR MI ALQUILER GET: Carga una lista (que necesitaremos para un desplegable) y reedirige al Formulario
	 * @param idusuarios
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/formularioAlquiler", method=RequestMethod.GET)
    public String formularioAlquiler(@RequestAttribute int idusuarios, Model model, Locale locale){
    	try {
			//Listado
			model.addAttribute(ATT_LISTA, pSvc.listarContenedoresDisponibles());
			
			//Mandamos el idusuario
			model.addAttribute(ATT_ITEM, idusuarios);
			
			return FORM;
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	/**
	 * LISTADO MI ALQUILER POST: 
	 * Guarda el Alquiler realizado
	 * Devuelve una lista del alquiler que tendrá el usuario (Podrá tener mas de un alquiler)
	 * @param idusuarios
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/listadoMiAlquiler", method=RequestMethod.POST)
    public String listadoMiAlquiler(@RequestAttribute int idusuarios, @RequestParam Alquilar alquilar, Model model, Locale locale){
    	try {
			//Guardado
    		svc.guardar(alquilar);
			
			return formularioAlquiler(idusuarios, model, locale);
			
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	/**
	 * LISTADO MI ALQUILER: Muestra el alquiler del  usuario determinado
	 * @param idusuarios
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/VerMiAlquiler", method=RequestMethod.GET)
    public String VerMiAlquiler(@RequestAttribute int idusuarios, Model model, Locale locale){
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
	
	
	
}
