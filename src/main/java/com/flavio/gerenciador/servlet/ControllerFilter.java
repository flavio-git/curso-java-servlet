package com.flavio.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.flavio.gerenciador.acao.Acao;
import com.flavio.gerenciador.acao.LoginForm;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControllerFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("\nchamando ControllerFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
	    
	    String nomeDaClasse = "com.flavio.gerenciador.acao." + paramAcao;
	    System.out.println(nomeDaClasse);
	    		    
	    String caminhoJsp;
		
	    if(paramAcao == null) {
          
	    	LoginForm lf = new LoginForm();
	    	caminhoJsp = lf.run(request, response);
	    	
	    } else {
	        
	    	try {
				Class<?> classe = Class.forName(nomeDaClasse); // carrega a classe com o nome 
				Acao acao = (Acao) classe.getDeclaredConstructor().newInstance(null);
				caminhoJsp = acao.run(request, response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException | ServletException
					| IOException e) {
				throw new ServletException(e);
			}
	    	
	    }
	    
	    String[] tipoEEndereco = caminhoJsp.split(":");
	    
	    if(tipoEEndereco[0].equals("forward")) {
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	        rd.forward(request, response);
	        
	    } else {
	    	
	    	response.sendRedirect(tipoEEndereco[1]);
	    	
	    }
		
	}

}
