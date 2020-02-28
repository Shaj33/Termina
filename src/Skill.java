
public class Skill {
	private String name, desc;
	private int tcost;
	
	public Skill(String name, String desc, int tcost) {
		this.name = name;
		this.desc = desc;
		this.tcost = tcost;
	}
	
	public boolean skilluse(Player player, Monster enemy) {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTcost() {
		return tcost;
	}

	public void setTcost(int tcost) {
		this.tcost = tcost;
	}
	
}

class BigStrike extends Skill{ 
	
	public BigStrike() {
		super("Surging Strike", "A Heavy-Hitting Strike", 3);
	}
	
	public boolean skilluse(Player player, Monster enemy) {
		System.out.println("You let loose a quick, heavy-hitting strike!");
		int damage = 2*player.getAtk() + 2*player.getEqWeapon().getAtk() - enemy.defend();
		
		//Updates and displays info. 
		System.out.printf("You hit for %d damage.%n", damage);
		enemy.setChp(enemy.getChp() - damage);
		System.out.printf("The %s has %d health left.%n", enemy, enemy.getChp());
		
		return true;
		
	}
}
