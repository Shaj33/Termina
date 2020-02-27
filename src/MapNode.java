
public class MapNode {
	private String name, desc;
	private MapNode north, south, east, west;
	
	public MapNode(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public static MapNode CreateMap() {
		MapNode start = new MapNode("Start", "The Start");
		MapNode end = new MapNode("End", "The End");
		MapNode wild = new MapNode("Wild Area", "Encounters on");
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
	
	
	
	
	
}
