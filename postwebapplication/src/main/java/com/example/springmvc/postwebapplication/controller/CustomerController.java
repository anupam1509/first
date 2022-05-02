package com.example.springmvc.postwebapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping(value="/insert")
	public ModelAndView insert(HttpServletResponse response) throws IOException{
		return new ModelAndView("insertpost");
	}
	@RequestMapping(value="/search")
	public ModelAndView search(HttpServletResponse response) throws IOException{
		return new ModelAndView("searchpost");
	}
	@RequestMapping(value="/insertpost")
	public ModelAndView insertpoast(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		int profile_id = Integer.parseInt(request.getParameter("profile_id"));
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address = request.getParameter("address");
		long mobile_number = Long.parseLong(request.getParameter("mobile_number"));
		String email_id = request.getParameter("email_id");
		
		String sql = "insert into posts value(?,?,?,?,?,?,?)";
		template.update(sql,profile_id,password,first_name,last_name,address,mobile_number,email_id);
		
		return new ModelAndView("customerpage");
	}
	@RequestMapping(value="/searchpost")
	public ModelAndView searchpost(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		String from_location_to_location = request.getParameter("from_location_to_location");
		List<Posts> posts = template.query("select * from posts where author=?",new PostPowMapper(),from_location_to_location);

		return new ModelAndView("displayposts","tposts",posts);
		
		
	}
	
}
