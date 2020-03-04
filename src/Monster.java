
public class Monster implements Cloneable{
	
	private int maxhp, chp, atk, def, spd, exp; //Monster stats
	
	/**
	 * Generic Monster constructor
	 * @param maxhp - Monster's maximum health
	 * @param atk - Monster's attack
	 * @param def - Monster's defense
	 * @param spd - Monster's speed
	 * @param exp - Monster's exp granted on death
	 */
	public Monster(int maxhp, int atk, int def, int spd, int exp) {
		this.maxhp = maxhp;
		chp = maxhp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
		this.exp = exp;
	}
	
	public static Monster cloneMonster(Monster monster) throws CloneNotSupportedException {
		Monster newmonster = (Monster)monster.clone();
		
		return newmonster;
	}
	
	//Generic Battle Entrance
	public String entrance() {
		return "You've encountered a "+getClass().getName();
	}
	
	//Generic Attack and Special Attacks, Should get Overridden by Specific Monster Classes
	public int attack(Player player) {
		return -1;
	}
	
	public int specattack1(Player player) {
		return -1;
	}
	
	public int specattack2(Player player) {
		return -1;
	}
	
	//Generic Defend
	public int defend() {
		return def;
	}
	
	//Getters & Setters
	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public int getChp() {
		return chp;
	}

	public void setChp(int chp) {
		this.chp = chp;
	}
	
	
	//Get Name
	public String toString() {
		return getClass().getName();
	}
	
	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}
	
	public int getExp() {
		return exp;
	}
	
	
}

//Goblin Monster
class Goblin extends Monster {
	
	/**
	 * Goblin creature
	 */
	public Goblin() {
		super(5, 3, 3, 3, 1);
	}
	
	public String entrance() {
		return "A goblin appears, brandishing an oversized stick like a club.";
	}
	public int attack(Player player) {
		System.out.println("The Goblin pokes you with its stick.");

		int damage = getAtk() - player.defend();
		
		if (damage < 0) damage = 0;
		
		System.out.printf("It deals %d damage%n", damage);
		player.setChp(player.getChp() - damage);
		System.out.printf("You have %d health left.%n", player.getChp());

		return damage;
	}
	
	public int specattack1(Player player) {
		System.out.println("The Goblin taunts you and calls your mother a whore.");
		return 0;
	}
	
	
}
