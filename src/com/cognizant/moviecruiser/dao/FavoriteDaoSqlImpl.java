package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImpl  implements FavoriteDao{
	

	@Override
	public void addFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();

		String sql = "insert into favorite values(default,?,?)";
		
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, userId);
		ps.setLong(2, movieId);
		
		ps.executeUpdate();

	} catch (SQLException e) {

		e.printStackTrace();

	} finally {
		try {
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}



	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		List<Movie> movieList = new ArrayList<Movie>();

		PreparedStatement ps;

		ResultSet resultSet;

		boolean active, hasTeaser;

		Movie movie = null;

		try {

			Favorite favorite = new Favorite();

			StringBuffer sqlBuffer = new StringBuffer();

			sqlBuffer.append("SELECT movie.mo_id, "
							+ "movie.mo_title ,"
							+ " movie.mo_box_office ,"
							+ "movie.mo_active,"
							+ "movie.mo_date_of_launch,"
							+ "movie.mo_genre, "
							+ "movie.mo_has_teaser"
							+ " FROM movie ")

					.append("INNER JOIN favorite ON movie.mo_id = favorite.fv_mv_id WHERE favorite.fv_us_id = ?");

			ps = con.prepareStatement(sqlBuffer.toString());
			ps.setLong(1, userId);

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				int movieId = resultSet.getInt(1);
				String title = resultSet.getString(2);
				Long boxOffice = resultSet.getLong(3);
				String isActive = resultSet.getString(4);
				Date date_of_launch = resultSet.getDate(5);
				String genre = resultSet.getString(6);
				String isHasTeaser = resultSet.getString(7);
				
				if (isActive != null && isActive.equalsIgnoreCase("Yes"))
					active = true;
				
				else
					active = false;
				if (isHasTeaser != null && isHasTeaser.equalsIgnoreCase("Yes"))
					hasTeaser = true;
				
				else
					hasTeaser = false;

				movie = new Movie(movieId, title, boxOffice, active, date_of_launch, genre, hasTeaser);

				movieList.add(movie);
			}

			favorite.setMovieList(movieList);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {
			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}
		if (movieList.size() == 0) {

			throw new FavoriteEmptyException("Favorite is Empty");
		}
		return movieList;
	}
	

	@Override
	public void deleteFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "delete from favorite where fv_us_id=? and  fv_mv_id=? limit 1";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, userId);
			ps.setLong(2, movieId);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}