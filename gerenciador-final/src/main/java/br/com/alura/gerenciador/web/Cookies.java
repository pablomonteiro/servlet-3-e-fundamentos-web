package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie getUsuarioLogado() {
		if(cookies != null) {
			for(Cookie cookie : cookies){
				if("usuario.logado".equals(cookie.getName())){
					return cookie;
				}
			}			
		}
		return null;
	}

}
