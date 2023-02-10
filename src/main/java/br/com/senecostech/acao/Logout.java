package br.com.senecostech.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		return "redirect:controller?acao=FormLogin";
	}

}
