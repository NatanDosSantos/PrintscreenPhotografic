package com.printscsysrq.files;

import java.io.File;
import java.io.IOException;

public class Main {
	 public static void main(String[]args)   {
		 try {
			 System.out.println("a");
			 Print print = new Print(new File("C:\\Users\\Baeta\\Desktop\\Natan\\HTML,CSS,JAVASCRIPT\\Nova pasta"),"jpg");
			 print.go(10);
			 System.out.println("a");

			 print.savePrints();
			 System.out.println("a");

		 }catch(Exception e) {
			 System.err.println(e);
		 }
	 }
}
