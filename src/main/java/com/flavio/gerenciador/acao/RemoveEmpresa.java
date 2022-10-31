package com.flavio.gerenciador.acao;

import java.io.IOException;

import com.flavio.gerenciador.model.Banco;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveEmpresa {

	public String executaAcao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("\nchamando RemoveEmpresa");
		
		String idEmpresaParam = request.getParameter("id");
		
		Integer idEmpresa = Integer.valueOf(idEmpresaParam);
		
		System.out.println("removendo empresa: " + Banco.buscaEmpresa(idEmpresa));
		
		Banco.removeEmpresa(idEmpresa);
		
		return "redirect:entrada";
		
	}
	
}
