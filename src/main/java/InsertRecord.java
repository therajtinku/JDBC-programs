
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			
			//create Statement Object
			Statement statement = connection.createStatement();
			
			//insert the record
			statement.executeUpdate("insert into products values(111,'Laptop1',10000,'https://sathyamern.s3.ap-south-1.amazonaws.com/laptop1.jpg')");
			statement.executeUpdate("insert into products values(222,'Laptop2',20000,'https://sathyamern.s3.ap-south-1.amazonaws.com/laptop2.jpg')");
			statement.executeUpdate("insert into products values(333,'Laptop3',30000,'https://sathyamern.s3.ap-south-1.amazonaws.com/laptop3.jpg')");
			statement.executeUpdate("insert into products values(444,'Laptop4',40000,'https://sathyamern.s3.ap-south-1.amazonaws.com/laptop4.jpg')");
			statement.executeUpdate("insert into products values(555,'Laptop5',50000,'https://sathyamern.s3.ap-south-1.amazonaws.com/laptop5.jpg')");
		
			System.out.println("records inserted successfully !!!");
			
			//close the connection
			connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
