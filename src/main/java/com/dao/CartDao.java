package com.dao;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ECartBean;
import com.bean.EProductBean;
import com.bean.EUserBean;
import com.bean.ProductCartBean;

@Repository
public class CartDao {
	
	@Autowired
	JdbcTemplate stmt;
	
		//Is in my database every thing is sql injection proof? Than Yes just because i am using ? question mark as placeholder
		public void addToCart(ECartBean cartBean)
		{
			
			ECartBean cart=null;
			try {
				cart=stmt.queryForObject("select * from cart where productId=? and userId=?", 
						new BeanPropertyRowMapper<>(ECartBean.class), 
						new Object[] {cartBean.getProductId(),cartBean.getUserId()});
			}	
			catch(Exception e)
			{
				
			}
			if(cart==null)
			{
				stmt.update("insert into cart (productId,userId,qty) values (?,?,?)",cartBean.getProductId(),cartBean.getUserId(),1);
			}
			else {
				stmt.update("update cart set qty=? where productId=? and userId=?",cart.getQty()+1,cartBean.getProductId(),cartBean.getUserId());
			}
		}
		
		public List<EProductBean> myCart(Integer userId){
			
			 
			List<EProductBean> products = stmt.query(" select * from products join cart using (productId) where userId= ?;",
					new BeanPropertyRowMapper<>(EProductBean.class), 
					new Object[] { userId });
			return products;
		}
		public void removeCartItem(ECartBean cartBean)
		{
			ECartBean cart=null;
			try {
				cart= stmt.queryForObject("select * from cart where productId=? and userId=?", 
						new BeanPropertyRowMapper<>(ECartBean.class), 
						new Object[] {cartBean.getProductId(),cartBean.getUserId()});
			}	
			catch(Exception e)
			{
				
			}
			if(cart.getQty()==1)
			{
				stmt.update("delete from cart where productId=? and userId=? ",cartBean.getProductId(),cartBean.getUserId());
			}
			else {
				stmt.update("update cart set qty=? where productId=? and userId=?",cart.getQty()-1,cartBean.getProductId(),cartBean.getUserId());
			}
		}
}
