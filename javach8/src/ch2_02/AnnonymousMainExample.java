package ch2_02;

public class AnnonymousMainExample {
	// 필드 초기값으로 대입-무명의 자식 객체를 생성하여 부모 타입에 대입한 형태
	Person field = new Person() {
		void work() {
			System.out.println("출근합니다.");
		}

		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
		}
	};

	void method1() {
		Person localVar = new Person() {
			void walk() {
				System.out.println("산책합니다.");
			}

			@Override // 재정의된 메소드
			void wake() {
				System.out.println("7시에 일어납니다.");
			}
		};
		localVar.wake();
		// localVar.walk();--접근불가
		field.wake();
		// field.walk();접근 불가
	}

	void method2(Person person) {
		person.wake();
	}
}