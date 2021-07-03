package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmAccessor {
	public Film findFilmById(int filmId) throws SQLException;
	  public Actor findActorById(int actorId) throws SQLException;
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmByKeyword(String keyword) throws SQLException;
	  public Film createFilm(Film film) throws SQLException;
	  public void deleteFilmByID(int filmID) throws SQLException;
	  public void deleteFilmByKeyword(String keyword) throws SQLException;
	  public void updateFilmByID(int filmID, String title, String desc, String releaseYear, int langID, 
				int rentDur, double rentRate, int length, double repCost) throws SQLException;
	  public void updateFilmByKeyword(String keyword, String title, String desc, String releaseYear, int langID, 
				int rentDur, double rentRate, int length, double repCost) throws SQLException;

}
