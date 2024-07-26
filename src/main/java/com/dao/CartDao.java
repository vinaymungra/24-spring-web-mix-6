package com.dao;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ECartBean;
import com.bean.EProductBean;
import com.bean.EUserBean;

@Repository
public class CartDao {
	
	@Autowired
	JdbcTemplate stmt;
		//Is in my database every thing is sql injection proof? Than Yes just because i am using ? question mark as placeholder
		public void addToCart(ECartBean cartBean)
		{
			stmt.update("insert into cart (productId,userId) values (?,?)",cartBean.getProductId(),cartBean.getUserId());
		}
		
		public List<EProductBean> myCart(Integer userId){
			
			return stmt.query("select * from products join cart using (productId) where userId=? ", new BeanPropertyRowMapper<>(EProductBean.class),new Object[] {userId});
		}
}