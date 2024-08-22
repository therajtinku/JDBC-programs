
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateRecord {

	public static void main(String[] args) {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			
			//create Statement Object
			Statement statement = connection.createStatement();
			
			//execute query
			statement.executeUpdate("update products set p_cost=500 where p_id=555");
			
			System.out.println("record updated successfully !!!");
			
			//close the connection
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
