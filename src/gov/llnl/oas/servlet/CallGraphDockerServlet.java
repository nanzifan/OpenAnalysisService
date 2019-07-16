package gov.llnl.oas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.llnl.oas.docker_deploy.CallGraphDockerDeploy;

/**
 * Servlet implementation class CallGraphDocker
 */
@WebServlet(description = "deploy call graph docker", urlPatterns = { "/CallGraphDocker" })
public class CallGraphDockerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallGraphDockerServlet() {
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
		System.out.println("start deploying call graph docker");
		
		String path = getServletContext().getRealPath("/BashScript");
		
		
		System.out.println("Current path is: " + path);
		
		CallGraphDockerDeploy callGraphDeploy = new CallGraphDockerDeploy();
//		String result = callGraphDeploy.run_script("E:\\Code\\JavaCode\\OpenAnalysisService\\BashScript", "test.sh");
		String result = callGraphDeploy.run_script(path, "DeployDockerCallGraph.sh");

		System.out.println("Running result is: "+ result);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/result_script_test.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("call graph docker deployed");
	}

}
