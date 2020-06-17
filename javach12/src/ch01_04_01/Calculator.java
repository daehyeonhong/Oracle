package ch01_04_01;

public class Calculator {
	int memory;// 공유 영역

	public int getMemory() {
		return memory;
	}

	// 동기화 처리
	public /* synchronized */ void setMemory(int memory) {
		synchronized (this) {// 영역 동기화
			this.memory = memory;
			try {
				Thread.sleep(2000);// 2초간 멈춤
			} catch (Exception e) {
			}
			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		}
	}
}