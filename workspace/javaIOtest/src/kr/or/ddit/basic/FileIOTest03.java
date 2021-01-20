package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		try {
			// 문자 기반의 스트림을 이용하여 파일 내용 읽어와 출력하기
			FileReader fr = new FileReader("d:/d_other/test.txt");
			
			int c;
			
			while( (c=fr.read()) != -1){
				// 읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
			}
			
			fr.close(); //작업완료 후 스트림 객체 닫기
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
