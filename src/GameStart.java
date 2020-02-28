import java.util.Scanner;
import java.util.Random;

public class GameStart {
	
	public static Scanner input = new Scanner(System.in);
	public static Random rand = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player("Chipotle", 10, 5, 5, 5);
		System.out.printf("Player %s, Level %d%n", player.getName(), player.getLevel());
		Goblin gobbo = new Goblin();
		System.out.printf("%s, HP %s%n",gobbo, gobbo.getMaxhp());
		Battle.enemybattle(player, gobbo);
		
		
		
		
	}
	
	public static boolean isInteger(String input) {
		if (input == null) {
			return false;
		}
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static void NotInYet() {
		System.out.println("Not implemented yet");
	}
}
