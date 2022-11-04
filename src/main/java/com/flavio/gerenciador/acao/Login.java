package com.flavio.gerenciador.acao;

import java.io.IOException;

import com.flavio.gerenciador.model.Banco;
import com.flavio.gerenciador.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Acao {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("chamando Login");
		
		String loginParam = request.getParameter("login");
		String senhaParam = request.getParameter("senha");

		System.out.printf("Login: %s, Senha: %s - entrando no sistema.\n", loginParam, senhaParam);
		
		//Banco banco = new Banco();
		
		Usuario usuarioLogado = Banco.checkLoginUsuario(loginParam, senhaParam);
		
		System.out.println(usuarioLogado);
		
		if(usuarioLogado != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuarioLogado);
			return "redirect:entrada?acao=Index";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
		
	}

}
