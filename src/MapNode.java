
public class MapNode {
	private String name, desc;
	private MapNode north, south, east, west;
	private boolean encounters;
	private Monster[] monsterlist;
	
	public MapNode(String name, String desc, boolean encounters) {
		this.name = name;
		this.desc = desc;
		this.encounters = encounters;
	}
	
	public static MapNode CreateMap() {
		MapNode start = new MapNode("Start", "The Start", false);
		MapNode end = new MapNode("End", "The End", false);
		MapNode wild = new MapNode("Wild Area", "Encounters on", true);
		
		Monster[] wildlist = {new Goblin()};
		
		wild.setMonsterlist(wildlist);
		
		
		start.setNorth(end);
		start.setEast(wild);
		return start;
	}
	
	public String toString() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MapNode getNorth() {
		return north;
	}

	public void setNorth(MapNode north) {
		this.north = north;
		north.south = this;
	}

	public MapNode getSouth() {
		return south;
	}

	public void setSouth(MapNode south) {
		this.south = south;
		south.north = this;
	}

	public MapNode getEast() {
		return east;
	}

	public void setEast(MapNode east) {
		this.east = east;
		east.west = this;
	}

	public MapNode getWest() {
		return west;
	}

	public void setWest(MapNode west) {
		this.west = west;
		west.east = this;
	}

	public boolean isEncounters() {
		return encounters;
	}

	public void setEncounters(boolean encounters) {
		this.encounters = encounters;
	}

	public Monster[] getMonsterlist() {
		return monsterlist;
	}

	public void setMonsterlist(Monster[] monsterlist) {
		this.monsterlist = monsterlist;
	}
	
	
	
	
	
}
