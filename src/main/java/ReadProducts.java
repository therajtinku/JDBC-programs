
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadProducts {

	public static void main(String[] args) {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			
			//create Statement Object
			Statement statement = connection.createStatement();
			
			
			ResultSet executeQuery = statement.executeQuery("select * from products");
			while (executeQuery.next()) {
				System.out.println(executeQuery.getInt("p_id")+"...."+executeQuery.getString("p_name")+"...."+executeQuery.getInt("p_cost")+"...."+executeQuery.getString("p_image"));
			}
			
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
