import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecordDynamically {

	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			PreparedStatement statement = connection.prepareStatement("update products set p_cost=? where p_id=?");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter new p_cost");
			statement.setInt(1,sc.nextInt());
			
			System.out.println("enter p_id");
			statement.setInt(2,sc.nextInt());
			
			statement.executeUpdate();
			System.out.println("record updated successfully!!!");
			connection.close();
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
