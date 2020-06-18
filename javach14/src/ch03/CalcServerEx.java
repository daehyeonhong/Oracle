package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.StringTokenizer;

public class CalcServerEx {
	public static String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp, " ");
		String res = "";
		if (st.countTokens() != 3) {
			res = "error";
		}
		int op1 = Integer.parseInt(st.nextToken());
		String opconde = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		switch (opconde) {
		case "+":
			res = Integer.toString(op1 + op2);
			break;
		case "-":
			res = Integer.toString(op1 - op2);
			break;
		case "*":
			res = Integer.toString(op1 * op2);
			break;

		default:
			res = "error";
			break;
		}
		return res;
	}

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9998);
			System.out.println("연결을 기다립니다.");
			socket = listener.accept();

			// 통신
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("bye")) {
					String text = "클라이언트에서 \"{0}\"로 연결을 종료하였습니다.";
					String result = MessageFormat.format(text, inputMessage);
					System.out.println(result);
					break;
				}

				System.out.println(inputMessage);
				String res = calc(inputMessage);// 연산 프로시져 호출
				out.write(res + "\n");// 결과 전송
				out.flush();
			}
		} catch (Exception e) {
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (listener != null) {
					listener.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}