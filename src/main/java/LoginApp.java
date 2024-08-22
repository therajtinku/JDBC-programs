import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginApp {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			PreparedStatement statement = connection.prepareStatement("select *from login where uname=? and upwd=?");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter username");
			statement.setString(1, sc.next());
			
			System.out.println("Enter password");
			statement.setString(2, sc.next());
			
			ResultSet executeQuery = statement.executeQuery();
			if(executeQuery.next()) {
				System.out.println("Login Success");
			}else {
				System.out.println("Login Fail");
			}
			
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
