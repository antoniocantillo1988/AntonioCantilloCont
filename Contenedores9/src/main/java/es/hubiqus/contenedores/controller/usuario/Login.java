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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import es.hubiqus.contenedores.interceptor.LoginInterceptor;
import es.hubiqus.contenedores.model.Privilegios;
import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.service.SvcException;
import es.hubiqus.contenedores.service.UsuarioSvc;

@Controller
@SessionAttributes({"sessionUser"})
@RequestMapping(value = "/usuario")
public class Login {
	
	private static final Log log = LogFactory.getLog(Login.class);

	private static final String ATT_ITEM = "usuario";
	private static final String ATT_MSG = "msg";
	private static final String MSG_EXITO = "mensaje.exito";
	private static final String MSG_LOGIN_ERROR = "usuario.login.error";
	private static final String MSG_REGISTRO_ERROR = "usuario.registro.error";
	
	private static final String FORM = "form";	
	private static final String LOGIN = "login";	
	private static final String SUCCESS = "inicio";
	
	private static final String LISTADO = "redirect:/usuario/listarUsuarios";
	private static final String INICIO = "redirect:/usuario/login";
	private static final String ERROR = "error";
	
	@Autowired
	private UsuarioSvc svc;
	
	@Autowired  
    private MessageSource messageSource;
	
	
	/**
	 * Nos dirigimos al formulario login
	 * @param usuario
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(@ModelAttribute Usuario usuario, Model model) {
		return LOGIN;
	}
	
	/**
	 * Salimos de la session
	 * @param model
	 * @param sessionStatus
	 * @return
	 */
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus){
		//Destrucción de la sesión
		sessionStatus.setComplete();
		//Hace un redirect, para completar el cierre de sesión
		return INICIO;
	}
	
	/**
	 * Guardamos el formulario
	 * @param usuario
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
    public String logearse(@Valid Usuario usuario, BindingResult result, Model model, Locale locale){
		try {
			//No tiene en cuenta validación del resto de campos (registro)
			if (result.getFieldError("dni") != null || 	result.getFieldError("contrasenya") != null){
				return LOGIN;
			}else{
				usuario = svc.identificar(usuario);
				if (usuario == null){
			
					return LOGIN;
				}else{
					inicializar(usuario, model);
					
					model.addAttribute(ATT_MSG,
							messageSource.getMessage(MSG_LOGIN_ERROR, null, locale));
					
					
					return SUCCESS;
				}
			}
		} catch (Exception ex) {
			log.error(ex);
		
			return LOGIN;
		}
    }
	
	/**
	 * Inicializar la sesión
	 * @param usuario
	 * @param model
	 */
	private void inicializar(Usuario usuario, Model model){	
		
		//Agregar el usuario a la sesión para el interceptor
		model.addAttribute(LoginInterceptor.ATT_USER, usuario);
	}
	
	/**
	 * Dirigimos al formulario
	 * @param usuario
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registrar", method=RequestMethod.GET)
    public String view(@ModelAttribute Usuario usuario, Model model, Locale locale) {
		
		try {
			
			model.addAttribute(ATT_ITEM, svc.buscar(usuario.getIdusuarios()));
			
			
			return FORM;
			
		} catch (SvcException e) {
			log.error(e);

			//AÑADIMOS EL MENSAJE DE ERROR
			model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_REGISTRO_ERROR, null, locale));	
			
			return ERROR;
		}
		
	}
	
	/**
	 * Dirigimos al Controlador guardar, recibiendo el formulario, y dependiendo 
	 * si le llega el idusuario o no redirigimos a guardar o a modificar
	 * @param usuario
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registrar", method=RequestMethod.POST)
    public String registro(@Valid Usuario usuario, BindingResult result, Model model, Locale locale){
		try{
			if (result.hasErrors()){
				return FORM;
			}else{
				
				System.out.println("ENTRA EN EL CONTROLADRO"+usuario);
				System.out.println("TIPO USUARIO"+usuario.getPrivilegios().getIdprivilegios());
				
				
				if(usuario.getIdusuarios()==null) {
					
					//Establecer el tipo usuario
					Privilegios tipo = new Privilegios();
					tipo.setIdprivilegios(1);
					usuario.setPrivilegios(tipo);	
					
					svc.guardar(usuario);
					
				}else {
					
					//Establecer el mismo tipo
					Privilegios tipo = new Privilegios();
					tipo.setIdprivilegios(usuario.getPrivilegios().getIdprivilegios());
					usuario.setPrivilegios(tipo);
					
					svc.modificar(usuario);
					
				}
				
				
				//AÑADIMOS EL MENSAJE DE EXITO
				model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_EXITO, null, locale));	
					
				return LISTADO;
			}			
		}catch (SvcException ex){
			log.error(ex);

			//AÑADIMOS EL MENSAJE DE ERROR
			model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_REGISTRO_ERROR, null, locale));	
			
			return FORM;
		}catch (Exception ex){
			log.error(ex);

			//AÑADIMOS EL MENSAJE DE ERROR
			model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_REGISTRO_ERROR, null, locale));	
			
			return FORM;
		}
	}

}