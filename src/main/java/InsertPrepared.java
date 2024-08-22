import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;


public class InsertPrepared {

	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			PreparedStatement statement = connection.prepareStatement("insert into products values(?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter p_id");
			statement.setInt(1,sc.nextInt());
			
			System.out.println("enter p_name");
			statement.setString(2,sc.next());
			
			System.out.println("enter p_cost");
			statement.setInt(3,sc.nextInt());
			
			System.out.println("enter p_image");
			statement.setString(4,sc.next());
			
			statement.executeUpdate();
			System.out.println("record inserted");
			connection.close();
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
}
}
