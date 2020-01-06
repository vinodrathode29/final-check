package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class AddToFavoriteServlet
 */
@WebServlet({ "/AddToFavoriteServlet", "/AddToFavorite" })
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            long userId = 1L;
            long movieId = Long.parseLong(request.getParameter("movieId"));
            FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
            favoriteDao.addFavorite(userId, movieId);
            
            MovieDao movieDao = new MovieDaoCollectionImpl();
            List<Movie> movieListCustomer = movieDao.getMovieListCustomer();
            
            request.setAttribute("movieList", movieListCustomer);
            request.setAttribute("addFavoriteStatus", true);
            
            
            RequestDispatcher rd=request.getRequestDispatcher("movie-list-customer.jsp");
			rd.forward(request, response);
			
          
     } catch(Exception e) {
            System.out.println(e);
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
