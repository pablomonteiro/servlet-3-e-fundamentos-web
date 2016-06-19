package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		Usuario usuario = getUsuario(servletRequest);
		System.out.println("Usuario "+ usuario.getEmail() +" acessando a URI " + servletRequest.getRequestURI());
		chain.doFilter(request, response);
	}

	private Usuario getUsuario(HttpServletRequest servletRequest) {
		HttpSession session = servletRequest.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if(usuario != null)
			return usuario;
		return new Usuario("deslogado", "");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
