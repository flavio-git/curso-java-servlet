package com.flavio.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.flavio.gerenciador.acao.Acao;
import com.flavio.gerenciador.acao.Index;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("\nchamando Controller");
	    
	    String paramAcao = request.getParameter("acao");
	    	    
	    String nomeDaClasse = "com.flavio.gerenciador.acao." + paramAcao;
	    System.out.println(nomeDaClasse);
	    		    
	    String caminhoJsp;
		
	    if(paramAcao == null) {
          
	        Index index = new Index();
	  	        
	        caminhoJsp = index.executaAcao(request, response); 
                 
	    } else {
	        
	    	try {
				Class classe = Class.forName(nomeDaClasse); // carrega a classe com o nome
				Object obj = classe.getDeclaredConstructor().newInstance(null);
				Acao acao = (Acao) obj;
				caminhoJsp = acao.executaAcao(request, response);
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
