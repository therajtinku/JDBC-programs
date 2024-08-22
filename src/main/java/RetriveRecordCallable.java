import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.ResultSet;

public class RetriveRecordCallable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			CallableStatement call = connection.prepareCall("{CALL retriveproduct(?)}");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter p_id");
			call.setInt(1, sc.nextInt());
			
			ResultSet executeQuery = call.executeQuery();
			while(executeQuery.next()) {
				System.out.println(executeQuery.getInt("p_id")+ "..."+executeQuery.getString("p_name")+ "..."+executeQuery.getInt("p_cost")+"..."+executeQuery.getString("p_image"));
			}
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
