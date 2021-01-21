package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test.dat");
			
			//자료형 단위로 출력할 보조 스트림 DataOutputStream객체 생성
			DataOutputStream dos = new DataOutputStream(fout);
			
			dos.writeInt(200);
			dos.writeFloat(123.45f);
			dos.writeBoolean(true);
			dos.writeUTF("ABCDabcd");
			
			System.out.println("출력완료");
			dos.close();
			
			//------------------------------------------------------
			// 출력한 자료 읽어오기
			FileInputStream fin = new FileInputStream("d:/d_other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			//출력할때의 순서와 같은 순서로 읽어봐야한다.
		    System.out.println("정수형 : " + din.readInt());
		    System.out.println("실수형 : " + din.readFloat());
		    System.out.println("물리형 : " + din.readBoolean());
		    System.out.println("문자형 : " + din.readUTF());
		    
		    System.out.println();
		    System.out.println("읽기 작업완료");
		    din.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}