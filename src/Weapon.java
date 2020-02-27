
public class Weapon {
	private String name, attackdesc;
	private int atk;
	
	public Weapon(String name, String attackdesc, int atk) {
		this.name = name;
		this.attackdesc = attackdesc;
		this.atk = atk;
	}

	public static Weapon createFists() {
		return new Weapon("Fists", "You swing your arms", 1);
	}
	
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttackdesc() {
		return attackdesc;
	}

	public void setAttackdesc(String attackdesc) {
		this.attackdesc = attackdesc;
	}
	
	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	
}
