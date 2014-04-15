package models.board;

public class HexSpace extends Space<HexSpace, HexTileComponent, HexDirection>{


    public HexSpace(){
        numNeighbors = 6;
        super.setNeighbors(new HexSpace[numNeighbors]);
    }

    @Override
    public HexSpace getAdjacentSpace(HexDirection direction) {
        return super.getNeighbor(direction);
    }

	@Override
	public void placeTile(HexTileComponent tile) {

	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean verifyStacking(HexTileComponent tile) {
		return false;
	}

	@Override
	public boolean verifyHeights(HexTileComponent tile) {
		return false;
	}


    @Override
    public boolean neighborExists(HexDirection direction) {
        return false;
    }

}
