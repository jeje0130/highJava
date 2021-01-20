package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	HashMap<Integer, Room> hotelMap = new HashMap<>();
	Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		new Hotel().hotelStart();

	}
	
	 private void hotelStart() {
	      
	      System.out.println("*********************************************");
	      System.out.println("      	 호텔문을 열었습니다. 어서오십시요.");
	      System.out.println("*********************************************");
	      System.out.println();
	      
	      while(true){
	         int choice = hotelMenu();
	         switch(choice){
	         case 1:      // 체크인
	            checkIn();
	            break;
	         case 2:      // 체크아웃
	        	checkOut();
	            break;
	         case 3:  
	        	roomAll(); // 객실상태
	            break;
	         case 4:      // 업무종료
	        	 System.out.println("*********************************************");
	        	 System.out.println("      		 호텔문을 닫았습니다.");
	        	 System.out.println("*********************************************");
		            return;
	         default :
	            System.out.println("작업 번호를 잘못 입력했습니다.");
	            System.out.println("다시 입력하세요.");
	         }
	      }

	 }
	 
	 
	 
	 private int hotelMenu(){
	      
	       System.out.println("----------------------------------------------");
	       System.out.println("어떤 업무를 하시겠습니까?");
	                 
	        System.out.print("1. 체크인     ");
	        System.out.print("     2. 체크아웃");
	        System.out.print("     3. 객실상태");
	        System.out.println("     4. 업무종료");
	        System.out.println("----------------------------------------------");
	        System.out.print("선택 >>");
	        int num = scan.nextInt();
	      
	        return num;
	      
	   }
	 
	 
	 
	 private void roomAll(){
		  System.out.println();
	      Set<Integer> keySet = hotelMap.keySet();
	      
	      System.out.println("-----------------------------------------");
	      System.out.println("		                  현재 객실 상태");
	      System.out.println("-----------------------------------------");
	      System.out.println("방 번호	       방 종류	         투숙객 이름 ");
	      System.out.println("-----------------------------------------");
	      if(keySet.size()==0) {
	         System.out.println("출력할 데이터가 하나도 없습니다.");
	      } else {
	         int cnt = 0;
	         for(Integer key : keySet) {
	            Room r = hotelMap.get(key);
	            String roomStyle = r.getRoomStyle();
	            String name = r.getName();
	            System.out.println(cnt + "\t" + key + "\t" + roomStyle + "\t" + name);
	         }
	      }
	      System.out.println("-----------------------------------------");
	      
	 }
		 
		 
	 
	 
	 
	 
	 
	 
	 //체크아웃
	 private void checkOut(){
		 	System.out.println();
		 	System.out.println("------------------------------");
		 	System.out.println("	체크아웃 작업");
		 	System.out.println("------------------------------");
		 	System.out.println("체크아웃 할 방 번호를 입력하세요.");
		 	System.out.println("------------------------------");
		 	System.out.print("방 번호 입력 >>");
		 	int roomNum = scan.nextInt();
		 	
		 	if(hotelMap.remove(roomNum) == null) {
		 		System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
		 	}else {
		 		System.out.println(roomNum + "호 객실  체크아웃을 완료하였습니다.");
		 	}
		 	
//		 	if(hotelMap.containsKey(roomNum)){
//		 		System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
//		         return;
//		 	}
//		 	
//		 	if(hotelMap.containsValue(roomNum)){ 
//		 		System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
//		         return;
//		 	}
		 
		 
		 
	 }
	 
	 //체크인
	 private void checkIn(){
		 	System.out.println();
		 	System.out.println("------------------------------");
		 	System.out.println("	 체크인  작업");
		 	System.out.println("------------------------------");
		 	System.out.println("   * 201~209 : 싱글룸");
		 	System.out.println("   * 301~309 : 더블룸");
		 	System.out.println("   * 401~409 : 스위트룸");
		 	System.out.println("------------------------------");
		 	System.out.print("방 번호 입력 >>");
		 	int roomNum = scan.nextInt();
		 	
		 	if(hotelMap.containsKey(roomNum)){
		 		System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
		         return;
		 	}
		 	
		 	scan.nextLine();
		 	System.out.println("누구를 체크인 하시겠습니까?");
		 	System.out.println("이름 입력>>");
		 	String name = scan.nextLine();
		 	
		 	hotelMap.put(roomNum, new Room(roomNum, name));
		 	System.out.println(name + "님 체크인이 완료되었습니다.");
	 }
	 
	 

}

class Room{
	private int roomNum;
	private String roomStyle;
	private String name;
	   
	public Room(int roomNum, String roomStyle) {
		super();
		this.roomNum = roomNum;
		this.roomStyle = roomStyle;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
	   
	   






