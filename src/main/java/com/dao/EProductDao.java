package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EProductBean;

@Repository
public class EProductDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(EProductBean productBean)
	{
		stmt.update("insert into products (productName,category,price,qty,productPicPath) values(?,?,?,?,?)",productBean.getProductName(),
				productBean.getCategory(),productBean.getPrice(),productBean.getQty(),productBean.getProductPicPath());
	}
	public List<EProductBean> getAllProducts()
	{
		List<EProductBean> list= stmt.query("select * from products", new BeanPropertyRowMapper<EProductBean>(EProductBean.class));
		return list;
	}
	public void deleteProduct(Integer productId)
	{
		stmt.update("delete from products where productId="+productId);
	}
	public void deleteProductByName(String productName)
	{
		stmt.update("delete from products where productName = ?",productName);
	}
	public EProductBean getProductById(Integer productId) {

		EProductBean bean = stmt.queryForObject("select * from products where productId = ? ",
				new BeanPropertyRowMapper<>(EProductBean.class), new Object[] { productId }); // name color
		return bean;
	}
}
