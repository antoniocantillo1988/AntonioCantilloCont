package es.hubiqus.contenedores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para el cambio de idioma,
 * simplemente redirige a página de inicio
 * @author ajurado
 *
 */
@Controller
@RequestMapping(value="/inicio")
public class Inicio {
	
	private static final String SUCCESS = "inicio";

	@RequestMapping(value="/home", method=RequestMethod.GET)
    public String execute(Model model){
		return SUCCESS;
    }

}
