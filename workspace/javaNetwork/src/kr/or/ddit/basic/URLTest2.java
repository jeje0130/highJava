package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest2 {

   public static void main(String[] args) throws IOException {
      // URL Connection 클래스 ==> 애플리케이션과, URL간의 통신 연결을 위한 클래스
      // ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스

      // 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
      URL url = new URL("https://www.naver.com/index.html");

      // 주어진 URL 주소에 접속하기 위해 URLConnection 객체를 구한다.
      URLConnection urlCon = url.openConnection();

      // Header 정보 가져오기
      Map<String, List<String>> headerMap = urlCon.getHeaderFields();

      // headerMap의 키값과 value값 출력하기.
      for (String headerkey : headerMap.keySet()) {
         System.out.println(headerkey + " : " + headerMap.get(headerkey));

      }
         System.out.println("----------------------------");
         
      // URL주소에 지정한 해당 문서의 내용 가져오기
      // (index.html문서의 내용을 가져온다.)
         
//      // 방법1) --> URLConnection객체를 이용하는 방법
//         
//      // 파일 내용을 읽어오기 위한 스트림 객체 생성
//      InputStream is = urlCon.getInputStream();
//      InputStreamReader isr = 
//            new InputStreamReader(is, "utf-8");
//      BufferedReader br = new BufferedReader(isr);
//      
//      // 자료를 읽어와 화면에 출력하기
//      while(true){
//         String str = br.readLine(); // 한 줄씩 읽기
//         if(str==null) break;
//         System.out.println(str);
//      }
//      
//      br.close();
         
      // 방법2) --> URL객체의 openStream()메서드 이용하기
   
      InputStream is2 = url.openStream();
      InputStreamReader isr2 = 
            new InputStreamReader(is2, "utf-8");
      BufferedReader br2 = new BufferedReader(isr2);
      
      // 자료를 읽어와 화면에 출력하기
      while(true){
         String str = br2.readLine(); // 한 줄씩 읽기
         if(str==null) break;
         System.out.println(str);
      }
      
      br2.close();   
         
   }

}