import java.sql.*;
import java.util.*;
import java.io.*;


public class InsertImage {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excelrdb","root","2255");
			Scanner sc = new Scanner(System.in);
			PreparedStatement statement = connection.prepareStatement("insert into company values(?,?)");
			
			System.out.println("enter c_id");
			int cid = sc.nextInt();
			statement.setInt(1, cid);
			
			//read image path as string
			//convert string to file
			//convert file to FileInputStream
			//find length
			
			String path = sc.next();
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			int length = (int) file.length();
			statement.setBinaryStream(2, fileInputStream,length);
			
			statement.executeUpdate();
			System.out.println("record inserted successfully!!");
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
