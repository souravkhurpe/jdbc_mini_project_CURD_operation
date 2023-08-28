package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.model.Utility;

public class Services implements Utility {
	public Scanner sc = new Scanner(System.in);

	@Override
	public void addData() {
		PreparedStatement ps = null;
		try {
			Connection connection = SingleTonDesignPattern.getConnection();
			System.out.println("How many data u want to enter");
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				System.out.println("Enter Teacher ID: ");

				int id = sc.nextInt();
				System.out.println("Enter teacher name: ");
				String name = sc.next();
				System.out.println("Enter teacher address: ");
				String address = sc.next();

				String query = "insert into teacher values (?,?,?)";
				ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, address);

				ps.execute();
				System.out.println("Data Added successfully");
//				int affected = ps.executeUpdate();
//				System.out.println("Data inserted to database successfully " + affected + " rows affected");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getData() {
		Connection connection = SingleTonDesignPattern.getConnection();

		String sql = "select * from teacher";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int a = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				System.out.println("ID= " + a + ", " + "NAME= " + name + ", " + "ADDRESS= " + address);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteData() {

		Connection connection = SingleTonDesignPattern.getConnection();
		try {
			System.out.println("Enter teacher id u want to delete: ");
			int id = sc.nextInt();
			String sql = "delete from teacher where id = " + id + "";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.execute();

			System.out.println("Record Deleted successfully");

		} catch (Exception e) {

		}
	}

	public void updateName() {
		Connection connection = SingleTonDesignPattern.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id which details u want to update: ");
		int id = sc.nextInt();
		System.out.println("enter ur new name: ");
//		update teacher set name = 'abc' where id = 1;
		String name = sc.next();
		String query = "update teacher set name = '" + name + "' where id = " + id + "";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			int i = ps.executeUpdate();

			System.out.println("Name updated successfully, " + i + " row affected");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAddress() {
		Connection connection = SingleTonDesignPattern.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id which details u want to update: ");
		int id = sc.nextInt();
		System.out.println("enter ur new Address: ");
//		update teacher set name = 'abc' where id = 1;
		String address = sc.next();
		String query = "update teacher set address = '" + address + "' where id = " + id + "";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			int i = ps.executeUpdate();

			System.out.println("Address updated successfully, " + i + " row affected");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyData() {
		boolean flag = true;
		while (flag) {
			System.out.println("What u want to update: ");
			System.out.println("1) name");
			System.out.println("2) address");
			System.out.println("0) Main Menu");
			boolean flag2 = true;
			while (flag2) {
				int ch = sc.nextInt();

				switch (ch) {

				case 1:

					updateName();
					flag2 = false;
					break;
				case 2:
					updateAddress();
					flag2 = false;
					break;
				case 0:
					flag2 = false;
					flag = false;
					break;
				default:
					System.out.println("### Enter valid choice ###");

				}
			}
		}

	}

	@Override
	public void searchInDatabase() {
		Connection c =  SingleTonDesignPattern.getConnection();
		System.out.println("Enter id of teacher u want to search");
		int id = sc.nextInt();
		String query = "select * from teacher where id = "+ id+"";
		try {
		PreparedStatement ps =  c.prepareStatement(query);
		
		ResultSet rs =  ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID= "+rs.getInt("id")+", "+"NAME= "+rs.getString("name")+", "+"ADDRESS= "+rs.getString("address"));
		}
		
		
		
		}catch (Exception e) {
			
		}
		
	}

}
