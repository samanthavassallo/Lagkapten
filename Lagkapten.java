import java.util.*;
public class Lagkapten {

	public static void main(String[] args) {
		int roundsplayed = 0;
		int computerwins = 0;
		int playerwins = 0;
		boolean wincondition = false;
		boolean win = false;
		boolean Whowins = true;
		gameRules();
		//start(roundsplayed,computerwins,playerwins);
		
//	    Scanner infromkbd = new Scanner(System.in);
//	    String choice = infromkbd.next();
	    
	  boolean start_condition = GameStart();  
		while (start_condition == true) {
			
			
			Whowins = game(roundsplayed, computerwins, playerwins);
			roundsplayed ++;
//			if (wincondition) {playerwins +=1;}o//			else computerwins+=1;)
			if (Whowins == true) {
				playerwins ++;
				//Playagain(roundsplayed,computerwins,playerwins);
				}
			if (Whowins == false) {
				computerwins ++;
				//Playagain(roundsplayed,computerwins,playerwins);
				}
		start_condition = GameStart();
		}
	quit(roundsplayed, computerwins, playerwins);	
		}
		
			

// last main bracket
	
// methods
	
	// Game Rules
	public static void gameRules() {
		System.out.print("Welcome to Lagkapten. Here are the rules. Melltorp beats both Utespelare and Olserod.\n" 
				+ "Utesplare beasts both Knarrevik and Yngvar. Knarrevik beats both Melltorp and Olserod.\n"
				+ "Olserod beats both Yngvar and Utespelare. Lastly Yngvar beats both Melltorp and Kharrevik.\n"
				+ "In the case of a tie the compter will win.\n");
		
	}
	
	//Random Number 1- 5
	public static int randomNumber() {
		Random rand = new Random();
		int randNumber = rand.nextInt(5)+1;
		return randNumber;
	}
	
	
	
	// method 1
	public static boolean game(int roundsplayed, int computerwins, int playerwins) {
		Scanner infromKBD = new Scanner(System.in); 
		
		int Melltorp = 1;
		int Utespelare = 2;
		int Knarrevik = 3;
		int Olserod = 4;
		int Yngvar = 5;
		
		System.out.print("Who do you want to play as. Options are Melltorp, Ultespelare, Knarrevik, Olserod, Yngvar\r\n ");
		String UserChoice = infromKBD.next();
		//String choice = infromkbd.next();
		if (!(UserChoice.equalsIgnoreCase("Melltorp"))&&(!UserChoice.equalsIgnoreCase("Ultespelare"))&&(!UserChoice.equalsIgnoreCase("Knarrevik"))&&(!UserChoice.equalsIgnoreCase("Olserod"))&&(!UserChoice.equalsIgnoreCase("Yngvar"))) {
			System.out.print("Invalid choice \r\n");
			game(roundsplayed, computerwins, playerwins);
		}
		//roundsplayed += 1;
		
		int computer = randomNumber();
		String comp_play = compChoice(computer, Yngvar, Olserod, Knarrevik, Utespelare, Melltorp);
		
		System.out.print("You pick " + UserChoice + " The computer picked " + comp_play);
		boolean win = winner(comp_play,UserChoice);
		if (win == true) {
			System.out.print("You Win!! ");
			//playerwins += 1;
		}
		else {
			System.out.print(" You Lose ");
			//computerwins += 1;
		}
		return win;
		}
	

	
	//method 2
	public static void quit(int roundsplayed, int computerwins, int playerwins) {
		//if (choice.equalIgnoresCase("n"));
		System.out.print("Game over.");
		System.out.print("You played " + roundsplayed +" rounds" +" You won " + playerwins + " times. The computer won " + computerwins + " times.");
	}

	//Ask to play again
//	public static void Playagain( int roundsplayed, int computerwins, int playerwins) {
//			System.out.print(" Would you like to play again?");
//			Scanner infromkbd = new Scanner(System.in);
//			String again = infromkbd.next();
//			if (again.equalsIgnoreCase("y")) {
//				roundsplayed += 1;
//				game(roundsplayed, computerwins, playerwins);
//			}
//			else {
//				quit(roundsplayed,computerwins,playerwins);
//			}
//		}


	

	//method 4
	public static String compChoice(int computer, int Yngvar, int Olserod, int Knarrevik, int Utespelare, int Melltorp) {
		String name = "";
		if (computer == Melltorp) {
			name = "Melltorp";
	}
		if (computer == Utespelare) {
			name = "Utespelare";
	}
		if (computer == Knarrevik) {
			name = "Knarrevik";
	}
		if (computer == Olserod) {
			name = "Olserod";
	}
		if (computer == Yngvar){
			name = "Yngvar";

}
	return name;
		
	}
	
	//method 5
	public static boolean winner(String comp_play,String Userchoice) {
		boolean win = false;{
		if ((Userchoice.equalsIgnoreCase("Melltorp"))&&((comp_play.equalsIgnoreCase("Utespelare")||comp_play.equalsIgnoreCase("Olserod")))) {
			win = true;
		}
		else if ((Userchoice.equalsIgnoreCase("Utespelare"))&&((comp_play.equalsIgnoreCase("Knarrevik")||comp_play.equalsIgnoreCase("Yngvar")))) {
			win = true;
		}
		else if ((Userchoice.equalsIgnoreCase("Knarrevik"))&&((comp_play.equalsIgnoreCase("Melltorp")||comp_play.equalsIgnoreCase("Olserod")))) {
			win = true;
		}
		else if ((Userchoice.equalsIgnoreCase("Olserod"))&&((comp_play.equalsIgnoreCase("Yngvar")||comp_play.equalsIgnoreCase("Utespelare")))) {
			win = true;
		}
		else if ((Userchoice.equalsIgnoreCase("Yngvar"))&&((comp_play.equalsIgnoreCase("Melltorp")||comp_play.equalsIgnoreCase("Knarrevik")))) {
			win = true;
		}
		else if (Userchoice.equalsIgnoreCase(comp_play)) {
			win = false;
		}
		else {
			//computerwins += 1;
			win = false;
		}
		
		
		return win;	
	}
	}
	
	public static boolean GameStart() {
		String userChoice = "";
		boolean startGame = false;
		boolean falseInput = true;
		Scanner userInput = new Scanner(System.in);
	
		//Scanner infromkbd = new Scanner(System.in);
		while (falseInput) {
			System.out.print("Would you like to play. Type 'y' for Yes and 'n' for No.");
			userChoice = userInput.next();
			if (userChoice.equalsIgnoreCase("y")) {
				startGame = true;
				falseInput = false;
			}
			else if (userChoice.equalsIgnoreCase("n")) {
				falseInput = false;	
				}
			else
				System.out.print("Invalid Input ");
			}	
		
		return startGame;
	}
	
		}
		
	








/* outline

rules = Melltorp beats Utespelare, Olserod
Utespelare beats Knarrevik, Yngvar
Knarrevik beats Melltorp, Olserod
Olserod Beats Yngvar, Utespelare
Yngvar beats Melltorp, Knarrevik

porint out the rules and then use a scanner to see if the user wants to play
create a function for the game that prompts the user with who they want to play as. this will also
make sure any invalid inputs are deteced and promts the user again. after the user inputs there choice we have to have the computer pick.
to do that we need to assign the computer choices to a number and then create a funcation that assigns that cimputer random choice to the option.
Then we have to create a funcation that deciceds the winner based off user and computer input. then creat a function to prompt the user if they 
want to play again. If they play again call the function thats runs the game. if they do not want to play again use a compilers to print
out the rounds played, the computers wins and the user wins. 

*/