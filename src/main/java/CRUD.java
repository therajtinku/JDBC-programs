
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUD {

	public static void main(String[] args) {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get the connection object
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			//create Statement object
			Statement statement = connection.createStatement();
			//create table
			statement.executeUpdate("create table employee(e_id int,e_name varchar(20),e_sal int)");
			System.out.println("employee table created successfully !!!");
			
			//insert the data
			statement.executeUpdate("insert into employee values(111,'e_one',10000)");
			statement.executeUpdate("insert into employee values(222,'e_two',20000)");
			statement.executeUpdate("insert into employee values(333,'e_three',30000)");
			statement.executeUpdate("insert into employee values(444,'e_four',40000)");
			statement.executeUpdate("insert into employee values(555,'e_five',50000)");
			System.out.println("five records are inserted");
			
			
			//update the last record
			statement.executeUpdate("update employee set e_sal=25000 where e_id=555");
			System.out.println("record updated successfully !!!");
			
			
			//delete last record
			statement.executeUpdate("delete from employee where e_id=555");
			System.out.println("record deleted successafully !!!");
			
			//read records
			ResultSet executeQuery = statement.executeQuery("select * from employee");
			while (executeQuery.next()) {
				System.out.println(executeQuery.getInt("e_id")+"....."+executeQuery.getString("e_name")+"....."+executeQuery.getInt("e_sal"));
			}
			
			//close the connection
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
