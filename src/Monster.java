
public class Monster {
	
	private int maxhp, chp, atk, def, spd;
	
	public Monster(int maxhp, int atk, int def, int spd) {
		this.maxhp = maxhp;
		chp = maxhp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
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
