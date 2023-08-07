package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Last {

	public void output1() {
		// 바이트 기반 스트림
		FileOutputStream fos= null;
		
		try {
			
			fos = new FileOutputStream("text1.txt",true); // 1) 출력 스트림(통로) 객체 생성
			
			String str = "umm I leave home";
			
			for(int i = 0 ; i < str.length(); i++) { // 2) 입력 할 문자열의 길이를 받아 쪼개서 출력할 것. 
													// 쪼개서 출력하므로 charAt을 통해 문자를 쪼갬.
				
				fos.write(str.charAt(i));
				
			}
			
			
		}catch(IOException e){ // 3) IOException 이 발생하므로 처리해둠. (만약, Exception을 처리하고자 한다면, 밑에 작성해야 함! 왜냐면, 최상위 클래스이기 떄문에) 
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				fos.close(); // 4) 메모리 관리를 위해서 생성해둔 스트림(통로)를 차단해줘야 함. 이 작업이 자원 반환임.
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}	
		}
	}

	public void output2() {
		// 문자 기반 스트림
		
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("text1.txt");
			
			String str ="안녕하세요 감사해요 잘있어요 다시만나요! END !@#$%^&**(";
			
			fw.write(str); // 1) 
			
					
					
					
			
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
















}
