package com.ipartek.formacion.libro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libro.model.PaginaArrayListDAO;
import com.ipartek.formacion.libro.pojo.Pagina;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PaginaArrayListDAO dao;
	private ArrayList<Pagina> paginas;
	private Pagina pagActual;

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

		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	private void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			cargarPaginas(); // Obtenemos las páginas del DAO
			
			request.setAttribute("paginas", paginas);

		} catch (Exception e) { // Capturar cualquier excepción

			e.printStackTrace();

		} finally {

			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

	}

	/**
	 * Procedimiento propio que se encarga de obtener las páginas del DAO.
	 */
	private void cargarPaginas() {

		paginas = new ArrayList<Pagina>();
		paginas = (ArrayList<Pagina>) dao.getAll();

	}


}
