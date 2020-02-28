
public class Player {
	private String name;
	private int maxhp, chp, atk, def, spd, level, exp;
	private MapNode cmap;
	private Weapon eqWeapon;
	private Armor eqArmor;
	
	public Player(String name, int maxhp, int atk, int def, int spd) {
		this.name = name;
		this.maxhp = maxhp;
		chp = maxhp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
		cmap = MapNode.CreateMap();
		level = 1;
		setExp(0);
		eqWeapon = new Weapon("Fists", "You swing your fists.", 1);
		eqArmor = new Armor("Peasant Clothes", 1);
	}

	//Move command allows Player to move around the map
	public void move() {
		
		//Prompt and Input
		int move = 0;
		String movein;
		
		System.out.printf("Where do you want to go?%n1. North (%s)%n2. South (%s)%n3. East (%s)%n4. West(%s)%n", cmap.getNorth(), cmap.getSouth(), cmap.getEast(), cmap.getWest());
		movein = GameStart.input.next();
	
		if (GameStart.isInteger(movein)) {
			move = Integer.parseInt(movein);
		} else {
			move = 0;
		}
		/*
		 * If the movement is possible, will move in that direction.
		 * Otherwise, print error message.
		 */
		if (move == 1 && cmap.getNorth()!= null) {
			cmap = cmap.getNorth();
		} else if (move == 1) {
			System.out.println("You cannot move there.");
		}
		
		if (move == 2 && cmap.getSouth()!= null) {
			cmap = cmap.getSouth();
		} else if (move == 2) {
			System.out.println("You cannot move there.");
		}
		
		if (move == 3 && cmap.getEast()!= null) {
			cmap = cmap.getEast();
		} else if (move == 3) {
			System.out.println("You cannot move there.");
		}
		
		if (move == 4 && cmap.getWest()!= null) {
			cmap = cmap.getWest();
		} else if (move == 4) {
			System.out.println("You cannot move there.");
		} 
		
		if (move > 4 || move < 1) {
			System.out.println("No movement is selected.");
		}
		
		//Displays current map info.
		System.out.printf("%n%s%n%s%n", cmap, cmap.getDesc());
	}
	
	//Combat move, basic attack against enemy
	public boolean attack(Monster enemy) {
		
		//Calculates damage based on weapon and personal attack and enemy defense. 
		int damage =  eqWeapon.attack() + atk - enemy.defend();
		
		//Updates and displays info. 
		System.out.printf("You hit for %d damage.%n", damage);
		enemy.setChp(enemy.getChp() - damage);
		System.out.printf("The %s has %d health left.%n", enemy, enemy.getChp());
		
		return true;
	}
	
	public int defend() {
		return def + eqArmor.defend();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public MapNode getCmap() {
		return cmap;
	}

	public void setCmap(MapNode cmap) {
		this.cmap = cmap;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Weapon getEqWeapon() {
		return eqWeapon;
	}

	public void setEqWeapon(Weapon eqWeapon) {
		this.eqWeapon = eqWeapon;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	
	
	
	
}
