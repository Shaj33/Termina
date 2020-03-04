
public class Battle {
	
	/**
	 * Method for the General battle. Player and enemy take turns depending on their speed.
	 * @param player - Player character
	 * @param enemy - Enemy monster
	 * @return true if won, false if lost
	 */
	public static boolean enemybattle(Player player, Monster enemy) {
		System.out.println(enemy.entrance());//Monster entrance
		int playertick = 0, monstertick = 0; //Starts Both Player and Enemy at 0 ticks
		player.setCtech(0); //Sets Player's TP to 0
		/*
		 * Burning - Damage per second
		 * Oiled (Ignited) - If hit by burnable attack, will enhance burn effect
		 * Bleeding - Damage per second + slow effect
		 * Paralyzed - Chance-based Turn Loss
		 */
		
		
		//Loop is done while battle is ongoing. Constantly adds player and enemy speed to ticks. 
		//Once one reaches 1000, resets and respective turn commences.
		while (player.getChp() > 0 && enemy.getChp() > 0) {
			playertick += player.getSpd();
			monstertick += enemy.getSpd();
			
			if (playertick > 1000) {
				playertick -= 1000;
				playermove(player, enemy);
			}
			
			if (enemy.getChp() > 0 && monstertick > 1000) {
				monstertick -= 1000;
				monstermove(player, enemy);
			}
		}
		
		//Player wins, resets health, victory rewards
		if (enemy.getChp() <= 0) {
			player.setChp(player.getMaxhp());
			System.out.printf("You have defeated the %s%n", enemy);
			player.LevelUp();
			System.out.println("Press Enter to leave the battle.");
			GameStart.input.nextLine();
			GameStart.input.nextLine();
			return true;
		}
		return true;
	}
	
	
	/**
	 * Commands that dictate the player's turn. They may attack, use skills, use items, or run from the battle. 
	 * @param player - Player character
	 * @param enemy - Enemy monster
	 */
	public static void playermove(Player player, Monster enemy) {
		

		int action = 0, skillu;
		String actin;
		while (action > 4 || action < 1) {// If a valid action has not been picked, will loop until valid
			System.out.printf("Health: %d%nTP: %d%n%nWhat do you want to do?%n1. Attack\t2. Skills%n3. Items\t4. Run%n%n", player.getChp(), player.getCtech());
			
			actin = GameStart.input.next();
			
			if (GameStart.isInteger(actin)) {
				action = Integer.parseInt(actin);
			} else {
				action = 0;
			}
			
			if (action == 1) {//Basic Attack, Gain TP
				player.attack(enemy);
				player.setCtech(player.getCtech() + Math.round(player.getMaxtech()/10));
				
			} else if (action == 2) {//Player chooses skill, will consume TP
				for (int i = 0; i < player.getSkills().size(); i++) { //Prints out all skills player has
					System.out.printf("%d. %s%n", i+1, player.getSkills().get(i).getName());
				}
				System.out.println("Choose a skill.");
				actin = GameStart.input.next();
				
				if (GameStart.isInteger(actin)) {
					skillu = Integer.parseInt(actin);
				} else {
					skillu = 0;
				}
				
				if (skillu <= 0 || skillu > player.getSkills().size()) {
					System.out.println("No skill selected. Returning to Combat Menu.");
					action = 0;
				} else {
					Skill selected = player.getSkills().get(skillu-1);
					if (selected.getTcost() > player.getCtech()) {
						action = 0;
						System.out.println("Not enough TP. Returning to Combat Menu");
					} else {
						selected.skilluse(player, enemy);
					}
				}
				
			} else if (action == 3) {//Use items from inventory, will consume items
				GameStart.NotInYet();
			} else if (action == 4) {//Run from battle. Instant loss. 
				player.setChp(0);
				System.out.printf("You ran from the %s%n", enemy);
			} else {
				System.out.println("Invalid action.");
			}
		}
	}
	
	/**
	 * Method to dictate enemy turn. Enemy will use either a basic attack (60%), or one of two special attacks (30% & 10%). Will repeat until a valid attack is used.
	 * @param player - Player character
	 * @param enemy - Enemy character
	 */
	public static void monstermove(Player player, Monster enemy) {
		int enemymove = GameStart.rand.nextInt(10);
		
		while (true) {
			if (enemymove == 9 && enemy.specattack2(player)!= -1) { 
				return;
			} else if (enemymove >= 6 && enemy.specattack1(player) != -1) {
				return;
			} else if (enemy.attack(player) != -1){
				return;
			}
		}
	}
}
