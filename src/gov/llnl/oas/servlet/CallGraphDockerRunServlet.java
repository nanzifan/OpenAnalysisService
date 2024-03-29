package gov.llnl.oas.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.llnl.oas.docker_ops.CallGraphDockerExecute;

/**
 * Servlet implementation class CallGraphDockerExecuteServlet
 */
@WebServlet("/CallGraphDockerExecuteServlet")
public class CallGraphDockerRunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallGraphDockerRunServlet() {
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
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		System.out.println("start executing call graph docker");
		
		String path = getServletContext().getRealPath("/BashScript");
		System.out.println("Current path is: " + path);
		
		String dockerID = request.getParameter("docker_id");
		System.out.println("Current docker id is: " + dockerID);
		
		CallGraphDockerExecute callGrapheExec = new CallGraphDockerExecute();
		String value = callGrapheExec.run_script(path, "ExecuteDockerCallGraph.sh", dockerID);
		
		String result = value;
//		String result = value.replace("\n", "");
		
		System.out.println("Running result is: "+ result);
		
		request.setAttribute("result", result);
		request.setAttribute("dockerID", dockerID);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/call_graph_docker_execute.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("call graph executed");
	}

}
