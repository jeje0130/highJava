package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 문제)
 * 'd:/d_other'폴더에 있는 '코알라.jpg'파일을
 * 'd:/d_other/연습용' 폴더에 '복사본-코알라.jpg'파일로
 * 복사하는 프로그램을 작성하시오.
 */


public class FileCopyTest {

	public static void main(String[] args) {
			File file = new File("d:/d_other/코알라.jpg");
			if(!file.exists()){
				System.out.println(file.getPath()+" 파일이 없습니다");
				System.out.println("복사 작업을 중지 합니다");
				return;
			}
			
			try {
				//복사할 파일 스트림 객체 생성
				FileInputStream fin = new FileInputStream(file);
				
				//저장될 파일 스트림 객체 생성
				FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/복사본-코알라.jpg");
				
				System.out.println("복사 시작");
				
				int data; // 읽어온 데이터가 저장될 변수
				
				while((data=fin.read()) != -1){
					fout.write(data);
				}
				
				//사용한 스트림 닫기
				fout.close();
				fin.close();
				System.out.println("복사 완료");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			
		

	}

}
