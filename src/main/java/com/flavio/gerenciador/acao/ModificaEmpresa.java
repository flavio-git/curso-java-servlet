package com.flavio.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.flavio.gerenciador.model.Banco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifica-empresa")
public class ModificaEmpresa {

    public String executaAcao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("\nchamando ModificaEmpresa");
        
        String idEmpresaParam = request.getParameter("id");
        Integer idEmpresa = Integer.valueOf(idEmpresaParam);
        
        String nomeEmpresaParam = request.getParameter("nome");
        
        String paramDataAbertura = request.getParameter("abertura");
        
        Date dataAbertura = null;
        try {       
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dataAbertura = sdf.parse(paramDataAbertura);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
               
        Banco.editaEmpresa(idEmpresa, nomeEmpresaParam, dataAbertura);
        
        request.setAttribute("id", idEmpresa);
        request.setAttribute("nome", nomeEmpresaParam);
        request.setAttribute("data", paramDataAbertura);
             
        return "forward:modificaEmpresa.jsp";
        
    }
    
}
