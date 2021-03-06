package kr.or.ddit.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//수신용, 송신용 패킷 객체변수 선언
		DatagramPacket inPacket, outPacket;
		
		//수신받은 데이터가 저장될 byte형 배열 선언
		byte[] bMsg = new byte[512];
		
		try {
			
			//포트번호를 지정하지 않고 Socket객체 생성(클라이언트용)
			DatagramSocket socket = new DatagramSocket();
			
			
			
			// 접속할 곳(서버)의 주소 생성
			//InetAddress address = InetAddress.getByAddress("localHost");
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			
			
			while(true){
				//전송할 메시지 입력
				System.out.println("보낼 메시지 입력 : ");
				String msg = scan.nextLine();
				
			
				
				byte[] sendMsg = msg.getBytes();
				//전송할 패킷 객체 생성
				outPacket = new DatagramPacket(sendMsg, sendMsg.length, address, 8888);
				
				
				
				//전송하기
				socket.send(outPacket);
				
				
				
				//메시지 중지 여부 검사
				if("/end".equals(msg)){ 
					break;
				}
				
				
				//-----------------------------------------------------------------------
				// 서버에서 온 데이터를 받아서 출력하기
				
				// 수신용 패킷객체 생성
				inPacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 수신하기
				socket.receive(inPacket);
				
				System.out.println("서버의 응답 데이터 : " + new String(bMsg, 0, inPacket.getLength()));
				
				System.out.println();
			}//while문
			
			System.out.println("통신 끝");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
