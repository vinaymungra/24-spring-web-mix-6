package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EUserBean;


@Repository
public class EUserDao {

	
		@Autowired
		JdbcTemplate stmt;
		
		public void insertUser(EUserBean userBean) {
			stmt.update("insert into users(firstName, email, password, profilePic) values (?,?,?,?)",userBean.getFirstName(),userBean.getEmail(),userBean.getPassword(),userBean.getProfilePicPath());
			
		}
		public EUserBean authenticate (String email, String password)
		{
			try {
				EUserBean userBean = stmt.queryForObject("select * from users where email = ? and password = ?",
						new BeanPropertyRowMapper<EUserBean>(EUserBean.class), new Object[] { email, password });

				return userBean;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return null;
		}
}



