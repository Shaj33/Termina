
public class StatusEffect {
	
	private String name;
	private int TimeLeft;
	private boolean Severe;
	
	/**
	 * Constructor for Status Effect
	 * @param TimeLeft - Turns remaining for status effect
	 * @param Severe - If the effect is a severe or activated effect
	 */
	public StatusEffect(String name, int TimeLeft, boolean Severe) {
		this.name = name;
		this.TimeLeft = TimeLeft;
		this.Severe = Severe;
	}

	public int getTimeLeft() {
		return TimeLeft;
	}

	public void TurnPass() {
		TimeLeft--;
	}

	public boolean isSevere() {
		return Severe;
	}

	public void setSevere(boolean severe) {
		Severe = severe;
	}

	public String toString() {
		return name;
	}
	
}
