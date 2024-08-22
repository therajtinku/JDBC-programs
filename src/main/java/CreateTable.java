
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
	
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create Connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			
			//create Statement Object
			Statement statement = connection.createStatement();
			
			//create table
			int i = statement.executeUpdate("create table products(p_id int,p_name varchar(20),p_cost int,p_image varchar(200))");
			
			if(i>0) {
				System.out.println("table not created successfully !!!");
			}else {
				System.out.println("table created successfully ");
			}
			
			//close the connection
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
