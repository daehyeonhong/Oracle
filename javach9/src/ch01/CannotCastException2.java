package ch01;

//ch01.Television cannot be cast to ch01.Audio
public class CannotCastException2 {
	public static void main(String[] args) {
		RemoteController remoteController = new Television();
		Audio audio = (Audio) remoteController;
	}
}