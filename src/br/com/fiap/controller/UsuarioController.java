package br.com.fiap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bean.Alert;
import br.com.fiap.bean.Usuario;
import br.com.fiap.bo.UsuarioBO;


@WebServlet(urlPatterns = {"/login.jsp", "/logout", "/index.jsp", "/logup.jsp"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.isNew()) {
			session.setMaxInactiveInterval(300); // duracao da sessao em segundos
		}
		
		switch (request.getRequestURI()) { // controle das rotas
			case "/login-logout/login.jsp":
				login(request, response); 
				break;
			case "/login-logout/logout":
				logout(request, response); 
				break;
			case "/login-logout/index.jsp":
				index(request, response); 
				break;
			case "/login-logout/logup.jsp":
				logup(request, response);
				break;
			default:
				index(request, response);
				break;
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if (request.getSession().getAttribute("currentUser") != null) {
			response.sendRedirect("index.jsp");
		}else {
			if (request.getMethod().equalsIgnoreCase("get")) {
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);				
			}else {
				
				String username = request.getParameter("txt-user");
				String senha = request.getParameter("txt-senha");
				
				if ((username != null) && (senha != null) && ((username.isEmpty()) || (senha.isEmpty()))) {
					Usuario user = new Usuario();
					user.setNomeUser(username);
					user.setPassUser(senha);
					request.setAttribute("dados", user);
					request.setAttribute("message", new Alert("Todos os campos devem ser preenchidos.", "alert-warning"));
					request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
				} else {
					Usuario user = new Usuario();
					user.setNomeUser(username);
					user.setPassUser(senha);
					user = logarUsuario(user);
					if (user != null) {
						request.getSession().setAttribute("currentUser", user);
						response.sendRedirect("index.jsp");						
					}else {
						request.setAttribute("message", new Alert("Credenciais inv�lidas.", "alert-danger"));
						request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
					}
				}
			}
		}
	}
	
	public Usuario logarUsuario(Usuario u) {
		UsuarioBO bo = new UsuarioBO();
		return bo.login(u);
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
	}	
	
	public void logup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if (request.getSession().getAttribute("currentUser") != null) {
			response.sendRedirect("index.jsp");
		}else {	
			if (request.getMethod().equalsIgnoreCase("get")) {
				request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
			}else {
				String nome = request.getParameter("txt-nome");
				String username = request.getParameter("txt-username");
				String senha = request.getParameter("txt-senha");
				String url = request.getParameter("txt-url-avatar");
			
				Usuario u = new Usuario();
				u.setNome(nome);
				u.setNomeUser(username);
				u.setPassUser(senha);
				u.setUrlAvatar(url);
				
				UsuarioBO bo = new UsuarioBO();
				
				request.setAttribute("dados", u);
				switch (bo.cadastrar(u)) {
					case 1:
						response.sendRedirect("login.jsp");
						break;
					case 0:
						request.setAttribute("message", new Alert("N�o foi possivel realizar o cadastro, j� existe um usuario com username '<strong>"+ username +"</strong>' !", "alert-warning"));
						request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
						break;
					
					case -1:
						request.setAttribute("message", new Alert("Valor de <strong>NOME</strong> n�o pode ficar em branco!", "alert-warning"));
						request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
						break;
						
					case -2:
						request.setAttribute("message", new Alert("Valor de <strong>USERNAME</strong> n�o pode ficar em branco!", "alert-warning"));
						request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
						break;
						
					case -3:
						request.setAttribute("message", new Alert("Valor de <strong>SENHA</strong> n�o pode ficar em branco!", "alert-warning"));
						request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
						break;
						
					case -4:
						request.setAttribute("message", new Alert("Valor de <strong>URL FOTO AVATAR</strong> n�o pode ficar em branco!", "alert-warning"));
						request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
						break;
						
					default:
						request.setAttribute("message", new Alert("Ocorreu um erro ao tentar cadastrar, tente novamente!", "alert-danger"));
						request.getRequestDispatcher("WEB-INF/logup.jsp").forward(request, response);
						break;
				}	
			}
		}
	}
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if (request.getSession().getAttribute("currentUser") != null) {
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}