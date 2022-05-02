package com.example.springmvc.postwebapplication.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping(value="delete")
	public ModelAndView delete(HttpServletResponse response) throws IOException{
		return new ModelAndView("deletepost");
	}

	@RequestMapping(value="/insert")
	public ModelAndView insert(HttpServletResponse response) throws IOException{
		return new ModelAndView("insertpost");
	}
	@RequestMapping(value="/insertpost")
	public ModelAndView insertpoast(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		int flight_id = Integer.parseInt(request.getParameter("flight_id"));
		int airline_id = Integer.parseInt(request.getParameter("airline_id"));
		String airline_name = request.getParameter("airline_name");
		String from_location_to_location = request.getParameter("from_location_to_location");
		String departure_time = request.getParameter("departure_time");
		String arrival_time = request.getParameter("arrival_time");
		int duration  = Integer.parseInt(request.getParameter("duration"));
		int total_seat  = Integer.parseInt(request.getParameter("total_seat"));
		

		String sql = "insert into posts value(?,?,?,?,?,?,?,?)";
		template.update(sql,flight_id,airline_id,airline_name,from_location_to_location,departure_time,arrival_time,duration,total_seat);
		
		return new ModelAndView("customerpage");
	}
	@RequestMapping(value="deletepost")
	public ModelAndView deletepost(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		int profile_id = Integer.parseInt(request.getParameter("profile_id"));
		String sql = "delete from posts where profile_id=?";
		template.update(sql,profile_id);
		return new ModelAndView("adminpage");
	}

}
