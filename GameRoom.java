package chapter8;

import java.util.Scanner;

/**
 * ��Ϸ����
 * @author cgfbe
 * @version 1.0
 * @copyright cgfbe
 * @date 2018��5��8������9:37:58
 */
public class GameRoom {
	//���ԣ��Ƿ��ƣ����ߣ�������Ϸ����ҡ�����š��������ơ����������
   private HumanPlayer player1 = null;
   private ComPlayer player2 = null;
    //����ID
    public long roomId;
     //��������
    public  String roomName;
     //��������
    public  String roomPass;
    public GameRoom(String roomName, String roomPass) throws InterruptedException{
    	do{
    		System.out.println("��¼�û�����������������������û���������");
    		 roomName = new Scanner(System.in).next();
    		 roomPass = new Scanner(System.in).next();
    	}while(!("admin".equals(roomName) && "123".equals(roomPass)));
    	initGame();
    	startGame();
    	endGame();
    	
    }
    
  
  //��������ʼ��Ϸ����ʼ����Ϸ����ʾ�˵���ѡ������ж���Ӯ
    
	public void initGame() throws InterruptedException {
    //1��ʵ������Ϸ��Ҷ���
		player1 = new HumanPlayer();
		player2 = new ComPlayer();
		for (int i = 0; i < 30; i++) {
			System.out.print("*");
			Thread.sleep(50);

		}
		
		System.out.println("\n��Ϸ�ɹ�����");
	}

	@SuppressWarnings("resource")
	public void startGame() {
	
		showMenu();
		choiceRole();
		gaming();
		
	}

/**
 * ��Ϸ�Ĵ�ѭ��
 */
	private void gaming() {
		while(true){
		System.out.println(player1.getName() + "���ȭ��");
		player1.setFirst(new Scanner(System.in).nextInt());
		int fist1 = player1.getFirst();
		player2.getFirst();
		int fist2 = player2.getFirst();
		//�ж���Ӯ
		int result = judge(fist1, fist2);  //���÷����жϽ��
		if(result == -1){
			System.out.println("������ʦ��" + player1.getName() + "Ӯ��");
			player1.sendMessage(HumanPlayer.MessageTypeWinst);
			player2.sendMessage(ComPlayer.MessageTypeLosest);
		}else if(result == 0){
			System.out.println("������ʦ��ƽ��");
			player1.sendMessage(HumanPlayer.MessageTypeFist);
			player2.sendMessage(ComPlayer.MessageTypeFist);
		}else{
			System.out.println("������ʦ:" + player2.getName() + "Ӯ��");
			player2.sendMessage(ComPlayer.MessageTypeWinst);
			player1.sendMessage(HumanPlayer.MessageTypeLosest);
		}
		System.out.println("�����Ƿ������Ϸ��Y/N");
		String answer = new Scanner(System.in).next();
		if( "n".equals(answer) || "N".equals(answer) ) break;
		}
		
	}

	public void showMenu() {
    System.out.println("��ӭ���롶" + roomName + "����Ϸ����");
    System.out.println("��ȭ����  1������     2����      3��ʯͷ");
	}

	public void choiceRole() {
		System.out.println("�Է���ɫ��1�����     2������   3������   4������");
		System.out.println("��ѡ��");
		int choice = new Scanner(System.in).nextInt();
		String[] nameArray = { "���", "����", "����", "����" };
		player2.setName(nameArray[choice - 1]);
		player1.setName("Ұԭ��֮��");
		System.out.println(player1.getName() + "VS" + player2.getName());
	}

	public int judge(int fist1, int fist2){
		if(fist1 == fist2) return 0;
		if(fist1 == 1 && fist2 == 3 || fist1 == 2 && fist2 == 1 || fist1 == 3 && fist2 == 2){
			//���1�ķ���+1
			player1.setScore(player1.getScore() + 1);
		    player2.setScore(player2.getScore() - 1);
			return -1;
		}//���2ʤ��
		player1.setScore(player1.getScore() - 1);
	    player2.setScore(player2.getScore() + 1);
		return 1;
	}
	public void endGame(){
		System.out.println(player1.getName() + "�ĵ÷��ǣ�" + player1.getScore());
		System.out.println(player2.getName() + "�ĵ÷��ǣ�" + player2.getScore());
		System.out.println("��Ϸ�ѽ�������ӭ�´ι��٣�");
	}
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomPass() {
		return roomPass;
	}
	public void setRoomPass(String roomPass) {
		this.roomPass = roomPass;
	}
    
    
	
    
}
