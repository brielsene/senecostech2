package br.com.senecostech.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCadastroUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:formCadastro.jsp";
	}

}
