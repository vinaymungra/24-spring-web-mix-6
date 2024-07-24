package com.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EProductBean;
import com.dao.EProductDao;
import com.service.FileUploadService;

@Controller
public class EProductController {
	
	
	@Autowired
	EProductDao productDao;
	@Autowired
	FileUploadService fileUploadService;
	
	@GetMapping("/newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean, @RequestParam("productPic") MultipartFile masterImage)
	{
		String productName=productBean.getProductPic().getOriginalFilename();
		String path="D:\\SpringBoot\\24-spring-web-mix-6\\src\\main\\webapp\\images\\products";
		String dbPath="images/products/"+productName;
		
		productBean.setProductPicPath(dbPath);
		fileUploadService.uploadProductImage(masterImage,path);
		productDao.addProduct(productBean);
		
		return "redirect:/products";
	}
	@GetMapping ("/products")
	public String listProducts(Model model)
	{
		List<EProductBean> products= productDao.getAllProducts();
		model.addAttribute("products",products);
		return "EcomListProducts";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		System.out.println("deleteProduct=> "+productId);
		productDao.deleteProduct(productId);
		return "redirect:/products";
	}
	
	@PostMapping("/deleteproductbyname")
	public String deleteProductByName(String productName)
	{
		System.out.println(productName);
		productDao.deleteProductByName(productName);
		return "redirect:/products";
	}
	
	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId, Model model) {

		EProductBean productBean = productDao.getProductById(productId);
		model.addAttribute("product", productBean);

		return "ViewProduct";
	}
	
	
	@GetMapping("/userproducts")
	public String liistProducts(Model model) {
		List<EProductBean> products =productDao.getAllProducts();
		model.addAttribute("products",products);
		return "EcomUserProducts";
		
	}
}
