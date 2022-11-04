package com.flavio.gerenciador.servlet;

import java.io.IOException;

import com.flavio.gerenciador.acao.LoginForm;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutenticacaoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("\nchamando AutenticacaoFilter");

		HttpServletRequest request = (HttpServletRequest) requestServlet;
		HttpServletResponse response = (HttpServletResponse) responseServlet;

		String paramAcao = request.getParameter("acao");

		String caminhoJsp;

		if (paramAcao == null) {

			LoginForm lf = new LoginForm();
			caminhoJsp = lf.run(request, response);

		} else {

			HttpSession sessao = request.getSession();
			boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
			boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

			System.out.println("Usuario não está logado: " + usuarioNaoEstaLogado + ", É uma ação protegida: "
					+ ehUmaAcaoProtegida);

			if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
				response.sendRedirect("redirect:entrada?acao=LoginForm");
				return;
			}
		}

		chain.doFilter(request, response);

	}

}
