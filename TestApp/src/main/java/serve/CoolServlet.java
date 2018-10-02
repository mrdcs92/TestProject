package serve;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoolServlet
 */
public class CoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoolServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("this is the coolservlet firing");
		if(request.getRequestURI().equals("/TestApp/mountain.do")) {
			response.sendRedirect("/TestApp/blahblah.html");
		}
//		 else {
//			response.getWriter().append("Served at hello: ").append(request.getContextPath());
//		}
		
//		ServletContext sc = this.getServletContext();
//		String contextValue = sc.getInitParameter("Team");
//		System.out.println(contextValue);
//		
//		ServletConfig sconfig = this.getServletConfig();
//		String configValue = sconfig.getInitParameter("Quarterback");
//		System.out.println(contextValue + " " + configValue);
		RequestHelper.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
