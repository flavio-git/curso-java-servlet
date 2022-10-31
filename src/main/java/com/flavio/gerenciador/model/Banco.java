package com.flavio.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresasList = new ArrayList<>();

	static {
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa1.setNome("Facebook");
		empresa2.setNome("Google");
		adiciona(empresa1);
		adiciona(empresa2);
	}
	
	// adiciona uma empresa na lista
	public static void adiciona(Empresa empresa) {
		Banco.empresasList.add(empresa);
	}
	
	// retornando uma cópia das empresas cadastradas
	public static List<Empresa> listaEmpresas(){
		return new ArrayList<>(Banco.empresasList);
	}
	
	// remove uma empresa da lista através do id
	public static boolean removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = empresasList.iterator();
			
		while(it.hasNext()) {
			
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		return false;
	}
	
	// busca e retorna uma empresa através do id
	public static Empresa buscaEmpresa(int id) {
	    for (Empresa empresa : empresasList) {
            if(empresa.getId() ==  id) {
                return empresa;
            }              
        }
	    return null;
	}
	
	
	// edita os atributos da empresa
    public static boolean editaEmpresa(Integer id, String novoNome, Date novaDataAbertura) {
        
        Iterator<Empresa> it = empresasList.iterator();
            
        while(it.hasNext()) {
            
            Empresa emp = it.next();
            
            if(emp.getId() == id) {
               emp.setNome(novoNome);
               emp.setDataAbertura(novaDataAbertura);
               return true;
            }
        }
        return false;
    }
	
		
}

