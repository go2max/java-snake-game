package view.controls;

import models.board.Board;
import models.board.HexDirection;
import models.board.HexSpace;
import models.board.HexTileComponent;
import view.ViewController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//TODO [Sydney Christopher] [Jorge]

public abstract class BoardView extends JPanel {
    private final int BORDER = 10;
    private final int WIDTH = (int)(3*Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4 - BORDER/2);
    private final int HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 300 - BORDER); //see PlayerView for Height
	protected ViewController viewC;
	protected Board<HexSpace, HexTileComponent, HexDirection> board;
    
    public BoardView(ViewController vc, Board<HexSpace, HexTileComponent, HexDirection> board){
        this.viewC = vc;
        this.board = board;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.DARK_GRAY);
    }
    
    /**redraws the entire board*/
    public abstract void update();
    
    /**draws a hilighted space*/
    public abstract void hilightSpace(ArrayList<HexDirection> path, int height);
    
    /**draws a developer*/
    public abstract void displayDev(ArrayList<HexDirection> path, int height);
}
