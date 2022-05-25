package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.jersey.api.client.Client;
/**
 * Servlet implementation class DeleteProServlet
 */
@WebServlet("/DeleteProServlet")
public class DeleteProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProServlet() {
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
		String result=client.resource(url).delete(String.class);
		//chuyển hướng
		response.sendRedirect("/client_serve");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
