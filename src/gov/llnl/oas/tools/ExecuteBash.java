package gov.llnl.oas.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.chart.BubbleChart;

public class ExecuteBash {
	
	private ProcessBuilder processBuilder;
	
	public ExecuteBash() {
		super();
		// TODO Auto-generated constructor stub
		this.processBuilder = new ProcessBuilder();
	}
	
	public String execute(String path, String scriptName) throws InterruptedException {
		
		try {
			
//			System.out.println(path + "gov/llnl/oas/script/" + scriptName);
//			processBuilder.command("bash", "-c", "ls /home/mkyong/");
			
			String fileName = path + '/' + scriptName;
			
			File tempFile = new File(fileName);
			boolean exists = tempFile.exists();
			System.out.println(exists + ": " + fileName);
			
			
			this.processBuilder.command("chmod", "755", path + '/' + scriptName);	
			Process process = this.processBuilder.start();
			
			int exitVal = process.waitFor();
//			
			if (exitVal == 0) {
				System.out.println("Chmod Success!");
			}
				
			this.processBuilder.command("/bin/bash", path + '/' + scriptName);
//			this.processBuilder.command("/bin/bash", "/home/znan/apache-tomcat-9.0.22/webapps/OpenAnalysisService/BashScript/DeployDockerCallGraph.sh");

			
			process = this.processBuilder.start();
			
			StringBuilder output = new StringBuilder();
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			
			exitVal = process.waitFor();
			
			if (exitVal == 0) {
				System.out.println("Script Execution Success!");
//				System.out.println(output);
				return output.toString();
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
public String execute(String path, String scriptName, String parameter) throws InterruptedException {
		
		try {
			String fileName = path + '/' + scriptName;
			
			File tempFile = new File(fileName);
			boolean exists = tempFile.exists();
			System.out.println(exists + ": " + fileName);
			
			
			this.processBuilder.command("chmod", "755", path + '/' + scriptName);	
			Process process = this.processBuilder.start();
			
			int exitVal = process.waitFor();
//			
			if (exitVal == 0) {
				System.out.println("Chmod Success!");
			}
				
			this.processBuilder.command("/bin/bash", path + '/' + scriptName, parameter);
//			this.processBuilder.command("/bin/bash", "/home/znan/apache-tomcat-9.0.22/webapps/OpenAnalysisService/BashScript/DeployDockerCallGraph.sh");

			
			process = this.processBuilder.start();
			
			StringBuilder output = new StringBuilder();
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			
			exitVal = process.waitFor();
			
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				return output.toString();
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}
