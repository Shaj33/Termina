import java.util.Scanner;

public class GameStart {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player("Protag", 5, 5, 5);
		player.move();
		player.move();
		player.move();
		player.move();
		
	}

}
