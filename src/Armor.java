
public class Armor {
	private String name;
	private int def;
	
	public Armor(String name, int def) {
		this.name = name;
		this.def = def;
	}
	
	public int defend() {
		return def;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	
}
