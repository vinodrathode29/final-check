package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		System.out.println("Favorites");
		testGetAllFavorite();
		testAddFavorite();
		System.out.println("Favorites After Add");
		testGetAllFavorite();
		testDeleteFavorite();
		System.out.println("Favorites After Remove");
		testGetAllFavorite();

	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.addFavorite(1, 2L);
		favoriteDao.addFavorite(1, 4L);
		favoriteDao.addFavorite(1, 3L);
		
	}

	public static void testGetAllFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		try {
			List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
		
			for (Movie movie : movieListCustomer) {
				System.out.println(movie.custList());

			}			
			System.out.println("No.of favorites :" + movieListCustomer.size() + "\n"); 
		} catch (FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testDeleteFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		
		favoriteDao.deleteFavorite(1, 2L);
	}

}
