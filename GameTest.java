package chapter8;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.out.println("�����뷿�����͵�¼���룺");
  String roomName = new Scanner(System.in).next();
	  String roomPass = new Scanner(System.in).next();
        new GameRoom(roomName,roomPass);
  
	}

}
