import java.util.ArrayList;

public class Player {
	private String name;
	private int maxhp, chp, maxtech, ctech, atk, def, spd, level, exp;
	private MapNode cmap;
	private Weapon eqWeapon;
	private Armor eqArmor;
	private ArrayList<Skill> Skills = new ArrayList<Skill>();
	private StatusEffect Status;
	
	//Player constructed at game beginning 
	public Player(String name) {
		this.name = name;
		maxhp = 10;
		chp = 10;
		maxtech = 10;
		ctech = 0;
		atk = 3;
		def = 3;
		spd = 3;
		cmap = MapNode.CreateMap();
		level = 1;
		exp = 0;
		eqWeapon = new Weapon("Fists", "You swing your fists.", 1);
		eqArmor = new Armor("Peasant Clothes", 1);
		Skills.add(new BigStrike());
		Status = new StatusEffect("None", -1, false);
	}

	//Move command allows Player to move around the map
	public void move(){
		
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
	
	public void encounter() {
		
		if (!cmap.isEncounters()) return;
		
		int monster = GameStart.rand.nextInt(cmap.getMonsterlist().length);
		
		Monster enemy = null;
		try {
			enemy = Monster.cloneMonster(cmap.getMonsterlist()[monster]);
			System.out.printf("%s, HP %s%n",enemy, enemy.getMaxhp());
			Battle.enemybattle(this, enemy);
		} catch (CloneNotSupportedException e) {
			System.out.println("No enemy encountered.");
			return;
		}
	}
	
	public void LevelUp() {
		//Specific levels will be implemented with maps later
		
		exp = 0;
		level++;
		
		System.out.printf("Congrats! You're now Level %d%n", level);
		System.out.printf("You have ten points to allocate. Please pick which stats you'd like to level up.%n");
		
		int points = 10, action = 0;
		String pp;
		while (points != 0) {
			System.out.printf("1. Max Health%n2. Max Technique (+ TP Gain)%n3. Attack%n4. Defense%n5. Speed%n%d Points remaining.%n", points);
			
			//Check for valid int
			pp = GameStart.input.next();
			
			if (GameStart.isInteger(pp)) {
				action = Integer.parseInt(pp);
			} else {
				action = 0;
			}
			
			
			if (action == 1) {
				maxhp++;
			} else if (action == 2) {
				maxtech++;
			} else if (action == 3) {
				atk++;
			} else if (action == 4) {
				def++;
			} else if (action == 5) {
				spd++;
			}
			
			if (action > 0 || action < 5) {
				points--;
			} else {
				System.out.println("Invalid input.\n");
			}
		}
	}
	
	//Combat move, basic attack against enemy
	public boolean attack(Monster enemy) {
		
		//Calculates damage based on weapon and personal attack and enemy defense. 
		int damage =  eqWeapon.attack() + atk - enemy.defend();
		
		if (damage < 0) damage = 0;
		//Updates and displays info. 
		System.out.printf("You hit for %d damage.%n", damage);
		enemy.setChp(enemy.getChp() - damage);
		System.out.printf("The %s has %d health left.%n", enemy, enemy.getChp());
		
		return true;
	}
	
	public int defend() {
		return def + eqArmor.getDef();
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

	public int getMaxtech() {
		return maxtech;
	}

	public void setMaxtech(int maxtech) {
		this.maxtech = maxtech;
	}

	public int getCtech() {
		return ctech;
	}

	public void setCtech(int ctech) {
		this.ctech = ctech;
	}

	public Armor getEqArmor() {
		return eqArmor;
	}

	public void setEqArmor(Armor eqArmor) {
		this.eqArmor = eqArmor;
	}

	public ArrayList<Skill> getSkills() {
		return Skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		Skills = skills;
	}
	
	public StatusEffect getStatus() {
		return Status;
	}
	
	public void setStatus(StatusEffect status) {
		this.Status = status;
	}
	

	
	
	
	
}
