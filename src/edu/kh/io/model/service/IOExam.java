package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOExam {
	
	public void output1() {
		// 내부 -> 외부로 출력하는 것
		
		// 바이트 기반 스트림
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream("test2.txt");
			
			String str = "Hi";
			
			for(int i = 0 ; i < str.length(); i++) {
				
				fos.write(str.charAt(i));
			}
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				fos.close();
				
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
		}
		
	}

	
	
	public void output2() {
		
		FileWriter fw = null;
		
		try {
			
			String str = "Hello ! 안녕";
			
			fw = new FileWriter("test3.txt");
			
			fw.write(str);
			
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				fw.close();
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	
	
	public void input1() {
		// 외부 -> 내부 
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("test1.txt");
			
			while(true) {
				
				int data = fis.read();
				
				if(data == -1) {
					break;
					
				}
				System.out.print((char) data);

				
			}
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				fis.close();
			}catch(IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

	
	public void input2() {
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("test3.txt");
			
			while(true) {
				
				int data = fr.read();
				
				if(data == -1) {
					
					break;
				}
				
				System.out.print((char)data);
				
			}
			
		}catch(IOException e ) {
			
			e.printStackTrace();
			
		}finally {
			try{
				
				fr.close();
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
