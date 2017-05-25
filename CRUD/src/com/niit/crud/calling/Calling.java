package com.niit.crud.calling;

import java.util.Scanner;
import com.niit.crud.daoimpl.OperationDaoImpl;

public class Calling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the function 1:Create 2:Read 3:Update 4: Delete  5:exit");
		int ch = sc.nextInt();

		if (ch == 1) {
			OperationDaoImpl.productcreate();

			main(args);

		} else if (ch == 2) {
			OperationDaoImpl.productread();
			main(args);
		} else if (ch == 3) {
			OperationDaoImpl.productupdate();
			main(args);
		} else if (ch == 4)

		{
			OperationDaoImpl.productdelete();
			main(args);
		} else if (ch == 5)

		{

			System.exit(0);
		}

	}
}
