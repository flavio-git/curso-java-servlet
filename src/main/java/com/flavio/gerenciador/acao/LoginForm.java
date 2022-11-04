package com.flavio.gerenciador.acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("chamando LoginForm");
		
		return "forward:formLogin.jsp";
		
	}

	
	
}
