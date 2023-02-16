package br.com.senecostech.acao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senecostech.model.ConnectionFactory;
import br.com.senecostech.model.Usuario;
import br.com.senecostech.model.UsuarioDAO;

public class CadastroUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		String endereco = request.getParameter("endereco");
		if(senha.equals(senha2)) {
			
			UsuarioDAO usuarioDAO;
			try {
				usuarioDAO = new UsuarioDAO(new ConnectionFactory().getConnection());
				Usuario usuario = new Usuario(login, senha, endereco);
				usuarioDAO.cadastraUsuario(usuario);
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", usuario);
				return"redirect:controller?acao=ListaProdutos" ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
			return "redirect:controller?acao=FormCadastroUsuario";
		
		
		
		
		
		
	}

}
