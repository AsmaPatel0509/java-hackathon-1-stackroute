package com.ibm.JavaHackathon1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.ibm.model.OpeningAccount;

public class App {
	public static void main(String[] args) {
		int id;
		String name;
		String address;
		String dobString;
		Date dob;
		int age;
		String email;

		System.out.println("Select an operation to be performed: ");
		System.out.println("1 - View  \n 2 - Insert  \n 3-View by Id  \n 4 - Delete  \n  5 - Edit details ");

		OpeningAccount openingAccount = new OpeningAccount();

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "Root@123");
			Statement statement = con.createStatement();

			switch (choice) {
			case 1:
				System.out.println("View: ");
				ResultSet resultSet1 = statement.executeQuery("select * from Account");
				while (resultSet1.next()) {
					System.out.println(
							"Account id:" + resultSet1.getInt(1) + ", Account name: " + resultSet1.getString("name")
									+ ", Address: " + resultSet1.getString(3) + ", Age: " + resultSet1.getString(4)
									+ ", DOB: " + resultSet1.getString(5) + ", Email: " + resultSet1.getString(6));
				}
				break;

			case 2:
				System.out.println("Insert: ");
				Statement st = con.createStatement();

				System.out.println("Enter id: ");
				id = scanner.nextInt();
				openingAccount.setId(id);

				System.out.println("Enter Name: ");
				name = scanner.next();
				openingAccount.setName(name);

				System.out.println("Enter date of birth: ");
				dobString = scanner.next();
				openingAccount.setDobString(dobString);

				System.out.println("Enter address: ");
				scanner.nextLine();
				address = scanner.nextLine();
				openingAccount.setAddress(address);

				System.out.println("Enter age: ");
				age = scanner.nextInt();
				openingAccount.setAge(age);

				System.out.println("Enter email id: ");
				email = scanner.next();
				openingAccount.setEmail(email);

				scanner.close();

				Date date = Date.valueOf(openingAccount.getDobString());

				st.execute("insert into Account values(" + openingAccount.getId() + ",'" + openingAccount.getName()
						+ "','" + openingAccount.getAddress() + "', '" + openingAccount.getDobString() + "', '"
						+ openingAccount.getAge() + "','" + openingAccount.getEmail() + "')");
				break;

			case 3:
				System.out.println("View By Id: ");
				System.out.println("Enter id: ");
				Scanner scanner2 = new Scanner(System.in);
				int viewId = scanner2.nextInt();

				Statement st3 = con.createStatement();
				System.out.println("View: ");
				ResultSet rs3 = st3.executeQuery("select * from Account where id = " + viewId);
				while (rs3.next()) {
					System.out.println(
							"Account id:" + rs3.getInt(1) + ", Account name: " + rs3.getString("name")
									+ ", Address: " + rs3.getString(3) + ", Age: " + rs3.getString(4)
									+ ", DOB: " + rs3.getString(5) + ", Email: " + rs3.getString(6));
				}

				break;
			case 4:
				System.out.println("Delete: ");
				Statement st4 = con.createStatement();

				System.out.println("Account details: ");
				ResultSet rs = st4.executeQuery("select * from Account");
				while (rs.next()) {
					System.out.println(
							"Account id:" + rs.getInt(1) + ", Account name: " + rs.getString("name")
									+ ", Address: " + rs.getString(3) + ", DOB: " + rs.getString(4)
									+ ", Age: " + rs.getString(5) + ", Email: " + rs.getString(6));
				}
				System.out.println("Enter id of account to be deleted: ");
				Scanner scanner1 = new Scanner(System.in);
				int deleteId = scanner1.nextInt();

				st4.execute("Delete from Account where id =" + deleteId);
				
				System.out.println("Deleted from database. ");

				break;
			case 5:
				System.out.println("Edit: ");
				Statement st5 = con.createStatement();
				System.out.println("View: ");
				ResultSet rs1 = st5.executeQuery("select * from Account");
				while (rs1.next()) {
					System.out.println(
							"Account id:" + rs1.getInt(1) + ", Account name: " + rs1.getString("name")
									+ ", Address: " + rs1.getString(3) + ", DOB: " + rs1.getString(4)
									+ ", Age: " + rs1.getString(5) + ", Email: " + rs1.getString(6));
				}

				System.out.println("Enter id of account to be modified: ");
				Scanner scanner3 = new Scanner(System.in);

				int editId = scanner3.nextInt();

				System.out.println("Enter new address: ");
				scanner3.nextLine();
				String newAddress = scanner3.nextLine();

				System.out.println("Enter new Email Id: ");
				String newEmail = scanner3.next();

				st5.execute(
						"Update Account set address = '" + newAddress + "', email ='" + newEmail + "' where id= " + editId);
				System.out.println("Database updated!");

				break;
			default:
				System.out.println("Invalid Input; try again! ");
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
