package edu.kh.io.run;

import edu.kh.io.model.service.IOExam;
import edu.kh.io.model.service.IOService;
import edu.kh.io.model.service.Last;

public class IORun {

	public static void main(String[] args) {
		
		IOService service = new IOService();
		
//		service.output1();
//		service.output2();
//		service.input1();
//		service.input2();
		
		
		IOExam exam = new IOExam();
		
//		exam.output1();
//		exam.output2();
//		exam.input1();
//		exam.input2();
		
		Last last = new Last();
		
		last.output1();
		last.output2();
		last.input1();
		
		
		
	}
	
	
}
