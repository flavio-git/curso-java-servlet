package com.flavio.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import com.flavio.gerenciador.model.Banco;
import com.flavio.gerenciador.model.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresas-cadastradas")
public class EmpresasCadastradas implements Acao {
    
    public String executaAcao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("\nchamando EmpresasCadastradas");
        
        // obtendo a lista de empresas cadastradas no sistema
        List<Empresa> empresasCadastradas = Banco.listaEmpresas();
        System.out.println(empresasCadastradas);
        
        // adicionando atributos na requisição
        request.setAttribute("empresasCadastradas", empresasCadastradas);
        
        return "forward:empresasCadastradas.jsp";
        
    }
    
}
