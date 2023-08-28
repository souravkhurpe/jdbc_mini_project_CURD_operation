package com.controller;

import java.util.Scanner;

import com.service.Services;
import com.model.*;

public class Main {

	static void menu() {
		System.out.println();
		System.out.println("WELCOME TO JDBC MINI PROJECT");

		System.out.println("1) To Add Data");
		System.out.println("2) To Show Data");
		System.out.println("3) to delete data");
		System.out.println("4) to update data");
		System.out.println("5) Search in database using id");
		System.out.println("0) To Exit");
	}

	public static void main(String[] args) {

		Utility u = new Services();
		boolean flag = true;
		while (flag) {
			menu();
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			boolean flag1 = true;
			while (flag1) {
				switch (ch) {
				case 1:
					u.addData();
					flag1 = false;
					break;
				case 2:
					u.getData();
					flag1 = false;
					break;
				case 3:
					u.deleteData();
					flag1 = false;
					break;
				case 4:
					u.modifyData();
					flag1 = false;
					break;
				case 5:
					u.searchInDatabase();
					flag1 = false;
					break;
				case 0:

					flag = false;
					flag1 = false;
					break;
				default:
					System.out.println("### Enter valid choice ###");
				}
			}
		}
	}

}
