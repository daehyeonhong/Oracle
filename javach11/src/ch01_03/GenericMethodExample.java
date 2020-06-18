package ch01_03;

//1,2,3,4,5<-기존 스택
//5,4,3,2,1<-새스택
public class GenericMethodExample {
	// <T> 리턴타입 method명(argument_type variable){}
	public static <T> GStack<T> reverse(GStack<T> a) {
		GStack<T> s = new GStack<T>();
		while (true) {
			T tmp;
			tmp = a.pop();// 원래 스택에서 요소 하나 꺼내
			if (tmp == null) {
				break;// 스택이 비었으면 중지
			} else {
				s.push(tmp);// 새로운 스택에 요소 삽입
			}
		}
		return s;// 완료 후에 새 스택 리턴
	}
}