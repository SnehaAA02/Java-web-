package com.service;


import java.util.List;

import com.DAO.ProductDAO;
import com.bean.Product;

		public class ProductService {
			public List<Product> viewAllProducts(){
				ProductDAO dao=new ProductDAO();
				return dao.viewAllProduct();
			}
	   public boolean registerProduct(Product p) {
		   ProductDAO dao=new ProductDAO();
			return dao.registerProduct(p);
	   }
	   public boolean updateProduct(int id,double price) {
		   ProductDAO dao=new ProductDAO();
			return dao.updateProduct(id,price);
	   }
	   public boolean deleteProduct(int id) {
		   ProductDAO dao=new ProductDAO();
			return dao.deleteProduct(id);
	   }
	
}
