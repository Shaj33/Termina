
public class Battle {
	
	
	public static boolean enemybattle(Player player, Monster enemy) {
		System.out.printf("You have encountered a %s%n", enemy);
		int playertick = 0, monstertick = 0;
		
		
		while (player.getChp() > 0 && enemy.getChp() > 0) {
			playertick += player.getSpd();
			monstertick += enemy.getSpd();
			
			if (playertick > 1000) {
				playertick -= 1000;
				playermove(player, enemy);
			}
			
			if (monstertick > 1000) {
				monstertick -= 1000;
				monstermove(player, enemy);
			}
		}
		
		return true;
	}
	
	
	
	public static void playermove(Player player, Monster enemy) {
		

		int action = 0;
		String actin;
		while (action > 4 || action < 1) {
			System.out.printf("What do you want to do?%n1. Attack\t2. Skills%n3. Items\t4. Run%n%n");
			
			actin = GameStart.input.next();
			
			if (GameStart.isInteger(actin)) {
				action = Integer.parseInt(actin);
			} else {
				action = 0;
			}
			
			if (action == 1) {
				player.attack(enemy);
			} else if (action == 2) {
				GameStart.NotInYet();
			} else if (action == 3) {
				GameStart.NotInYet();
			} else if (action == 4) {
				player.setChp(0);
				System.out.printf("You ran from the %s", enemy);
			} else {
				System.out.println("Invalid action.");
			}
		}
	}
	
	public static void monstermove(Player player, Monster enemy) {
		int enemymove = GameStart.rand.nextInt(10);
		
		if (enemymove == 9 && enemy.specattack2(player)) { 
			return;
		} else if (enemymove >= 6 && enemy.specattack1(player)) {
			return;
		} else {
			enemy.attack(player);
		}
	}
}
