package models.board;

public class Board <A extends Space, B extends Tile, C extends Direction> {
	private Space<A,B,C> rootNode;
	private Developer[] developers;
	
	public Board (Space<A,B,C> rootNode, Developer[] developers) {
		this.rootNode = rootNode;
		this.developers = new Developer[12];
	}

	public Space<A, B, C> getRoot() {
		return rootNode;
	}

	public Developer[] getDevelopers() {
		return developers;
	}
	
	public Developer getNextDeveloper(Developer currentDeveloper) {
		return null;
	}
	
	public Developer getFirstDeveloper(Player p) {
		return null;
	}
}