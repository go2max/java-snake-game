package view.cgi.test;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import view.ViewController;
import view.cgi.LWJGLBoardView;

import models.board.Board;
import models.board.Direction;
import models.board.HexDirection;
import models.board.HexTiles.RVR;

public class LWJGLBoardViewTest {

	JFrame frame = new JFrame();
	Board board;
	LWJGLBoardView view;
	
	public LWJGLBoardViewTest() {
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board=new Board(HexDirection.N, "board.txt");
		ViewController viewController=new ViewController();
		view = new LWJGLBoardView(board, viewController);
		view.setSize(512,512);
		System.out.println(frame.isDisplayable());
		frame.add(view);

		board.getRoot().getAdjacentSpace(HexDirection.S)
		.getAdjacentSpace(HexDirection.S)
		.getAdjacentSpace(HexDirection.S)
		.getAdjacentSpace(HexDirection.S)
		.placeTile(new RVR().buildTile(HexDirection.S));
		
		view.update();
		ArrayList<Direction> path = new ArrayList<Direction>();
		path.add(HexDirection.S);
		path.add(HexDirection.S);
		path.add(HexDirection.S);
		view.addTiles(new RVR().buildTile(HexDirection.S),path);
		path.add(HexDirection.S);
		view.displayDev(path, Color.yellow);
		path.add(HexDirection.S);
		view.hilightSpace(path);
	}
/*	
	int x=0,y=0;
	int pitch=90,yaw=0;
	
	int prevx=0;
	int prevy=0;
	boolean mouseWasDown=false;
	boolean rmouseWasDown=false;
	boolean mmouseWasDown=false;
	
	int zoom=100;
	
	public void pollInput(){
		
		int wheelDelta=Mouse.getDWheel();
		if (wheelDelta!=0){
			zoom=Math.max(1,zoom+wheelDelta/Math.abs(wheelDelta));
		}
		
		if (Mouse.isButtonDown(0)){
			if (mouseWasDown) {
				y += (Mouse.getY() - prevy)/view.getSceneScale();
				x += (Mouse.getX() - prevx)/view.getSceneScale();
			}
			prevy=Mouse.getY();
			prevx=Mouse.getX();
			mouseWasDown=true;
		}else{
			mouseWasDown=false;
		}
		
		if (Mouse.isButtonDown(1)){
			if (rmouseWasDown) {
				pitch += (Mouse.getY() - prevy);
				yaw += (Mouse.getX() - prevx);
			}
			prevy=Mouse.getY();
			prevx=Mouse.getX();
			rmouseWasDown=true;
		}else{
			rmouseWasDown=false;
		}

		view.setSceneScale((zoom*zoom*zoom*0.0000005));

		Vector2D sceneTranslation=new Vector2D(
				  (float)(x*LWJGLBoardView.CANVAS_WIDTH/(frame.getWidth()))
				, -(float)(y*LWJGLBoardView.CANVAS_HEIGHT/(frame.getHeight())));
		sceneTranslation=sceneTranslation.rotate((float) ((yaw*Math.PI)/180f));
		
		view.setSceneTranslation(new Vector3D(
				sceneTranslation.x,
				0,
				sceneTranslation.y
				));
		view.setScenePitch(pitch);
		view.setSceneYaw(yaw);
	}*/
	
	public static void main(String[] args) {
		LWJGLBoardViewTest tester=new LWJGLBoardViewTest();
	}
	
}
