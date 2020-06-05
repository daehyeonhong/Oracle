package dao;

public class ConnectionTest {

	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		if (dao.getConnection() != null) {
			System.out.println("연결성공");
		} else {
			System.out.println("연결실패");
		}
	}
}