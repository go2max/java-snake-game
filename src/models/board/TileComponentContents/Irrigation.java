package models.board.TileComponentContents;

import models.board.NotWalkable;
import models.board.TilePlacementVisitor;
import models.board.TileVisitor;

public class Irrigation extends NotWalkable {
	
	public void accept(TilePlacementVisitor v) {
		v.visit(this);
	}

    @Override
    public void accept(TileVisitor v) {
        v.visit(this);
    }

    @Override
    public boolean canAcceptPalace(Palace p) {
        return getCanAcceptPalace();
    }
    
    public String toString(){
    	return "irrigation";
    }
}
