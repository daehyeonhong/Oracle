package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.Dao;

public class RegisterMainExam {
	public static void main(String[] args) throws SQLException {
		Dao dao = Dao.getInstance();
		Connection con = dao.getConnection();
		Statement stmt=con.createStatement();

	}
}