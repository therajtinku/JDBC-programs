
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			
			//create Statement Object
			Statement statement = connection.createStatement();
			
			statement.executeUpdate("delete from products where p_id=555");
			System.out.println("record deleted successfully !!!");
			
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
