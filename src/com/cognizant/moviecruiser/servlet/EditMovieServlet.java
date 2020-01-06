package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			String title = request.getParameter("title");
			
			long boxOffice = Long.parseLong(request.getParameter("gross"));
			boolean active = request.getParameter("rdyes").equals("Yes");

			Date dateOfLaunch = DateUtil.convertToDate(request.getParameter("txtDoB"));
			String genre = request.getParameter("genre");

			boolean hasTeaser = request.getParameter("hasteaser") != null;

			Movie movie = new Movie(id, title, boxOffice, active, dateOfLaunch, genre, hasTeaser);

			MovieDao movieDao = new MovieDaoCollectionImpl();

			movieDao.modifyMovie(movie);
			
			request.setAttribute("msg","Movie details saved successfully.");
			
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);

		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
