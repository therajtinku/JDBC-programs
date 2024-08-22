import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.CallableStatement;

public class insertDataByCallable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			CallableStatement call = connection.prepareCall("{CALL insertproduct1(?,?,?,?)}");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter p_id");
			call.setInt(1, sc.nextInt());
			
			System.out.println("Enter p_name");
			call.setString(2, sc.next());
			
			System.out.println("Enter p_cost");
			call.setInt(3, sc.nextInt());
			
			System.out.println("Enter p_image");
			call.setString(4, sc.next());
			
			call.execute();
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
