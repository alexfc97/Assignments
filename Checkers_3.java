package Assignments;

import java.util.Scanner;

class layout {
	
	
	protected static String[][] matrix = 
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
	
	
	
	public boolean validMove(int x1, int y1, int x2, int y2, String k)  
	{
		return matrix[y1+2][x1+2] == k && matrix[y2+2][x2+2] == " "  && x1 != x2 && y1 != y2 && Math.abs(x1-x2) == 1 && Math.abs(y1-y2) == 1;
	}
	
	
	
	public void Move(String ID) 
	{
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
				if (validMove( x1,  y1,  x2,  y2, ID)) 
				{
					matrix[y1+2][x1+2] = " ";
					matrix[y2+2][x2+2] = "1";
					break;
				}
				else 
				{
					System.out.printf("Invalid Move Player %s, Please try again",ID);
					System.out.println();
					Layout();
					continue;
				}
			}
			if (ID == "2") 
			{
				if (validMove( x1,  y1,  x2,  y2, ID)) 
				{
					matrix[y1+2][x1+2] = " ";
					matrix[y2+2][x2+2] = "2";
					break;
				}
				else 
				{
					System.out.printf("Invalid Move Player %s, Please try again",ID);
					System.out.println();
					Layout();
					continue;
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println("Not a valid input, please try again!");
			Layout();
			continue;
		}
		}
	}
	
	public void turn(String ID) 
	{
		System.out.printf("Player %s's turn", ID);
		System.out.println("");
	}
}


class Player_1 extends layout {
	String ID;
	
	public Player_1(String x) {
		this.ID = x;
	}
	
}

class Player_2 extends layout {
	String ID;
	
	public Player_2(String x) {
		this.ID = x;
	}
}


public class Checkers_3 {
	public static void main(String args[]) 
	{
		
		Player_1 p1 = new Player_1("1");
		Player_2 p2 = new Player_2("2");
		layout lay = new layout();
		
		for ( int i = 2; ; i++ ) 
		{	
			lay.Layout();
			if (i % 2 == 0) 
			{
				lay.turn(p1.ID);
				p1.Move(p1.ID);
			}
			else 
			{
				lay.turn(p2.ID);
				p2.Move(p2.ID);
			}
		}
 	}
}
