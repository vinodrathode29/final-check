package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoSqlImpTest {

	public static void main(String[] args) throws ParseException {
		System.out.println("==============Admin Movie List==============");
		testGetMovieListAdmin();
		System.out.println("==============Customer Movie List==============");
		testGetMovieListCustomer();
		System.out.println("==============Modified Movie List==============");
		testModifyMenuItem();
		testGetMovieListAdmin();
		} 

public static void testGetMovieListAdmin() throws ParseException {
	MovieDao movieDao = new MovieDaoSqlImp();
	List<Movie> movieList = movieDao.getMovieListAdmin();
	for (Movie x : movieList) {
		//System.out.println(x);
	}

}
public static void testGetMovieListCustomer() {
	MovieDaoSqlImp movieDaoSqlImpl = new MovieDaoSqlImp();
	
	List<Movie> movieList = movieDaoSqlImpl.getMovieListCustomer();
	for (Movie movie : movieList) {
		
	}
}
public static void testModifyMenuItem() {
	MovieDaoSqlImp movieDao = new MovieDaoSqlImp();
	
	try {
		Movie movie = new Movie(1, "Basha", 1234567891 , true, DateUtil.convertToDate("02/02/2015"), "Thriller", true);
		
		movieDao.modifyMovie(movie);
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}

}
