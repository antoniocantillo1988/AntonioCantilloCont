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
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.service.UsuarioSvc;

@Controller
@RequestMapping(value = "/usuario")
public class Borrar {
	
	private static final Log log = LogFactory.getLog(Borrar.class);
	
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_ERROR = "error.general";

	private static final String SUCCESS = "listarUsuarios";
	private static final String ERROR = "error";
	
	@Autowired
	private UsuarioSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
	
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
    public String borrar(@RequestParam int idusuarios, Model model, Locale locale){
		try {
			Usuario usuario = new Usuario();
			usuario.setIdusuarios(idusuarios);
			
			svc.eliminar(usuario);
			return SUCCESS;
			
		} catch (Exception e) {
			log.error(e);
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
    }

}
