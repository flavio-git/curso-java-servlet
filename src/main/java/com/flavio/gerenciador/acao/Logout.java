package com.flavio.gerenciador.acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("\nchamando Logout");
		
		HttpSession sessao = request.getSession();
		
		sessao.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
				
	}

}
