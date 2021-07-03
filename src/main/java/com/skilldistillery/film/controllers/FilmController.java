package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;

@Controller
public class FilmController {
	
////	TODO: 
//	@Autowired
//	FilmDAO filmDAO;

	@RequestMapping(path = {"/", "home.do"})
	public String index() {
		return "WEB-INF/home.jsp"; 
	}
	
	@RequestMapping(path = "GetFilmByID.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") int filmId) {
		
		ModelAndView mv = new ModelAndView(); 
		
		//Instance new Film and Add to mv.addObject to map to .jsp File
		
		
		//Set View for .jsp File
//		mv.setViewName(//.jsp file here);
		
		return mv;
	}
	
	//Get Film by Search
		//path = "GetFilmByQuerySearch.do"
		//params = "searchQuery"
		//method = GET
	@RequestMapping(path = "GetFilmBySearch.do", params = "search", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("search") String query) {
		
		ModelAndView mv = new ModelAndView(); 
		
		//Instance new Film and Add to mv.addObject to map to .jsp File
		
		
		//Set View for .jsp File
//		mv.setViewName(//.jsp file here);
		
		return mv;
	}
	

	
	//Add Film
		//path = "addFilm.do"
		//params = "addFilm"
		//method = POST
	
	
	
	//Delete Film
		//path = "deleteFilm.do"
		//params = "deleteFilm"
		//method = POST
	
	
	//Update/Edit Film 
		//path = "editFilm.do"
		//params = "editFilm"
		//method = POST
	
	
}//class
