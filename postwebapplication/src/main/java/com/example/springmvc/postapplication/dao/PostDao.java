package com.example.springmvc.postapplication.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.springmvc.postwebapplication.controller.Posts;
import com.example.springmvc.postwebapplication.controller.PostPowMapper;
import com.example.springmvc.postwebapplication.controller.UserRowMapper;
import com.example.springmvc.postwebapplication.controller.Users;

public class PostDao {
	
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Users> getAllFlight(){
		String sql ="select * from flight";
		return template.query(sql, new UserRowMapper());
		
	}
	
	public String insertFlight(Posts p) {
		String sql = "insert into flight values(?,?,?,?,?,?,?,?)";
		template.update(sql,p.getFlight_id(),p.getAirline_id(),p.getAirline_name(),p.getFrom_location(),p.getTo_location(),p.getDeparture_time(),p.getArrival_time(),p.getDuration(),p.getSeats() );
		return "Post inserted";
	}
	public String deleteFlight(Posts p) {
		String sql = "delete from flight where flight_id = ?";
		template.update(sql, p.getFlight_id());
		return "Flight deleted";
	}
	public List<Posts> getDetails(String fid){
		String sql = "select *from flight where flight_id=?";
		return template.query(sql, new PostPowMapper(),fid);
	}

}