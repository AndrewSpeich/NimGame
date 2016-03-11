import java.util.Scanner;

public class GameLogic {
	Player[] table = new Player[2];
	Scanner input = new Scanner(System.in);
	int pile;
	int gametype = 0;
	
	public GameLogic(){
		generatePile();
		getGameType();
		populateList();
		runGame();
		restart();
		
	}
	public String getPlayersName(){
		System.out.println("Welcome! What is your name?");
		return input.next();
	}
	public int getNumberOfPlayers(){
		System.out.println("How Many Players? 1 or 2");
		return input.nextInt();
	}
	public int goesFirst(){
		System.out.println("Would "+table[0].name+" like to go first?");
		if("yes" .equalsIgnoreCase(input.next())){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public void generatePile(){
		System.out.println("Welcome! Which would you like to play?");
		pile = (int) Math.round(Math.random()*20)+10;
	}
	
	public void getGameType(){
		System.out.println("Classic Nim, or Misere Nim?");
		switch (input.next().toLowerCase()){
			case "classic":
				gametype = 0;
				break;
			case "misere":
				gametype = 1;
				break;
			default:
				System.out.println("Check your spelling, and try again");
				getGameType();
				break;
		}
	}
	
	public void populateList(){
		int numberofplayers = getNumberOfPlayers();
		for(int i = 0; i < numberofplayers; i++ ){
			table[i] = new Player(getPlayersName());
		}
		if(table[1] == null){
			table[1] = new Computer();
		}
		System.out.println(table[0].name+ " " + table[1].name);
	
	}
	
	public boolean  checkWin(int index){

		boolean win = true;
		if (pile <= 0){
			if (gametype == 0){
				System.out.println(table[index].name + " Wins!");
				win = false;
				
			}else{
				System.out.println(table[(index+1)%2].name+ " Wins!");
				win = false;
			}
		}
		return win;
	}

	public void runGame(){
		boolean condition = true;
		int index = goesFirst();
		while(condition){
			for(int i = index; i<table.length;i++){
				if (condition) {
					int choice = table[i].makeChoice(pile, gametype);
					System.out.println(choice+ " Taken from the pile.");
					pile -= choice;
					condition = checkWin(i);
					
				}
			}
			index = 0;
		}
	}

	public void restart(){
		System.out.println("Would you like to play again?");
		String decide = input.next();
		if("yes" .equalsIgnoreCase(decide)){
			new GameLogic();
		}
	
		
	}
	
	
}
