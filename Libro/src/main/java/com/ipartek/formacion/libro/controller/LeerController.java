package com.ipartek.formacion.libro.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Servlet implementation class LeerController
 */
@WebServlet("/leer")
public class LeerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Pagina pagActual;
	PaginaArrayListDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		dao = PaginaArrayListDAO.getInstance();
	}

	@Override
	public void destroy() {

		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcces(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcces(request, response);
	}

	private void doProcces(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String op = request.getParameter("op");
			String id = request.getParameter("id");

			int ind = Integer.parseInt(id);

			if (op != null) {

				switch (op) { // Comprobamos que operación se ha pulsado
				case "prev":
					ind = retrocederPagina(ind, true); // Anterior página
					break;

				case "next":
					ind = retrocederPagina(ind, false); // Siguiente página
					break;

				default:
					break;
				}

			}

			pagActual = dao.getById(ind); // Obtenemos la pag. por el ID
			request.setAttribute("pagActual", pagActual);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			request.getRequestDispatcher("articulo.jsp").forward(request, response);
		}

	}

	/**
	 * Procedimiento privado que se encarga de avanzar o retroceder el indice de la
	 * página actual.
	 * 
	 * @param ind, con la posición en el dao de la página actual.
	 * @param retroceder, booleano <b>true</b> <=> la operación es retroceder
	 * @return int, con el índice de la nueva página a mostrar
	 */
	private int retrocederPagina(int ind, boolean retroceder) {

		if (retroceder) { // Debemos retroceder una página

			if (ind == 0) { // Si no podemos retroceder
				ind = dao.getAll().size() - 1; // Pasamos a la última página

			} else { // Si podemos retroceder
				ind--;
			}
		} else { // Debemos avanzar una página

			if (ind == dao.getAll().size() - 1) { // Si no podemos avanzar
				ind = 0; // Pasamos a la primera página

			} else { // Si podemos avanzar
				ind++;
			}
		}
		return ind;
	}

}
