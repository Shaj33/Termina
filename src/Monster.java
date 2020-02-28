
public class Monster {
	
	private int maxhp, chp, atk, def, spd;
	
	public Monster(int maxhp, int atk, int def, int spd) {
		this.maxhp = maxhp;
		chp = maxhp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
	}
	
	public String entrance() {
		return "You've encountered a "+getClass().getName();
	}
	public boolean attack(Player player) {
		return false;
	}
	
	public boolean specattack1(Player player) {
		return false;
	}
	
	public boolean specattack2(Player player) {
		return false;
	}
	
	public int defend() {
		return def;
	}
	
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
	
	
}

//Goblin Monster
class Goblin extends Monster {
	
	public Goblin() {
		super(5, 3, 3, 3);
	}
	
	public String entrance() {
		return "A goblin appears, brashing an oversized stick like a club.";
	}
	public boolean attack(Player player) {
		System.out.println("The Goblin clubs you with its stick.");
		
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
