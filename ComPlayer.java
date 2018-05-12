package chapter8;
/**
 * 人类玩家
 * @author cgfbe
 * @version 1.0
 * @copyright cgfbe
 * @date 2018年5月4日下午5:33:08
 */
public class ComPlayer {
	/** 静态常量：出拳类型的信息*/
	public static final int MessageTypeFist = 1;
	/** 静态常量：赢的时候的信息*/
	public static final int MessageTypeWinst = 2;
	/** 静态常量：输的时候的信息*/
	public static final int MessageTypeLosest = 3;
   //属性：名称、分数、所出的拳、角色对应的音效、角色的个性化台词
	private String name;
	private int score;
	private int first;
	// ..............
	// ** 角色在出拳的时候，说的个性化台词
	private String[] firstWords = {
			"动感光波~biubiu~~",
			"大象你的鼻子为什么这么长",
			"必杀：露屁屁外星人",
			"大姐姐你喜欢吃青椒吗？",
			"胸部扁扁的欧巴桑，吃我一拳"		
	};
	private String[] winWords = {
			"还有谁",
			"猜拳，有点意思",
			"~~~超神~~~",
			"全军出击",
			"吃着火锅唱着歌，然后你就输了"
	};
	
	private String[] loseWords = {
			"通往成功的路总在施工中",
			"等到潮水退去，就知道谁在裸泳",
			"夏天就是不好,穷的时候连西北风都没得喝",
			"将来我死了，QQ号就捐给希望工程",
			"众人皆醉我独醒，举世皆浊我独清"
	};
	/**
	 * 根据传入的消息类型，随机打印对应类型的消息
	 * @param msgType 对应humanplayer类中定义的静态信息
	 */
   public void sendMessage(int msgType){
	   //生成一个0-4的随机数字
	   int index = ((int)(Math.random() * 1000)) % 5;
	   String message = null; //要打印的消息
	   switch(msgType){
	   case MessageTypeFist:
		   message = firstWords[index];
		   break;
	   case MessageTypeWinst:
		   message = winWords[index];
		   break;
	   case MessageTypeLosest:
		   message = loseWords[index];
		   break;
		   
	   }
	   System.out.println(message);
   }
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	
	
	//方法：设置和得到的名称、分数、音效、个性化台词、出拳
	
}
