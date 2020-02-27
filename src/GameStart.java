import java.util.Scanner;

public class GameStart {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player("Protag", 10, 5, 5, 5);
		System.out.printf("Player %s, Level %d%n", player.getName(), player.getLevel());
		Goblin gobbo = new Goblin();
		System.out.printf("%s, HP %s%n",gobbo, gobbo.getMaxhp());
		gobbo.attack();
		System.out.println(gobbo.specattack2());
		gobbo.specattack1();
		
		
		
		
	}

}
