
public class Goblin extends Monster {
	
	public Goblin() {
		super(5, 3, 3, 3);
	}
	
	public boolean attack(Player player) {
		System.out.println("The Goblin Attacks");
		
		int damage = getAtk() - player.defend();
		System.out.printf("It deals %d damage%n", damage);
		player.setChp(player.getChp() - damage);
		System.out.printf("You have %d health left.%n", player.getChp());

		return true;
	}
	
	public boolean specattack1(Player player) {
		System.out.println("The Goblin taunts you and calls your mother a whore.");
		return true;
	}
	
	
}
