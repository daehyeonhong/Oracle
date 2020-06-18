package ch08;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQue = new LinkedList<Message>();

		// Queue에 Object저장 offer(Object);
		messageQue.offer(new Message("sendMail", "홍길동"));
		messageQue.offer(new Message("sendSMS", "일지매"));
		messageQue.offer(new Message("sendKakaoTalk", "임꺽정"));

		// Object 꺼낼 때 poll();
		while (!messageQue.isEmpty()) {
			Message message = messageQue.poll();// 제일 앞의 객체 얻기
			switch (message.command) {
			case "sendMail":
				System.out.println(message.to + "님에게 메일\t[전송]");
				break;
			case "sendSMS":
				System.out.println(message.to + "님에게 SMS\t[전송]");
				break;
			case "sendKakaoTalk":
				System.out.println(message.to + "님에게 카카오톡\t[전송]");
				break;
			}
		}
	}
}

class Message {
	public String command;
	public String to;

	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
}