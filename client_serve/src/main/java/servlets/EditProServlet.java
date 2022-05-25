package servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;

import entity.Product;
/**
 * Servlet implementation class InsertProServlet
 */
@WebServlet("/EditProServlet")
public class EditProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//khai báo url service
		int id=Integer.valueOf(request.getParameter("id"));
		String url="http://localhost:8080/Resful_Lesson_One/project/san-pham/"+id;
		//tạo đối tượng client để get data từ service
		Client client=Client.create();
		String result=client.resource(url).get(String.class);
		
		Gson gson=new Gson();
		
		Product pro = gson.fromJson(result, Product.class);
		
		//chuyển hướng
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		//khai báo url service
		String url="http://localhost:8080/Resful_Lesson_One/project/san-pham";
		//tạo đối tượng client để get data từ service
		Client client=Client.create();
		//láy dwxl iệu từ form
		int id= Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float price=Float.valueOf(request.getParameter("price"));
		float sale_price=Float.valueOf(request.getParameter("sale_price"));
		String description=request.getParameter("description");
		String image=request.getParameter("image");
		Boolean status=Boolean.valueOf(request.getParameter("status"));
		
		Product p=new Product(id, name, price, sale_price, description, image, status);
		Gson gson=new Gson();
		String datajson=gson.toJson(p);
		//post data
		String result=client.resource(url).header("Content-Type", "application/json;charset=UTF8").put(String.class,datajson);
		//chuyển hướng
		response.sendRedirect("/client_serve");
	}

}