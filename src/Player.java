
public class Player {
	private String name;
	private int maxhp, chp, atk, def, spd, level;
	private MapNode cmap;
	private Weapon eqWeapon;
	
	public Player(String name, int maxhp, int atk, int def, int spd) {
		this.name = name;
		this.maxhp = maxhp;
		chp = maxhp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
		cmap = MapNode.CreateMap();
		level = 1;
		eqWeapon = Weapon.createFists();
	}

	public void move() {
		System.out.printf("Where do you want to go?%n1. North (%s)%n2. South (%s)%n3. East (%s)%n4. West(%s)%n", cmap.getNorth(), cmap.getSouth(), cmap.getEast(), cmap.getWest());
		int move = GameStart.input.nextInt();
		
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
		
		System.out.printf("%n%s%n%s%n", cmap, cmap.getDesc());
	}
	
	public void attack() {
		System.out.println(eqWeapon.getAttackdesc());
		System.out.printf("You hit for %d damage.%n", eqWeapon.getAtk());
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

	
	
	
	
}
