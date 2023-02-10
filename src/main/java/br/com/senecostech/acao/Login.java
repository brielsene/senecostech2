package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Usuario;
import br.com.senecostech.model.UsuarioDAO;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(new ConnectionFactory().getConnection());
			System.out.println(request.getParameter("login")+" - "+ request.getParameter("senha"));
			Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"));
			Usuario verificiaLogin = usuarioDAO.verificiaLogin(usuario);
			System.out.println(verificiaLogin);
			HttpSession sessao = request.getSession();
			if(verificiaLogin !=null) {
				sessao.setAttribute("usuarioLogado", verificiaLogin);
				return "redirect:controller?acao=ListaProdutos";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return "redirect:controller?acao=FormLogin";
		
	}

}
