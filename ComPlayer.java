package chapter8;
/**
 * �������
 * @author cgfbe
 * @version 1.0
 * @copyright cgfbe
 * @date 2018��5��4������5:33:08
 */
public class ComPlayer {
	/** ��̬��������ȭ���͵���Ϣ*/
	public static final int MessageTypeFist = 1;
	/** ��̬������Ӯ��ʱ�����Ϣ*/
	public static final int MessageTypeWinst = 2;
	/** ��̬���������ʱ�����Ϣ*/
	public static final int MessageTypeLosest = 3;
   //���ԣ����ơ�������������ȭ����ɫ��Ӧ����Ч����ɫ�ĸ��Ի�̨��
	private String name;
	private int score;
	private int first;
	// ..............
	// ** ��ɫ�ڳ�ȭ��ʱ��˵�ĸ��Ի�̨��
	private String[] firstWords = {
			"���йⲨ~biubiu~~",
			"������ı���Ϊʲô��ô��",
			"��ɱ��¶ƨƨ������",
			"������ϲ�����ཷ��",
			"�ز�����ŷ��ɣ������һȭ"		
	};
	private String[] winWords = {
			"����˭",
			"��ȭ���е���˼",
			"~~~����~~~",
			"ȫ������",
			"���Ż�����Ÿ裬Ȼ���������"
	};
	
	private String[] loseWords = {
			"ͨ���ɹ���·����ʩ����",
			"�ȵ���ˮ��ȥ����֪��˭����Ӿ",
			"������ǲ���,���ʱ���������綼û�ú�",
			"���������ˣ�QQ�ž;��ϣ������",
			"���˽����Ҷ��ѣ����������Ҷ���"
	};
	/**
	 * ���ݴ������Ϣ���ͣ������ӡ��Ӧ���͵���Ϣ
	 * @param msgType ��Ӧhumanplayer���ж���ľ�̬��Ϣ
	 */
   public void sendMessage(int msgType){
	   //����һ��0-4���������
	   int index = ((int)(Math.random() * 1000)) % 5;
	   String message = null; //Ҫ��ӡ����Ϣ
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

	
	
	//���������ú͵õ������ơ���������Ч�����Ի�̨�ʡ���ȭ
	
}
