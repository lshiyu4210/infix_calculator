package project1;
//author: Shiyu Liu

import java.io.*;
import java.util.*;

public class ICtest {
	
	public static void main(String[] args) throws IOException  {
		String filePath = args[0];
		String writerPath = args[1];
		File file = new File(filePath);
		Scanner scan = new Scanner(file);
		InfixCalculator IC = new InfixCalculator();
        PrintWriter writer = new PrintWriter(writerPath);
  
	    while(scan.hasNextLine()) {
			IC.InfixToPostfix(scan.nextLine());
			double result = IC.calculator();
			if(result >= 1000000 || result <= -1000000) 
				writer.printf("%.2e%n",result);
			else 
				writer.printf("%.2f%n",result);
		}
	
		writer.close();
		
		
		
		
		
		
		
		
	
	}

}
