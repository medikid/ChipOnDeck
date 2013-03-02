package poker.app.table;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import poker.Images;
import poker.app.Window;
import poker.app.player.Player;

public class TableRegion {
	ScreenRegion tableWindowRegion;
	ScreenRegion tableFrame;
	ScreenRegion playerDash1;
	ScreenRegion playerDash2;
	ScreenRegion playerDash3;
	ScreenRegion playerDash4;
	ScreenRegion playerDash5;
	ScreenRegion playerDash6;
	ScreenRegion playerDash7;
	ScreenRegion playerDash8;
	ScreenRegion playerDash9;
	ScreenRegion playerDash10;
	
	Canvas canvas;	
	int tableSize;
	double rowGridOffset = 0.200;
	double colGridOffset = 0.166;
	
	public TableRegion(Window tableWindow){
		ScreenRegion TableWindowRegion =  new DesktopScreenRegion(
				tableWindow.getWindowRegion().x,
				tableWindow.getWindowRegion().y,
				tableWindow.getWindowRegion().w,
				tableWindow.getWindowRegion().h);
		this.setTableWindow(TableWindowRegion);
		canvas = new DesktopCanvas();
	}
	
	public void setTableWindow(ScreenRegion TableWindow){
		this.tableWindowRegion = TableWindow;
	}
	
	public ScreenRegion getTableWindow(){
		return this.tableWindowRegion;
	}
	
	public void setTableFrame(){
		this.tableFrame = this.deriveTableFrame();
	}
	
	public ScreenRegion getTableFrame(){
		if( this.tableFrame == null){
			this.setTableFrame();
		}
		return this.tableFrame;
	}
	
	public void hightlightTableFrame(int sec){
		this.canvas.addBox(this.tableFrame).display(sec);
	}
	
	public void setTableSize(int size){
		this.tableSize = size;		
	}
	
	public int getTableSize(){
		return this.tableSize;
	}
	
	public void clearHightlights(){
		this.canvas.clear();
	}
	
	public ScreenRegion deriveTableFrame(){
		ScreenRegion TableFrame = null;
		Target TableAnchorXY = new ImageTarget(Images.PNTableAnchorXY);
		Target TableAnchorW = new ImageTarget(Images.PNTableAnchorW);
		Target TableAnchorH = new ImageTarget(Images.PNTableAnchorH);
		
		ScreenRegion TableFrameXY = this.tableWindowRegion.find(TableAnchorXY);
		ScreenRegion TableFrameW = this.tableWindowRegion.find(TableAnchorW);
		ScreenRegion TableFrameH = this.tableWindowRegion.find(TableAnchorH);		
		
		int X = TableFrameXY.getBounds().x;
		int Y = TableFrameXY.getBounds().y;		
		int W = (TableFrameW.getBounds().x + TableFrameW.getBounds().width) - X ;
		int H = (TableFrameH.getBounds().y + TableFrameH.getBounds().height) - Y;
		
		TableFrame = new DesktopScreenRegion(X, Y, W, H);		
		
		return TableFrame;
	}
	
	public void drawTableFrameGrids(){
		int X = this.tableFrame.getBounds().x;
		int Y = this.tableFrame.getBounds().y;		
		int W = this.tableFrame.getBounds().width;
		int H = this.tableFrame.getBounds().height;
		ScreenRegion row1 = new DesktopScreenRegion(X, Y, W, (int)(H * 0.2) );
		ScreenRegion row2 = new DesktopScreenRegion(X, Y + (int)(H * 0.2), W, (int)(H * 0.2) );
		ScreenRegion row3 = new DesktopScreenRegion(X, Y + (int)(H * 0.4), W, (int)(H * 0.2) );
		ScreenRegion row4 = new DesktopScreenRegion(X, Y + (int)(H * 0.6), W, (int)(H * 0.2) );
		ScreenRegion row5 = new DesktopScreenRegion(X, Y + (int)(H * 0.8), W, (int)(H * 0.2) );
		
		ScreenRegion col1 = new DesktopScreenRegion(X, Y, (int)(W * 0.166), H);
		ScreenRegion col2 = new DesktopScreenRegion(X + (int)(W * 0.166), Y, (int)(W * 0.166), H);
		ScreenRegion col3 = new DesktopScreenRegion(X + (int)(W * 0.332), Y, (int)(W * 0.166), H );
		ScreenRegion col4 = new DesktopScreenRegion(X + (int)(W * 0.498), Y, (int)(W * 0.166), H );
		ScreenRegion col5 = new DesktopScreenRegion(X + (int)(W * 0.664), Y, (int)(W * 0.166), H );
		ScreenRegion col6 = new DesktopScreenRegion(X + (int)(W * 0.830), Y, (int)(W * 0.166), H );
		
		canvas.addBox(row1).display(3);
		canvas.addBox(row2).display(3);
		canvas.addBox(row3).display(3);
		canvas.addBox(row4).display(3);
		canvas.addBox(row5).display(3);
		canvas.addBox(col1).display(3);
		canvas.addBox(col2).display(3);
		canvas.addBox(col3).display(3);
		canvas.addBox(col4).display(10);
		canvas.addBox(col5).display(20);
	}
	
	public List<Player> derivePlayerDash(){
		List<Player> Players = new ArrayList<Player>();
		ScreenRegion playerDash;
		Target tPlayerDashAnchor = new ImageTarget(Images.PNTablePlayerDashAnchor);
		tPlayerDashAnchor.setMinScore(0.95);
		List<ScreenRegion> matches = this.tableFrame.findAll(tPlayerDashAnchor);
		for (ScreenRegion p: matches){
			int X = p.getBounds().x;
			int Y = p.getBounds().y;
			int W =	p.getBounds().width;
			int H = p.getBounds().height;
					
			playerDash = new DesktopScreenRegion(
					X - (int)(W / 1.55),
					Y - (int)(W * 1.80),
					W + (int)(W * 1.25),
					H + (int)(W * 2)
					);
			
			int seatNumber = this.deriveSeatNumber(playerDash);
			
			Player pl = new Player();
			pl.setSeatNumber(seatNumber);
			Players.add(pl);
					
			this.canvas.addBox(playerDash).display(5);
			this.canvas.addLabel(playerDash, String.valueOf(seatNumber)).display(1);
		}
		return Players;
		
	}
	
	public Point derivePlayerDashGridPosition(ScreenRegion playerDash){
		ScreenLocation dashCenter = playerDash.getCenter();
				
		int row = (int)(dashCenter.getY() - this.tableFrame.getBounds().y) / (int)( this.tableFrame.getBounds().height * this.rowGridOffset);
		int col = (int)(dashCenter.getX() - this.tableFrame.getBounds().x) / (int)( this.tableFrame.getBounds().width * this.colGridOffset);
		
		Point row_col = new Point(row, col);
		
		return row_col;	
	}
	
	
	public int[][] getPlayersPositionGrid(){
		int rowTotal = 5;
		int colTotal = 6;
		int[][] tableGrid = new int[rowTotal][colTotal];
		
		tableGrid[0][4] = 1;
		tableGrid[1][5] = 2;
		tableGrid[2][5] = 3;
		tableGrid[3][4] = 4;
		tableGrid[3][3] = 5;
		tableGrid[3][2] = 6;
		tableGrid[3][1] = 7;
		tableGrid[2][0] = 8;
		tableGrid[1][0] = 9;
		tableGrid[0][1] = 10;
		
		return tableGrid;		
	}
	
	public int getSeatNumber(Point row_col){
		int[][] tableGrid = getPlayersPositionGrid();
		
		return tableGrid[row_col.x][row_col.y];
	}
	
	public int deriveSeatNumber(ScreenRegion playerDash){
		Point row_col = this.derivePlayerDashGridPosition(playerDash);
		int seatNumber = this.getSeatNumber(row_col);
		return seatNumber;
	}
	


}
