package com.flavio.gerenciador.servlet;

import java.io.IOException;

import com.flavio.gerenciador.acao.EditaEmpresa;
import com.flavio.gerenciador.acao.EmpresasCadastradas;
import com.flavio.gerenciador.acao.FormNovaEmpresa;
import com.flavio.gerenciador.acao.Index;
import com.flavio.gerenciador.acao.ModificaEmpresa;
import com.flavio.gerenciador.acao.NovaEmpresa;
import com.flavio.gerenciador.acao.RemoveEmpresa;

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
	    
	    System.out.println(paramAcao);
	    
	    String caminhoJsp = null;
	    
	    if(paramAcao == null) {
            
	        Index index = new Index();
	  	        
	        caminhoJsp = index.executaAcao(request, response); 
                   
        } else if(paramAcao.equals("EmpresasCadastradas")) {
	        
	        EmpresasCadastradas ec = new EmpresasCadastradas();
	       	        
	        caminhoJsp = ec.executaAcao(request, response);
	        
	    } else if(paramAcao.equals("NovaEmpresa")) {
            
            NovaEmpresa ne = new NovaEmpresa();
            
            caminhoJsp = ne.executaAcao(request, response);
            
        } else if(paramAcao.equals("EditaEmpresa")) {
	        
	        EditaEmpresa ee = new EditaEmpresa();
	        
	        caminhoJsp = ee.executaAcao(request, response);
	        
	    } else if(paramAcao.equals("ModificaEmpresa")) {
	        
	        ModificaEmpresa me = new ModificaEmpresa();
	        
	        caminhoJsp = me.executaAcao(request, response);
	        
	    } else if(paramAcao.equals("RemoveEmpresa")) {
	    	
	    	RemoveEmpresa re = new RemoveEmpresa();
	    	
	    	caminhoJsp = re.executaAcao(request, response);
	    	
	    } else if(paramAcao.equals("FormNovaEmpresa")) {
	    	
	    	FormNovaEmpresa fne = new FormNovaEmpresa();
	    	
	    	caminhoJsp = fne.executaAcao(request, response);
	    	
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
