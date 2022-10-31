package com.flavio.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.flavio.gerenciador.model.Banco;
import com.flavio.gerenciador.model.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nova-empresa")
public class NovaEmpresa implements Acao {
    
    public String executaAcao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("\nchamando NovaEmpresa");
        
        // recebendo as informações da empresa criada via parametro
        String nomeEmpresa = request.getParameter("nome");
        String paramDataAbertura = request.getParameter("abertura");
        System.out.println(paramDataAbertura);
        
        // a data recebida por parametro é uma String, devemos então fazer o parse abaixo para um objeto Date
        Date dataAbertura = null;
        try {       
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dataAbertura = sdf.parse(paramDataAbertura);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        
        // criando uma instância de Empresa
        Empresa empresa = new Empresa();
        
        // passando para a instância os atributos recebidos via requisição
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        // adicionando a empresa na lista de empresas do objeto Banco
        Banco.adiciona(empresa);
                   
        return "redirect:entrada";
        
    }
    

}
