
public class Goblin extends Monster {
	
	public Goblin() {
		super(5, 3, 3, 3);
	}
	
	public boolean attack() {
		System.out.println("The Goblin Attacks");
		return true;
	}
	
	public boolean specattack1() {
		System.out.println("The Goblin taunts you and calls your mother a whore.");
		return true;
	}
	
	
}
