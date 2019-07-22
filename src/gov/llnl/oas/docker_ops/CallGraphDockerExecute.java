package gov.llnl.oas.docker_ops;

import gov.llnl.oas.tools.ExecuteBash;

public class CallGraphDockerExecute {

	public CallGraphDockerExecute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String run_script(String path, String scriptName, String parameter) {
		// run script
		// Docker images is downloaded separately
		// Only execute the image at this stage.
		// The script will be stored inside web content folder
		
		ExecuteBash executeBash = new ExecuteBash();
		String result = new String();
		try {
			result = executeBash.execute(path, scriptName, parameter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
