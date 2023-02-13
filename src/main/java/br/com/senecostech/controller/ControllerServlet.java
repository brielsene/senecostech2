package br.com.senecostech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senecostech.acao.Acao;
import br.com.senecostech.model.Usuario;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.senecostech.acao."+paramAcao;
		String nome = null;
		HttpSession sessao = request.getSession();
		
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado")==null;
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("FormLogin")||paramAcao.equals("Login")||paramAcao.equals("FormCadastroUsuario")||
				paramAcao.equals("CadastroUsuario"));
		
		if(usuarioNaoEstaLogado & ehUmaAcaoProtegida) {
			response.sendRedirect("controller?acao=FormLogin");
			return;
		}
		
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		String [] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}

}
