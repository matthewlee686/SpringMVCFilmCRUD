package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	//	TODO: 
	@Autowired
	private FilmDAO filmDAO;
	
	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO; 
	}

	@RequestMapping(path = {"/", "home.do"})
	public String index() {
		return "WEB-INF/home.jsp"; 
	}
	
	@RequestMapping(path = "GetFilmByID.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") int filmId) {
		
		ModelAndView mv = new ModelAndView(); 
		
		//Instance new Film and Add to mv.addObject to map to .jsp File
		try {
			Film film = filmDAO.findFilmById(filmId);
			mv.addObject("film", film);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Set View for .jsp File
		mv.setViewName("WEB-INF/idResults.jsp");
		
		return mv;
	}
	
	
	
	//Get Film by Search
		//path = "GetFilmByQuerySearch.do"
		//params = "searchQuery"
		//method = GET
	@RequestMapping(path = "GetFilmBySearch.do", params = "search", method = RequestMethod.GET)
	public ModelAndView getFilmBySearchQuery(@RequestParam("search") String query) {
		
		ModelAndView mv = new ModelAndView(); 
		
		//Instance new Film and Add to mv.addObject to map to .jsp File
		try {
			List<Film> films = filmDAO.findFilmByKeyword(query);
			mv.addObject("films", films);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Set View for .jsp File
		mv.setViewName("WEB-INF/searchResults.jsp");
		
		return mv;
	}
	
	
	//Add Film
		//path = "addFilm.do"
		//params = "addFilm"
		//method = POST
	@RequestMapping(path = "AddFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film) {
		
		ModelAndView mv = new ModelAndView(); 
		
		try {
			filmDAO.createFilm(film);
			mv.addObject("film", film);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Set View for .jsp File
		mv.setViewName("redirect:filmCreated.do");
		
		return mv; 
	}
	
	
	//Add Film Redirect
		//path = "filmCreated.do"
		//method = GET
	@RequestMapping(path = "filmCreated.do", method = RequestMethod.GET)
	public ModelAndView filmCreated() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/idResults.jsp");
		
		return mv; 
	}
	
	//Delete Film
		//path = "deleteFilm.do"
		//params = "deleteFilm"
		//method = POST
	
	
	//Update/Edit Film 
		//path = "editFilm.do"
		//params = "editFilm"
		//method = POST
	
	
}//class
