package es.hubiqus.contenedores.controller.usuario;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.contenedores.service.UsuarioSvc;

@Controller
@RequestMapping(value = "/usuario")
public class Listar {
	
	private static final Log log = LogFactory.getLog(Listar.class);
	
	private static final String ATT_LISTA = "lista";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";

	private static final String SUCCESS = "listar";	
	private static final String ERROR = "error";
		
	@Autowired
	private UsuarioSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
	
	/**
	 * USUARIO/LISTARCLIENTES, Metodo que lista solo a los clientes y redirige al usuario/lista.jsp
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/listarClientes", method=RequestMethod.GET)
    public String listadoClientes(Model model, Locale locale){
    	try {
			//Listado
			model.addAttribute(ATT_LISTA, svc.listarClientes());
			
			return SUCCESS;
			
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
	/**
	 * USUARIO/LISTARUSUARIOS, Metodo que lista todos sin filtro y redirige a usuario/lista.jsp
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/listarUsuarios", method=RequestMethod.GET)
    public String listadoUsuarios(Model model, Locale locale){
    	try {
			//Listado
			model.addAttribute(ATT_LISTA, svc.listar());
			
			return SUCCESS;
		} catch (Exception ex) {
			log.error(ex);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }
	
}
