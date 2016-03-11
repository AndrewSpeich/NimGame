import java.util.Scanner;

public class Player {
	String name;
	Scanner input = new Scanner(System.in);
	public Player(String namein){
		name = namein;
	}
	public int makeChoice(int numberremaining, int gametype){
		System.out.println(numberremaining+" left. How many will you take? 1,2, or 3");
		
		int choice = 0;
		
		choice = input.nextInt();
		
				
				if(!((choice<=3) && (choice >0))){
			System.out.println("You must type a number between 1 and 3");
			makeChoice(numberremaining, gametype);
		}
		
		return choice;
	}
	
}
