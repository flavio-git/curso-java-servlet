package com.flavio.gerenciador.acao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormNovaEmpresa implements Acao {

	public String executaAcao(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("chamando FormNovaEmpresa");
		
		return "forward:formNovaEmpresa.jsp";
		
	}
	
}
