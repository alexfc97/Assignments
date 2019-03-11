package Assignments;

import java.util.Scanner;

class layout {
	
	
	protected String[][] matrix = 
		{
		 {" "," ","0","1","2","3","4","5","6","7"," "," ","<- x axis"},
		 {" ","+","-","-","-","-","-","-","-","-","+"," "," "},
		 {"0","|"," ","1"," ","1"," ","1"," ","1","|","0"," "},
		 {"1","|","1"," ","1"," ","1"," ","1"," ","|","1"," "},
		 {"2","|"," ","1"," ","1"," ","1"," ","1","|","2"," "},
		 {"3","|"," "," "," "," "," "," "," "," ","|","3"," "},
		 {"4","|"," "," "," "," "," "," "," "," ","|","4"," "},
		 {"5","|","2"," ","2"," ","2"," ","2"," ","|","5"," "},
		 {"6","|"," ","2"," ","2"," ","2"," ","2","|","6"," "},
		 {"7","|","2"," ","2"," ","2"," ","2"," ","|","7"," "},
		 {" ","+","-","-","-","-","-","-","-","-","+"," "," "},
		 {" "," ","0","1","2","3","4","5","6","7"," "," "," "}
		};
	
	
	public void Layout() 
	{
		
 		for (int i = 0; i < matrix.length; i++) 
 		{
 		    for (int j = 0; j < matrix[i].length; j++) 
 		    {
 		        System.out.print(matrix[i][j] + " ");
 		    }
 		    System.out.println();
 		}
	}
}

class Movement {
	protected static String[][] matrix;
	
	public boolean validMove(String[][] matrix, int x1, int y1, int x2, int y2, String k)  
	{
		return matrix[y1+2][x1+2] == k && matrix[y2+2][x2+2] == " "  && x1 != x2 && y1 != y2 && Math.abs(x1-x2) == 1 && Math.abs(y1-y2) == 1;
	}
	
	public void Move(String[][] matrix, String ID) 
	{
		layout Lay = new layout();
		while (true) 
		{	
			try 
			{
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner (System.in);
			System.out.println("Coordinate of piece to move");
			System.out.print("	Enter X coordinate: ");
			int x1 = Integer.parseInt(scanner.next());
			System.out.print("	Enter Y coordinate: ");
			int y1 = Integer.parseInt(scanner.next());
			System.out.println();
			System.out.println("Coordinate of new position");
			System.out.print("	Enter X Coordinate: ");
			int x2 = Integer.parseInt(scanner.next());
			System.out.print("	Enter Y Coordinate: ");
			int y2 = Integer.parseInt(scanner.next());
			System.out.println();
			if (ID == "1") 
			{
				if (validMove(matrix , x1,  y1,  x2,  y2, ID)) 
				{
					matrix[y1+2][x1+2] = " ";
					matrix[y2+2][x2+2] = "1";
					break;
				}
				else 
				{
					System.out.printf("Invalid move Player %s, Please try again",ID);
					System.out.println();
					Lay.Layout();
					continue;
				}
			}
			if (ID == "2") 
			{
				if (validMove(matrix, x1,  y1,  x2,  y2, ID)) 
				{
					matrix[y1+2][x1+2] = " ";
					matrix[y2+2][x2+2] = "2";
					break;
				}
				else 
				{
					System.out.printf("Invalid move Player %s, Please try again",ID);
					System.out.println();
					Lay.Layout();
					continue;
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println();
			System.out.println("Not a valid input, please try again!");
			System.out.println();
			Lay.Layout();
			continue;
		}
		}
	}
	
}


class player extends Movement {
	protected String ID;
	
	public player(String x) {
		this.ID = x;
	}
	
	public void turn(String ID) 
	{
		System.out.printf("Player %s's turn", ID);
		System.out.println("");
	}
}

class UnitTest {
	public boolean Test1(String[][] matrix, int x1, int y1, int x2, int y2, String k, boolean valid) {
		System.out.println("Testing Move: ");
		Movement Move = new Movement();
		if (Move.validMove(matrix, x1, y1, x2, y2, k) == valid) {
				System.out.println(" Test Passed! ");
				return true;
		}
		else {
			System.out.println(" Test Failed! ");
			return false;
		}
	}
	
	public boolean Test2(player p1, player p2, String ID, String ID2) {
		System.out.println("Testing Player ID's: ");
		if (p1.ID == ID && p2.ID == ID2) {
			System.out.println(" Test Passed! ");
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean Test3(String[][] matrix, String x, String y) {
		System.out.println("Testing layout of matrix: ");
		if (matrix[3][2] == x && matrix[7][2] == y && matrix[4][4] == " ") {
			System.out.println(" Test Passed! ");
			return true;
		} else {
			System.out.println(" Test Failed! ");
			return false;
		}
	}
	
}

public class Checkers_3 {
	public static void main(String args[]) 
	{
		player p1 = new player("1");
		player p2 = new player("2");
		layout lay = new layout();
		UnitTest test = new UnitTest();
		
		if (test.Test1(lay.matrix,1,2,0,3,"1",true) & test.Test2(p1,p2,"1","2") & test.Test3(lay.matrix, "1", "2")) {
			System.out.println("All unit tests returned true, Program will now run!");
			System.out.println();
			for ( int i = 2; ; i++) 
			{	
				lay.Layout();
				if (i % 2 == 0) 
				{
					p1.turn(p1.ID);
					p1.Move(lay.matrix, p1.ID);
				}
				else 
				{
					p2.turn(p2.ID);
					p2.Move(lay.matrix, p2.ID);
				}
			}
		} else {
			System.out.println("All unit tests did not return true therefore the program did not run!");
		}
 	}
}
