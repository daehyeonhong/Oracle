package ch19;

public class StringBuilderMainExample {
	public static void main(String[] args) {
		// StringBuilder객체 생성
		StringBuilder sb = new StringBuilder();
		// 이어 붙이기 append
		sb.append("Java ");
		sb.append("Programming");
		System.out.println(sb);
		System.out.println(sb.toString());

		// 중간 삽입 insert(index, value);
		sb.insert(4, "2");
		System.out.println(sb);

		// 수정 setCharAt(index, value[수정할 문자[char]'']);
		sb.setCharAt(4, '8');
		System.out.println(sb);

		// 부분 수정 replace(시작index,끝index)
		sb.replace(6, 13, "Book");// 6<=범위<13
		System.out.println(sb);

		// 부분 삭제 delete(시작 index,끝index);
		sb.delete(4, 5);// 범위 4<=범위<5;
		System.out.println(sb);

		System.out.println("문자수: " + sb.length());

		// 내용을 String type으로 변환
		String result = sb.toString();
		System.out.println(result);
	}
}