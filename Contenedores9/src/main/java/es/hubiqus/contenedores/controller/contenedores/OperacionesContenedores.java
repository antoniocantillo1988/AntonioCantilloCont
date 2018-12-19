package es.hubiqus.contenedores.controller.contenedores;

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

import es.hubiqus.contenedores.model.Contenedor;
import es.hubiqus.contenedores.service.ContenedoresSvc;
import es.hubiqus.contenedores.service.SvcException;

@Controller
@RequestMapping(value = "/contenedor")
public class OperacionesContenedores {
	
	private static final Log log = LogFactory.getLog(OperacionesContenedores.class);
	private static final String ATT_LISTA = "lista";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";
	private static final String MSG_EXITO = "mensaje.exito";
	
	private static final String ERROR = "error";
	private static final String FORM = "formContenedores";		
	private static final String SUCCESS = "listadoContenedores";
	
	@Autowired
	private ContenedoresSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
	
	/**
	 * CONTENEDOR/GUARDARCONTENEDOR GET: Simplemente redirige al formulario
	 * @param contenedor
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/guardarContenedor", method=RequestMethod.GET)
    public String guardarContenedor(@ModelAttribute Contenedor contenedor, Model model) {
		return FORM;
	}
	
	/**
	 * CONTENEDOR/GUARDARCONTENEDOR POST: realiza el guardado del contenedor y redirige al listado 
	 * @param contenedor
	 * @param result
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/guardarContenedor", method=RequestMethod.POST)
    public String guardarContenedor(@Valid Contenedor contenedor, BindingResult result, Model model, Locale locale){
		try{
			if (result.hasErrors()){
				return FORM;
			}else{
				
				//REALIZAMOS EL GUARDADO
				svc.guardar(contenedor);		
				
				//AÑADIMOS EL MENSAJE
				model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_EXITO, null, locale));
				
				return listadoContenedores(model, locale);
				
				
			}			
		}catch (SvcException ex){
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			
			}
			return FORM;
		
	}
	
	/**
	 * CONTENEDOR/LISTAR : Metodo que muestra el listado de contenedores sin filtro 
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listadoContenedores(Model model, Locale locale){
    	try {
			//Listado
			model.addAttribute(ATT_LISTA, svc.listarContenedores());
			
			return SUCCESS;
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	/**
	 * CONTENEDOR/LISTARDISPONIBILIDAD: Metodo que muestra el listado de contenedores según disponibilidad
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/listarDisponibilidad", method=RequestMethod.GET)
    public String listadoContenedoresDisponibles(Model model, Locale locale){
		
		try {
			//Listado
			model.addAttribute(ATT_LISTA, svc.listarContenedoresDisponibles());
			
			return SUCCESS;
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	/**
	 * CONTENDOR/BORRAR: Metodo que recibe un id y elimina el contenedor, reedirige al listado
	 * @param idcontenedor
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
    public String borrar(@RequestParam int idcontenedor, Model model, Locale locale){
		try {
			Contenedor contenedor = new Contenedor();
			contenedor.setIdcontenedor(idcontenedor);
			
			svc.eliminar(contenedor);
			
			//AÑADIMOS EL MENSAJE
			model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_EXITO, null, locale));	
			
			return listadoContenedores(model, locale);
			
		} catch (Exception e) {
			log.error(e);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	
	

}