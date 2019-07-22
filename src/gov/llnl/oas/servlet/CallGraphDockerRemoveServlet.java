package gov.llnl.oas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.llnl.oas.docker_ops.CallGraphDockerDeploy;

/**
 * Servlet implementation class CallGraphDockerDeleteServlet
 */
@WebServlet(description = "Delete call graph docker", urlPatterns = { "/CallGraphDockerDeleteServlet" })
public class CallGraphDockerRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallGraphDockerRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("Deleting call graph docker container");
		
		String path = getServletContext().getRealPath("/BashScript");
		
		String dockerID = request.getParameter("dockerID");
		System.out.println("Current docker id is: " + dockerID);
		
		CallGraphDockerDeploy callGraphDeploy = new CallGraphDockerDeploy();

//		String result = "test";
		String result = callGraphDeploy.run_script(path, "StopDockerContainer.sh", dockerID);

		System.out.println("Running result is: "+ result);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("call graph docker deleted");
	}

}
