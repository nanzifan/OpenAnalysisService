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
 * Servlet implementation class CallGraphDocker
 */
@WebServlet(description = "deploy call graph docker", urlPatterns = { "/CallGraphDocker" })
public class CallGraphDockerDeployServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallGraphDockerDeployServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("start deploying call graph docker");
		
		String path = getServletContext().getRealPath("/BashScript");
		
		
		System.out.println("Current path is: " + path);
		
		CallGraphDockerDeploy callGraphDeploy = new CallGraphDockerDeploy();
		String value = callGraphDeploy.run_script(path, "DeployDockerCallGraph.sh");
		
//		String result = "test";
		String result = value.replace("\n", "");
		
		System.out.println("Running result is: "+ result);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/call_graph_docker_deploy.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("call graph docker deployed");
	}

}
