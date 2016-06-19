package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricaoDaTarefa = request.getParameter("tarefa");
		if(descricaoDaTarefa == null || descricaoDaTarefa == "") {
			throw new IllegalArgumentException("Tarefa inválida.");
		}
		String pacoteDaTarefa = "br.com.alura.gerenciador.web." + descricaoDaTarefa;
		try {
			Class<?> type = Class.forName(pacoteDaTarefa);
			Tarefa instance = (Tarefa) type.newInstance();
			String caminhoRetorno = instance.executa(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(caminhoRetorno);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
}
