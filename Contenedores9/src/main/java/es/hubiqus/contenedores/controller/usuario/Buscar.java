package es.hubiqus.contenedores.controller.usuario;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.contenedores.model.Privilegios;
import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.service.PrivilegiosSvc;
import es.hubiqus.contenedores.service.SvcException;
import es.hubiqus.contenedores.service.UsuarioSvc;

@Controller
@RequestMapping(value = "/usuario")
public class Buscar {
	
	private static final Log log = LogFactory.getLog(Login.class);
	
	private static final String ATT_ITEM = "usuario";
	private static final String ATT_IDPRIVILEGIOS = "idprivilegios";
	private static final String ATT_ERROR = "error";

	private static final String ATT_MSG = "msg";
	
//	private static final String MSG_ERROR = "error.general";
	private static final String MSG_EXITO = "mensaje.exito";
	private static final String MSG_REGISTRO_ERROR = "usuario.registro.error";
	private static final String MSG_ERROR_CLAVE = "usuario.registro.error.clave";
	
	private static final String FORM = "form";
	private static final String ERROR = "error";
	
	private static final String LISTADO = "redirect:/usuario/listarUsuarios";
	
	@Autowired
	private UsuarioSvc svc;

	@Autowired  
    private MessageSource messageSource;
	
//	@Autowired
//	private PrivilegiosSvc pSvc;

	/**
	 * USUARIO/BUSCAR, Metodo que realiza la busqueda del idusuario que recibe por Parametro
	 * @param idusuarios
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
    public String execute(@RequestParam int idusuarios, Model model){//, HttpServletRequest request) {
    	try {
			
    		System.out.println("ENTRA");
    		
    		//No es necesario acceder al request para el parámetro, directamente lo paso por el método
			model.addAttribute(ATT_ITEM, svc.buscar(idusuarios));
			
			//Incluir elementos para el formulario
			model.addAttribute(ATT_IDPRIVILEGIOS, svc.buscar(idusuarios).getPrivilegios().getIdprivilegios().intValue());
			
			System.out.println("ESTOS SON LOS PRIVILEGIOS"+svc.buscar(idusuarios).getPrivilegios().getIdprivilegios().intValue());
			
			return FORM;
			
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			
			log.error(e);
			
			return ERROR;
		}
    }

	
	/**
	 * USUARIO/MODIFICAR , METODO QUE realiza el guardado del usuario que sera siempre de privilegio cliente
	 * @param usuario
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/modificar", method=RequestMethod.POST)
    public String Modificar(@Valid Usuario usuario, BindingResult result, Model model, Locale locale){
		try{
			if (result.hasErrors()){
				return FORM;
			}else{
				
				if(usuario.getClaveRepetida()!=usuario.getContrasenya()) {
				
					System.out.println("MOSTRAMOS EL TIPO DEL UISUARIO"+usuario.getPrivilegios().getIdprivilegios());
					
					//Establecer el mismo tipo de usuario
					Privilegios tipo = new Privilegios();
					tipo.setIdprivilegios(usuario.getPrivilegios().getIdprivilegios());
					usuario.setPrivilegios(tipo);	
					
					svc.guardar(usuario);
					
					//AÑADIMOS EL MENSAJE DE EXITO
					model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_EXITO, null, locale));	
				
				}else {
					
					//AÑADIMOS EL MENSAJE DE ERROR
					model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_ERROR_CLAVE, null, locale));
						
					return FORM;
					
				}	
					
				return LISTADO;
			}			
		}catch (SvcException ex){
			//AÑADIMOS EL MENSAJE DE ERROR
			model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_REGISTRO_ERROR, null, locale));	
			
			//REDIRIGIMOS A ERROR.jsp
			model.addAttribute(ATT_ERROR, ex);
			
			log.error(ex);
			
			return FORM;
		}catch (Exception ex){
			//AÑADIMOS EL MENSAJE DE ERROR
			model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_REGISTRO_ERROR, null, locale));	
			
			//REDIRIGIMOS A ERROR.jsp
			model.addAttribute(ATT_ERROR, ex);
			
			log.error(ex);
			
			return FORM;
		}
	}
	
	
	
	
	
}
