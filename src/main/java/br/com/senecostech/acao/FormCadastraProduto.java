package br.com.senecostech.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCadastraProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:formCadastraProduto.jsp";
	}

}
