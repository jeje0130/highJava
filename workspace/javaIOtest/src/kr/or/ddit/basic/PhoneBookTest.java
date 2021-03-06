package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
   
      HashMap<String, Phone> phoneBookMap = new HashMap<>();
      Scanner scan = new Scanner(System.in);
      
      String fileName = ("d:/d_other/PhoneData.dat");

   public static void main(String[] args) {
      
      new PhoneBookTest().phoneBookStart();

   }
   
   /*
    * 추가 조건
    * 1) 6. 전화번호 정보 저장 메뉴를 추가하고 구현한다.
    * 	(저장파일명은 'PhoneData.dat'로 한다)
    * 2) 프로그램이 시작할때 저장된 파일이 있으면
    * 	그 데이터를 읽어와 Map에 셋팅하여 사용한다
    * 3) 프로그램을 종료할 때 Map의 데이터가 변경되거나
    * 	추가 또는 삭제되면 저장한 후 종료되도록 한다.
    */
   
   
   /*
    * next(), nextInt(), nextDouble() 등
    * 	=> 사이띄기, Tab키, Enter키를 구분문자로 분리해서
    * 	      분리된 자료만 읽어간다.
    * 
    * nextLine() 
    * 	==> 한 줄 단위로 입력한다.
    * 		즉, 자료를 입력하고 Enter키를 누르면  Enter키까지 읽어간다.
    * 
    * Scanner 객체는 입력 버퍼에 자료가 남아있으면 새로 입력받지 않고
    * 입력 버퍼에 있는 값을 가져간다.		
    * 
    */
   

   private void phoneBookStart() {
      
      System.out.println("===============================");
      System.out.println("   전화 번호 관리 프로그램");
      System.out.println("===============================");
      System.out.println();
      
      while(true){
         int choice = displayMenu();
         switch(choice){
         case 1:      // 등록
            insert();
            break;
         case 2:      // 수정
            update();
            break;
         case 3:  
        	delete(); // 삭제
            break;
         case 4:      // 검색
        	search();
            break;
         case 5:      // 전체 출력
            displayAll();
            break;
         case 6:      // 저장
             save();
             break;   
         case 0:      //종료
            System.out.println("프로그램을 종료합니다.");
            return;
         default :
            System.out.println("작업 번호를 잘못 입력했습니다.");
            System.out.println("다시 입력하세요.");
         }
      }

   }
   //검색
   private void search() {

	      System.out.println();
	      System.out.println("검색할 전화번호 정보를 입력하세요.");
	      System.out.println("이 름 >> ");
	      String name = scan.next();
	    
	   // 이미 등록되어있는지 검사
	      if(!phoneBookMap.containsKey(name)) {
	         System.out.println(name + " 등록되지 않은 사람입니다.");
	         return;
	      }
	      
	      Phone p = phoneBookMap.get(name);
	      System.out.println("-------------검 색 결 과--------------");
	      System.out.println(name + "씨 전화번호 정보");
	      System.out.println("---------------------------------");
	      System.out.println("이름 : " + p.getName());
	      System.out.println("전화번호 : " + p.getTel());
	      System.out.println("주소 : " + p.getAddr());
	      System.out.println("---------------------------------");
  
   }
   
   // 전화번호 정보를 삭제하는 메서드
   private void delete() {

      System.out.println();
      System.out.println("삭제할 전화번호 정보를 입력하세요.");
      System.out.println("이 름 >> ");
      String name = scan.next();
      
   // 이미 등록되어있는지 검사
      if(!phoneBookMap.containsKey(name)) {
         System.out.println(name + "씨는 등록되지 않은 사람입니다.");
         return;
      }
      
      phoneBookMap.remove(name);
      
      System.out.println(name + "씨 전화번호 정보를 수정했습니다."); 
   }
   
   
   
   // 전화번호 정보를 수정하는 메서드
   private void update() {

      System.out.println();
      System.out.println("수정할 전화번호 정보를 입력하세요.");
      System.out.println("이 름 >> ");
      String name = scan.next();
      
      // 이미 등록되어있는지 검사
      if(!phoneBookMap.containsKey(name)) {
         System.out.println(name + "씨는 등록되지 않은 사람입니다.");
         return;
      }
      
      System.out.println("새로운 전화번호 >> ");
      String newTel = scan.next();
      
      System.out.println("새로운 주소 >> ");
      String newAddr = scan.next();
      
      phoneBookMap.put(name, new Phone(name, newAddr, newTel));
      
      System.out.println(name + "씨 전화번호 정보를 수정했습니다.");
      
      
      
   }

   // 전체 전화번호 정보를 출력하는 메서드
   private void displayAll() {

      System.out.println();
      Set<String> keySet = phoneBookMap.keySet();
      
      System.out.println("-----------------------------------------");
      System.out.println("  번호   이름      전화번호     주소 ");
      System.out.println("-----------------------------------------");
      if(keySet.size()==0) {
         System.out.println("출력할 데이터가 하나도 없습니다.");
      } else {
         int cnt = 0;
         for(String key : keySet) {
            Phone p = phoneBookMap.get(key);
            String tel = p.getTel();
            String addr = p.getAddr();
            System.out.println(cnt + "\t" + key + "\t" + tel + "\t" + addr);
         }
      }
      System.out.println("-----------------------------------------");
      System.out.println(" 출력 끝...");
      
   }
   
   
   

   // 새로운 전화번호 정보를 등록하는 메서드
   private void insert() {
      
      System.out.println();
      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
      System.out.println("이 름 >> ");
      String name = scan.next();
      
   
      // 이미 등록된 사람인지 검사
      if(phoneBookMap.containsKey(name)) {
         System.out.println(name + "씨는 이미 등록된 사람입니다.");
         return;
      }
      
      System.out.println("전화번호 >> ");
      String tel = scan.next();
      
      System.out.println("주 소 >> ");
      String addr = scan.next();
      
//      System.out.println(" >> ");
      
//      Phone p = new Phone(name, addr, tel);
//      phoneBookMap.put(name, p);
      
      phoneBookMap.put(name, new Phone(name, addr, tel));
      
      
      
      
   }
   
   

   // 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
   private int displayMenu(){
      
        System.out.println("----------------------------------------------");
        System.out.println("다음 메뉴를 선택하세요.");
                 
        System.out.println(" 1. 전화번호 등록");
        System.out.println(" 2. 전화번호 수정");
        System.out.println(" 3. 전화번호 삭제");
        System.out.println(" 4. 전화번호 검색");
        System.out.println(" 5. 전화번호 전체 출력");
        System.out.println(" 6. 전화번호 저장");
        System.out.println(" 0. 전화번호 종료");
        System.out.println("----------------------------------------------");
        System.out.print("번호 입력 >>");
      int num = scan.nextInt();
      
      return num;
      
   }
   
   
   /*// 파일에 저장된 전화번호 정보를 읽어오는 메서드
   private HashMap<String, Phone> load(){
	   //읽어온 데이터가 저장될 변수 선언
	   HashMap<String, Phone> pMap = null;
	   
	   File file =  new File(fileName);
	   if(!file.exists()){ 	// 저장된 파일이 없으면
		   return null;
	   }
	   
	   
	   ObjectInputStream ois = null;
	   try {
		//입력용 스트림 객체 생성
		   ois = new ObjectInputStream(
				   new BufferedInputStream(
						   new FileInputStream(file)));
		   
		   pMap = (HashMap<String, Phone>) ois.readObject();
	} catch (IOException e) {
		//e.printStackTrace();
		return null;
	} catch (ClassNotFoundException e) {
		//e.printStackTrace();
		return null;
	} finally{
		//사용했던 스트림 객체 닫기
		try { ois.close(); 	} catch (IOException e2) { }
	}
   }*/
   
   //전화번호 정보를 저장하는 메서드
   private void save(){
	   ObjectOutputStream oos = null;
	   
	   try {
		   //객체 출력용 스트림 객체 생성
		   oos = new ObjectOutputStream(
				   new BufferedOutputStream(
						   new FileOutputStream(fileName)));
		   
		   // Map 객체를 파일로 저장한다.
		   oos.writeObject(phoneBookMap);
		   
		   System.out.println("저장이 완료 되었습니다.");
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		//사용했던 스트림객체 닫기
		try { oos.close(); 	} catch (IOException e2) { }
	}
 
   }
   
   
   
}


class Phone implements Serializable{
private static final long serialVersionUID = 5212671553148841438L;
private String name;
   private String addr;
   private String tel;
      
   public Phone(String name, String addr, String tel) {
      super();
      this.name = name;
      this.addr = addr;
      this.tel = tel;
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getAddr() {
      return addr;
   }
   public void setAddr(String addr) {
      this.addr = addr;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
}


class Number implements Serializable{
	private static final long serialVersionUID = -1096438140999733430L;
	private String name;
	private String addr;
	private String tel;
	
	public Number(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}







