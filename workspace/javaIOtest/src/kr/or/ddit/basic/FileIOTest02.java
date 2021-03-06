package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// 파일에 데이터를 출력하는 연습
		try {
			
			//파일을 출력용 스트림 객체 생성
			FileOutputStream fos = new FileOutputStream("d:/d_other/out.txt");
			
			for(char ch='A'; ch<='Z'; ch++){
				fos.write(ch);
			}
			System.out.println("작업완료!!");
			fos.close();
			
			//==================================================================
			// 위에서 저장한 데이터를 읽어와 화면에 출력하시오.
			File file = new File("d:/d_other/out.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int a;
			
			while ( (a = fin.read()) != -1){
				System.out.print((char)a);
			}
			
			fin.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
