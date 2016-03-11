
public class Computer extends Player{
	
	public Computer() {
		super("Computer");
	}
	public int makeChoice(int numberremaining, int gametype){
		int choice = generateChoice(numberremaining, gametype);
		
		return choice;
	}
	public int generateChoice(int numberremaining, int gametype){
		if(gametype == 0){
			if((numberremaining%4)!= 0){
				return (numberremaining%4);
			}else{
				return (int) Math.round(Math.random()*2)+1;
			}
				
		}
		else{
			if(((numberremaining+1)%4)!= 0){
				return ((numberremaining+1)%4);
			}else{
				return (int) Math.round(Math.random()*2)+1;
			}
				
		}
			
		
	}
}
