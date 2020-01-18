package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		System.out.println("===============All Favorites ================");
		testGetAllCartItems();
		testAddCartItem();
		System.out.println("============Favorites  After Add==============");
		testGetAllCartItems();
		testRemoveCartItem();
		System.out.println("============Favorites After Remove============");
		testGetAllCartItems();

	}
	  static void testAddCartItem() throws FavoriteEmptyException {
		  FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();        

		  favoriteDao.addFavorite(1, 4);
		  favoriteDao.addFavorite(1, 5);

          List<Movie> movieList = favoriteDao.getAllFavorite(1);
 
}
	  

      static void testGetAllCartItems() throws FavoriteEmptyException {
    	  FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();

             List<Movie> movieList = favoriteDao.getAllFavorite(1);
          
            
             for (Movie movie : movieList) {
     			System.out.println(movie);
     			}

      }

	  static void testRemoveCartItem() throws FavoriteEmptyException {
	  FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();

      try {
    	  favoriteDao.deleteFavorite(1, 4);
   	  // favoriteDao.deleteFavorite(1, 3);

      List<Movie> movieList = favoriteDao.getAllFavorite(1);

      } catch (Exception e) {

           throw new FavoriteEmptyException("Favorites is empty");
      }

}

}
