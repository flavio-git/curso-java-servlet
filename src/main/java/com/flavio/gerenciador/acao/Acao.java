package com.flavio.gerenciador.acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Acao {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
