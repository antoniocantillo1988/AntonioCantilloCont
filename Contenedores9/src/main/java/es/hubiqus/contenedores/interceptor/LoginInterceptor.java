package es.hubiqus.contenedores.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.hubiqus.contenedores.model.Usuario;
import es.hubiqus.contenedores.service.UsuarioSvc;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public static final String ATT_USER = "sessionUser";
	private static final String INDEX = "/index.jsp"; 
	private static final String INICIO = "/login";
	private static final String REGISTRO = "/registrar";
	private static final String LOGIN = "/login/";
	private static final String URI_CONTENEDOR_LIST_DISPONIBLES = "/listarDisponibilidad";
	
	
	
	@Autowired
	private UsuarioSvc svc;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
        
		System.out.println("...Muestra usuario: "+ usuario + "... , URI" + uri);
		
        if(usuario == null){
	        	if (!uri.endsWith(INICIO) && !uri.endsWith(LOGIN) && !uri.endsWith(REGISTRO) 
	        			&& !uri.endsWith(URI_CONTENEDOR_LIST_DISPONIBLES)){
	        		
	        		//Redirigir al inicio en caso de acceso prohibido
	        		response.sendRedirect(request.getContextPath() + INDEX);
	        		return false;
	        	}
        }else{
	        	//Comprobar autorización
        	
        		System.out.println (". . . comprobando autorizsacion . . .");
        	
	        	boolean res = svc.comprobar(usuario, uri);
	        	if (!res){
	        		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        		response.sendRedirect(request.getContextPath() + INDEX);
	        	}
	        	return res;
	    }
        
        return true;
	}

}
