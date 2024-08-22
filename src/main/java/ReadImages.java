import java.sql.*;
import java.util.*;
import java.io.*;

public class ReadImages {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excelrdb","root","2255");
			PreparedStatement statement = connection.prepareStatement("select cimage from company");
			ResultSet executeQuery = statement.executeQuery();
			executeQuery.next();
			InputStream binaryStream = executeQuery.getBinaryStream(1);
			executeQuery.close();
			
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\rajut\\OneDrive\\Desktop\\ggd.png");
			int k;
			while((k = binaryStream.read())!=-1) {
				fileOutputStream.write(k);
			}
			fileOutputStream.close();
			connection.close();
			System.out.println("Image retrievd successfully");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
