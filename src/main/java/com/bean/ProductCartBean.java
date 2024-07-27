package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class ProductCartBean {
	private Integer cartId;
	private Integer qty;
	private Integer productId;
	private String productName;
	private Float price;
	private String category;
	private MultipartFile productPic;
	private String productPicPath;
	
	public String getProductPicPath() {
		return productPicPath;
	}
	public void setProductPicPath(String productPicPath) {
		this.productPicPath = productPicPath;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public MultipartFile getProductPic() {
		return productPic;
	}
	public void setProductPic(MultipartFile productPic) {
		this.productPic = productPic;
	}
	
}
