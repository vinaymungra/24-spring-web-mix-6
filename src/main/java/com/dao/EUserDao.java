package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EUserBean;


@Repository
public class EUserDao {

	
		@Autowired
		JdbcTemplate stmt;
		
		public void insertUser(EUserBean userBean) {
			stmt.update("insert into users(firstName, email, password) values (?,?,?)",userBean.getFirstName(),userBean.getEmail(),userBean.getPassword());
			
			
		}
}



