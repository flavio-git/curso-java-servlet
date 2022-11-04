package com.flavio.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.flavio.gerenciador.model.Banco;
import com.flavio.gerenciador.model.Empresa;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EmpresasCadastradasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("chamando EmpresasCadastradasServive");
		
		List<Empresa> empresas = Banco.listaEmpresas();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(empresas);
		
		response.setContentType("application/json");
		
		response.getWriter().print(json);
		
	}

}
