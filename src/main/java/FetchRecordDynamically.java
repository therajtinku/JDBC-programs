import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchRecordDynamically {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/raju","root","2255");
			PreparedStatement statement = connection.prepareStatement("select *from products where p_id=?");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter p_id");
			statement.setInt(1, sc.nextInt());
			ResultSet executeQuery = statement.executeQuery();
			while (executeQuery.next()) {
				System.out.println(executeQuery.getInt("p_id")+ "..."+executeQuery.getString("p_name")+ "..."+executeQuery.getInt("p_cost")+"..."+executeQuery.getString("p_image"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
