package com.flavio.gerenciador.acao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao {

	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("chamando FormNovaEmpresa");
		
		return "forward:formNovaEmpresa.jsp";
		
	}
	
}
