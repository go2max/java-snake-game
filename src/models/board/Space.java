package models.board;

import java.util.Iterator;
import java.util.Stack;

//TODO [Kevin][Jorge, Kevin]

public class Space {

	private Space[] neighbors;
    private Stack<TileComponent> tileStack = new Stack<TileComponent>();
    private Direction direction;
	private SpaceGeography spaceGeography; //lowlands, highlands, or central

	Space(Direction d, SpaceGeography spaceGeography)
	{
		direction = d;
		neighbors = new Space[d.numDirections()];
		this.spaceGeography = spaceGeography;
	}
    Space(Direction d, SpaceGeography spaceGeography, boolean[] neighborExistsUponCreation)
    {
        direction = d;
        neighbors = new Space[d.numDirections()];
	    this.spaceGeography = spaceGeography;
    }

	/**returns the space adjacent to this space in the given int direction.
	 * As this class is implemented, its subclasses may have their own conventions
	 * for how direction works.*/

 	public Space getAdjacentSpace(Direction direction){
        return neighbors[direction.getIntValue()];
    }
	public boolean hasAdjacentSpace(Direction direction)
	{
		return neighbors[direction.getIntValue()] != null;
	}

	
	/**places a tile on this space.  As tile is a graph, this
	 * method will probably be implemented recursively.*/
	public void placeTile(TileComponent tile){
		if (getHeight()==0||tile!=getTile()){
	        tileStack.push(tile);
	        Iterator<Direction> i =tile.getDirection().iterator();
	        while (i.hasNext()){
	        	Direction d = i.next();
	        	if (tile.getConjoinedTile(d)!=null&&getAdjacentSpace(d)!=null){
	        		getAdjacentSpace(d).placeTile(tile.getConjoinedTile(d));
	        	}
	        }
		}
    }

    public TileComponent getTile(){
        return tileStack.peek();
    }

    public boolean hasTile(){
        return getHeight() != 0;
    }

    public TileComponentContent getTileComponentContent(){
        return tileStack.peek().getTileComponentContent();
    }
	
	/**returns the height of the uppermost tile on this space*/
	public int getHeight(){
        return tileStack.size();
    }
	public boolean isInLowlands()
	{
		return spaceGeography == SpaceGeography.lowlands;
	}
	public boolean isInHighlands()
	{
		return spaceGeography == SpaceGeography.highlands;
	}
	public boolean isInCentralJava()
	{
		return spaceGeography == SpaceGeography.central;
	}

    public void setNeighbors(Space[] array){
        this.neighbors = array;
    }
    
    public void removeTile() {
    	tileStack.pop();
    }
	public Direction getDirections()
	{
		return direction;
	}

}
