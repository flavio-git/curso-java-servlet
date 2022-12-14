package com.flavio.gerenciador.acao;

import java.io.IOException;

import com.flavio.gerenciador.model.Banco;
import com.flavio.gerenciador.model.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditaEmpresa implements Acao {

    public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("\nchamando EditaEmpresa");
        
        // pegando as informações através dos parâmetros
        String idEmpresaParam = request.getParameter("id");
        Integer idEmpresa = Integer.valueOf(idEmpresaParam);

        Empresa empresa = Banco.buscaEmpresa(idEmpresa);
        
        System.out.println("Editando empresa: " + empresa);
        
        request.setAttribute("empresa", empresa);
              
        return "forward:editaEmpresa.jsp";

    }
    
}
