package view.cgi;

import models.board.Board;
import models.board.Direction;
import models.board.TileComponent;
import view.ViewController;
import view.controls.BoardView;

import java.awt.Canvas;
import java.awt.Color;
import java.util.List;

/**an implementation of BoardView that uses an LWJGL canvas*/
public class LWJGLBoardView extends BoardView {
	
	public static final float CANVAS_WIDTH=10;
	public static final float CANVAS_HEIGHT=10;
	public static final float CANVAS_FAR=101;
	public static final float CANVAS_NEAR=1;
	
	LWJGLBoardViewBackend backend;
	
	Thread graphicsThread;
	
	Canvas lwjglCanvas;
	
	public LWJGLBoardView(Board b, ViewController controller) {
		super(b, controller);
		lwjglCanvas = new Canvas();
		add(lwjglCanvas);
	}
	
	@Override
	public synchronized void addNotify() {
		super.addNotify();
		
		System.out.println(getParent().isDisplayable());
		System.out.println(this.isDisplayable());
		
		lwjglCanvas.setSize(getSize());
		backend=new LWJGLBoardViewBackend(board, lwjglCanvas);
		Thread backendThread = new Thread(backend);
		backendThread.start();
		while (!backend.glInitialized()){
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update() {
		backend.update();
	}

    @Override
    public void hilightSpace(List<Direction> path) {
        backend.hilightSpace(path);
    }

    @Override
    public void displayDev(List<Direction> path, Color c) {
        backend.displayDev(path, c);
    }

    @Override
    public void addTiles(TileComponent root, List<Direction> path) {
        backend.addTiles(root, path);
    }

    ////////////////getters and setters////////////////
	
	public synchronized Vector3D getSceneTranslation() {
		return backend.getSceneTranslation();
	}

	public synchronized void setSceneTranslation(Vector3D sceneTranslation) {
		backend.setSceneTranslation(sceneTranslation);
	}

	public synchronized double getSceneYaw() {
		return backend.getSceneYaw();
	}

	public synchronized void setSceneYaw(double sceneYaw) {
		backend.setSceneYaw(sceneYaw);
	}

	public synchronized double getScenePitch() {
		return backend.getScenePitch();
	}

	public synchronized void setScenePitch(double scenePitch) {
		backend.setScenePitch(scenePitch);
	}

	public synchronized double getSceneScale() {
		return backend.getSceneScale();
	}

	public synchronized void setSceneScale(double sceneScale) {
		backend.setSceneScale(sceneScale);
	}
}