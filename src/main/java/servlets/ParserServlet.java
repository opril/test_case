package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.DB;

public class ParserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ParserServlet() throws ClassNotFoundException {
        super();
        System.out.println("in constructor");
        Class.forName("org.postgresql.Driver");
        
        DB db = new DB();
        db.initAll();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("type");
		System.out.println("type: " + param);
		
		if (param != null) {
			if (param.equals("UsersAndForms")) {
				DB db = new DB();
				request.setAttribute("result", db.getUsersAndFormsForLastHour());
				request.getRequestDispatcher("/UsersAndFormsForLastHour.jsp").forward(request, response);
			} else if (param.equals("NotFinishedForms")) {
				DB db = new DB();
				request.setAttribute("result", db.getNotFinishedForms());
				request.getRequestDispatcher("/NotFinishedForms.jsp").forward(request, response);
			} else if (param.equals("Top5Forms")) {
				DB db = new DB();
				request.setAttribute("result", db.getTopFiveForms());
				request.getRequestDispatcher("/TopFiveForms.jsp").forward(request, response);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
