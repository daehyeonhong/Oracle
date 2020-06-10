package Dao;

public class ConnectionTest {

	public static void main(String[] args) {
		Dao dao = Dao.getInstance();
		if (dao.getConnection() != null) {
			System.out.println("연결성공");
		} else {
			System.out.println("연결실패");
		}
	}
}