package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service=new ProductService();
		String action=request.getParameter("action");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.print("<h2 align='center'>Product Management System</h2><hr>");
		
		if(action.equals("view")){
			List<Product> resultOfView =service.viewAllProducts();
			pw.print("<h4 align='center'>Product List</h4>");
			pw.print("<table border='1' align='center' width='80%'>");
			pw.print("<tr> <th width='20%'>Product ID</th>"
					+ "<th width='20%'>Name</th>"
					+ "<th width='20%'>Price</th>"
					+ "<th width='20%'>Qty</th>");
			for(Product p:resultOfView) {
				pw.print("<tr>");
				pw.print("<td>" + p.getProductId() + "</td>");
				pw.print("<td>" + p.getName() + "</td>");
				pw.print("<td>" + p.getPrice() + "</td>");
				pw.print("<td>" + p.getQuantityAvailable() + "</td>");
				pw.print("<td align='center'><a href='ProductServlet?action=delete&pid="+p.getProductId()+"'>Delete</a></td>");
				pw.print("</tr>");
			}
				}
		
		else if(action.equals("update")){
			int id=Integer.parseInt(request.getParameter("id"));
			double price=Double.parseDouble(request.getParameter("price"));
            boolean updateresult=service.updateProduct(id,price);
            if(updateresult) {
    			pw.print("<h4 align='center'><font color='green'>Update Successfull</h4>");
            }
            else {
    			pw.print("<h4 align='center'><font color='red'>Error!!</h4>");

            }
            
			List<Product> resultOfView =service.viewAllProducts();
			pw.print("<h4 align='center'>Product List</h4>");
			pw.print("<table border='1' align='center' width='80%'>");
			pw.print("<tr> <th width='20%'>Product ID</th>"
					+ "<th width='20%'>Name</th>"
					+ "<th width='20%'>Price</th>"
					+ "<th width='20%'>Qty</th>");
			for(Product p:resultOfView) {
				pw.print("<tr>");
				pw.print("<td>" + p.getProductId() + "</td>");
				pw.print("<td>" + p.getName() + "</td>");
				pw.print("<td>" + p.getPrice() + "</td>");
				pw.print("<td>" + p.getQuantityAvailable() + "</td>");
				pw.print("<td align='center'><a href='ProductServlet?action=delete&pid="+p.getProductId()+"'>Delete</a></td>");
				pw.print("</tr>");
			}
				}
		
		
		else if(action.equals("delete")){
			int id=Integer.parseInt(request.getParameter("pid"));
            boolean deleteresult=service.deleteProduct(id);
            if(deleteresult) {
    			pw.print("<h4 align='center'><font color='green'>Deleted Successfullu</h4>");
            }
            else {
    			pw.print("<h4 align='center'><font color='red'>Error!!</h4>");

            }
            
			List<Product> resultOfView =service.viewAllProducts();
			pw.print("<h4 align='center'>Product List</h4>");
			pw.print("<table border='1' align='center' width='80%'>");
			pw.print("<tr> <th width='20%'>Product ID</th>"
					+ "<th width='20%'>Name</th>"
					+ "<th width='20%'>Price</th>"
					+ "<th width='20%'>Qty</th>");
			for(Product p:resultOfView) {
				pw.print("<tr>");
				pw.print("<td>" + p.getProductId() + "</td>");
				pw.print("<td>" + p.getName() + "</td>");
				pw.print("<td>" + p.getPrice() + "</td>");
				pw.print("<td>" + p.getQuantityAvailable() + "</td>");
				pw.print("<td align='center'><a href='ProductServlet?action=delete&pid="+p.getProductId()+"'>Delete</a></td>");
				pw.print("</tr>");
			}
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service=new ProductService();
		String action=request.getParameter("action");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.print("<h2 align='center'>Product Management System</h2><hr>");
		
		if(action.equals("register")){
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			double price=Double.parseDouble(request.getParameter("price"));
			int qty=Integer.parseInt(request.getParameter("qty"));

            Product prod=new Product(id,name,price,qty);
            boolean result=service.registerProduct(prod);
            if(result) {
    			pw.print("<h4 align='center'><font color='green'>Registered Successfully</h4>");
            }
            else {
    			pw.print("<h4 align='center'><font color='red'>Error!!</h4>");

            }
			
			List<Product> resultOfView =service.viewAllProducts();
			pw.print("<h4 align='center'>Product List</h4>");
			pw.print("<table border='1' align='center' width='80%'>");
			pw.print("<tr> <th width='20%'>Product ID</th>"
					+ "<th width='20%'>Name</th>"
					+ "<th width='20%'>Price</th>"
					+ "<th width='20%'>Qty</th>");
			for(Product p:resultOfView) {
				pw.print("<tr>");
				pw.print("<td>" + p.getProductId() + "</td>");
				pw.print("<td>" + p.getName() + "</td>");
				pw.print("<td>" + p.getPrice() + "</td>");
				pw.print("<td>" + p.getQuantityAvailable() + "</td>");
				pw.print("<td align='center'><a href='ProductServlet?action=delete&pid="+p.getProductId()+"'>Delete</a></td>");
				pw.print("</tr>");
			}
				}
		

}
}