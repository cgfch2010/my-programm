package chapter8;

import java.util.Scanner;

/**
 * 游戏房间
 * @author cgfbe
 * @version 1.0
 * @copyright cgfbe
 * @date 2018年5月8日下午9:37:58
 */
public class GameRoom {
	//属性：记分牌，道具，参与游戏的玩家、房间号、房间名称、房间的密码
   private HumanPlayer player1 = null;
   private ComPlayer player2 = null;
    //房间ID
    public long roomId;
     //房间名称
    public  String roomName;
     //房间密码
    public  String roomPass;
    public GameRoom(String roomName, String roomPass) throws InterruptedException{
    	do{
    		System.out.println("登录用户名或密码错误，请重新输入用户名和密码");
    		 roomName = new Scanner(System.in).next();
    		 roomPass = new Scanner(System.in).next();
    	}while(!("admin".equals(roomName) && "123".equals(roomPass)));
    	initGame();
    	startGame();
    	endGame();
    	
    }
    
  
  //方法：开始游戏、初始化游戏、显示菜单、选择人物、判断输赢
    
	public void initGame() throws InterruptedException {
    //1、实例化游戏玩家对象
		player1 = new HumanPlayer();
		player2 = new ComPlayer();
		for (int i = 0; i < 30; i++) {
			System.out.print("*");
			Thread.sleep(50);

		}
		
		System.out.println("\n游戏成功加载");
	}

	@SuppressWarnings("resource")
	public void startGame() {
	
		showMenu();
		choiceRole();
		gaming();
		
	}

/**
 * 游戏的大循环
 */
	private void gaming() {
		while(true){
		System.out.println(player1.getName() + "请出拳：");
		player1.setFirst(new Scanner(System.in).nextInt());
		int fist1 = player1.getFirst();
		player2.getFirst();
		int fist2 = player2.getFirst();
		//判断输赢
		int result = judge(fist1, fist2);  //调用方法判断结果
		if(result == -1){
			System.out.println("吉永老师：" + player1.getName() + "赢了");
			player1.sendMessage(HumanPlayer.MessageTypeWinst);
			player2.sendMessage(ComPlayer.MessageTypeLosest);
		}else if(result == 0){
			System.out.println("吉永老师：平了");
			player1.sendMessage(HumanPlayer.MessageTypeFist);
			player2.sendMessage(ComPlayer.MessageTypeFist);
		}else{
			System.out.println("吉永老师:" + player2.getName() + "赢了");
			player2.sendMessage(ComPlayer.MessageTypeWinst);
			player1.sendMessage(HumanPlayer.MessageTypeLosest);
		}
		System.out.println("你问是否继续游戏，Y/N");
		String answer = new Scanner(System.in).next();
		if( "n".equals(answer) || "N".equals(answer) ) break;
		}
		
	}

	public void showMenu() {
    System.out.println("欢迎进入《" + roomName + "》游戏房间");
    System.out.println("出拳规则：  1、剪刀     2、布      3、石头");
	}

	public void choiceRole() {
		System.out.println("对方角色：1、风间     2、妮妮   3、正南   4、阿呆");
		System.out.println("请选择");
		int choice = new Scanner(System.in).nextInt();
		String[] nameArray = { "风间", "妮妮", "正南", "阿呆" };
		player2.setName(nameArray[choice - 1]);
		player1.setName("野原新之助");
		System.out.println(player1.getName() + "VS" + player2.getName());
	}

	public int judge(int fist1, int fist2){
		if(fist1 == fist2) return 0;
		if(fist1 == 1 && fist2 == 3 || fist1 == 2 && fist2 == 1 || fist1 == 3 && fist2 == 2){
			//玩家1的分数+1
			player1.setScore(player1.getScore() + 1);
		    player2.setScore(player2.getScore() - 1);
			return -1;
		}//玩家2胜利
		player1.setScore(player1.getScore() - 1);
	    player2.setScore(player2.getScore() + 1);
		return 1;
	}
	public void endGame(){
		System.out.println(player1.getName() + "的得分是：" + player1.getScore());
		System.out.println(player2.getName() + "的得分是：" + player2.getScore());
		System.out.println("游戏已结束，欢迎下次光临！");
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
