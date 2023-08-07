package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream; // io 클래스 : 자바의 입출력과 관련된 거 모음.
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {

	//IO
	
	// Input(입력) : 외부 -> 내부로 데이터를 들여오는 것
	// Output(출력) : 내부 -> 외부로 데이터를 내보내는 것
	
	// Stream : 입/출력 통로 역할(데이터가 흘러가는 통로)
	//           기본적으로 Stream은 단방향
	// 종류) byteStream , charStream
	
	// 1) 파일 출력 예제 (내부 == 프로그램, 외부 == 파일) 
	public void output1() {

		
		// 1) 바이트 기반 스트림 이용
		FileOutputStream fos = null;
		
		// FileOutputStream 객체 생성 시
		// FileNotFoundException(파일을 찾을 수 없음) / IOException 예외가 발생할 가능성이 있음. 
		// --> 예외처리 필요
		// IOException이 FileNotFoundException의 부모
		
		try {
			
			fos = new FileOutputStream("test1.txt"); 
			// 현재 프로그램에서 test1.txt파일로 출력하는 통로 객체 생성
			// 없으면, 자동으로 만들어줌. 
			
			// 파일에 "Hello" 내보내기
			String str = "Hello";
			
			for ( int i = 0; i < str.length(); i++) { //향상된 for문은 String에서 안됨?
				
				// "Hello"를 한문자씩 끊어서 파일로 출력
				fos.write(str.charAt(i));
				//void java.io.FileOutputStream.write(int b) throws IOException
				// write()는 IOException을 발생시킬 가능성이 있다.
			}
			
		}catch(IOException e) { // 다형성 적용하여 부모만 예외처리 해둠.
			// FileNotFoundException , IOException 순으로 catch 잡아야 함. ( 최상위 클래스 밑으로 보내기 ) 
				
			System.out.println("예외 발생");
			e.printStackTrace(); // 예외 추적 
		}finally {
			// 예외가 발생하든 말든 무조건 수행 
			
			// 사용한 스트림 자원을 반환 ( 통로 없앰 ) == 자원반환  -> 필수 작성!!
			// 프로그램 메모리 관리 차원에서 항상 다쓰면 끊어줌.
			// -> 작성 안하면 문제점으로 꼽을 수 있다!
			try {
				fos.close(); // fos.close가 IOException이 날 가능성이 있기 때문에 try-catch사용
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
	}
	
	// 2) 파일 출력 
	// 문자 기반 스트림 
	public void output2() {
		
		FileWriter fw = null;
		// 프로그램 -> 파일로 쓰는 문자 기반 스트림
		
		try {
			
			fw = new FileWriter("test1.txt"); // 외부 파일과 연결하는 스트림 객체 생성
			// 이미 만들어진 파일이면, 덮어쓰기 됨.
			
			String str = "안녕하세요.  Hello. 1 2 3 4  ! ~ @ #";
			
			fw.write(str); 
			// 실행 했는데, 출력이 안되고 있음.
			// --> 한 줄을 통째로 보내기 위해서 "버퍼"를 이용함. 
			// => 아직 버퍼에 담겨있음! 이걸 강제로 밀어넣어서 버퍼를 비워야 함! 
			// 그러므로 finally 써야 함! 
			
			// close() 구문을 수행하면, 통로에 남아있는 내용을 모두 내보내고 통로를 없앤다! 
	
			// 문자 기반은 왜 한 글자씩 안잘라도 되는가?  == 버퍼형식이라서?
			
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	// 3) 파일 입력  : 외부(파일) -> 내부(프로그램 콘솔창)으로 읽어오기
	// (바이트 기반 스트림)
	public void input1() {
		
		FileInputStream fis = null;
		// 파일 -> 프로그램으로 읽어오는 바이트 기반 스트림
		
		try {
			
			fis = new FileInputStream("test1.txt");  //test1.txt에서 읽어옴
			
			// FileInputStream은 1byte씩만 읽어올 수 있다.
			
			while(true) {
					// FileInputStream안에 read가 있음.
					int data = fis.read(); // 다음 1byte를 읽어오는데 정수형임. 
										   // 다음 내용이 없으면 -1 반환 
			
					if(data == -1) { // 다음 내용 없음 => 종료 
						break;
					}
					
					
					// 반복 종료가 안됐으면 char로 강제 형변환 하여 문자로 출력
					System.out.print((char) data);
					// 1byte가 아닌 한글은 다른 글자들이 출력됨.
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
	
	
	// 4) 파일 입력 ( 문자 기반 스트림)
	public void input2() {
		
		FileReader fr = null;
				
		try {
			
			fr = new FileReader("test1.txt"); // 파일로부터 읽어오는 통로 객체 생성
			
			while(true) {
				int data = fr.read(); // 다음 한문자를 읽어옴. 없으면 -1반환
				
				if(data == -1) {
					break;
				}
				
				System.out.print((char) data);
				// 문자기반은 한글 잘 나옴.
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
