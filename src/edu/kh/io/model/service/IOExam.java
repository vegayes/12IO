package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOExam {
	
	
	// 바이트 기반 스트림 
	public void output1() {
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream("test1.txt",true);  // -- 1) 저장된 이름 값, 혹은 저장할 명 입력. (
													 // -- 2) 이어쓰기 위해서는 , true 추가
			
			String str = "Yo\n";
			
			for(int i = 0; i < str.length(); i++) { // -- 5) str의 길이 받아오기 length()
				
				fos.write(str.charAt(i));  // -- 3) FileOutputStream은 저장된 값이 하나씩 오기떄문에 문자를 하나하나씩 잘라서 가져와야 함! charAt(i)이용!
				
			}
			
			
		}catch(IOException e) { // -- 6) Exception 받는 경우 IOException 밑에 있으면 안됨.
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				fos.close();  // --4) 메모리 성능 향상을 위해서 스트림 닫아야 함! 닫음으로써 자원반환 (출력 시스템 닫음)
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
		}
	}
	
	
	// 문자 기반 스트림
	public void output2() {

		
		FileWriter fw = null;
		try {
			

			fw = new FileWriter("test5.txt",true);
			
			String str = "Hello my name is 은서! @#$%^\n";
			
			fw.write(str);  // -- 2) *********** 그냥 출력가능! 왜냐면, 버퍼형식으로 가지고 있기 떄문
							// write는 출력하는데, 한 줄을 통째로 보내려고 함. (=> 버퍼이용) 
							// 아직  버퍼에 담겨있는데, 그걸 강제로 밀어 넣어서 버퍼를 비우는 행위 (==> Finally 의 close)


		}catch(IOException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				fw.close(); // -- 1) 꼭 필요함! (버퍼형식으로 가지고 있어서 ..
				
			}catch(IOException e){
				
				e.printStackTrace();
				
			}
			
		}
	
	}
	
	// 바이트 기반 스트림
	public void input1() {		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("test1.txt");
			
			while(true) {  // --> 1) 왜 while문으로 받는가? :: 안의 데이터가 얼마나 들어있는지 모르기 떄문에 
				
				int data = fis.read(); // 다음 1byte를 읽어오는데 정수형을 가져옴.
				
//				System.out.println("\n" + data);
				
				if(data == -1) { // --3) 다음 내용이 없는 경우 -1을 반환함. 
					
					break;
				}
				System.out.print((char)(data)); // -- 2) read는 정수를 반환하기 때문에 문자로 하기 위해서는
												// char의 형변환을 해야함
			}
			
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
			
		}finally {
			
			try {
				
				fis.close();  // -- 3) 버퍼형식이라서 꼭 닫아야 함! 
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	
	}

	
	// 문자 기반 스트림
	public void input2() {
		
		FileReader fr = null;
		
		
		try {
			
			fr = new FileReader("test5.txt"); // -- 1) 생성자 (파일로부터 읽어오는 통로 객체 생성! 
			
			while(true) { //--> 이거 for문으로도 바꿀 수 있을까?
				
				int data = fr.read();
				
				if(data == -1 ) {
					
					break;
				}
				
				System.out.print((char)data); // 문자기반이라서 한글 출력 O 
				
			}
			
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				fr.close();
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}
			
		}	
		
	}
	

	
	
	
	
	
}
