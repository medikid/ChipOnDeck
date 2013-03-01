package poker.app.table;

import java.util.List;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import poker.Images;

public class TableRegion {
	ScreenRegion tableWindow;
	ScreenRegion tableFrame;
	Canvas canvas;
	
	public TableRegion(ScreenRegion TableWindow){
		this.setTableWindow(TableWindow);
		canvas = new DesktopCanvas();
	}
	
	public void setTableWindow(ScreenRegion TableWindow){
		this.tableWindow = TableWindow;
	}
	
	public ScreenRegion getTableWindow(){
		return this.tableWindow;
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
	
	public void clearHightlights(){
		this.canvas.clear();
	}
	
	public ScreenRegion deriveTableFrame(){
		ScreenRegion TableFrame = null;
		Target TableAnchorXY = new ImageTarget(Images.PNTableAnchorXY);
		Target TableAnchorW = new ImageTarget(Images.PNTableAnchorW);
		Target TableAnchorH = new ImageTarget(Images.PNTableAnchorH);
		
		ScreenRegion TableFrameXY = this.tableWindow.find(TableAnchorXY);
		ScreenRegion TableFrameW = this.tableWindow.find(TableAnchorW);
		ScreenRegion TableFrameH = this.tableWindow.find(TableAnchorH);
		/*
		canvas.addBox(TableFrameXY).display(3);
		canvas.addBox(TableFrameW).display(3);
		canvas.addBox(TableFrameH).display(3);
		*/
		int X = TableFrameXY.getBounds().x;
		int Y = TableFrameXY.getBounds().y;		
		int W = (TableFrameW.getBounds().x + TableFrameW.getBounds().width) - X ;
		int H = (TableFrameH.getBounds().y + TableFrameH.getBounds().height) - Y;
		
		TableFrame = new DesktopScreenRegion(X, Y, W, H);		
		
		return TableFrame;
	}
	
	public void deriveTableFrameGrids(){
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
		canvas.addBox(col4).display(3);
		canvas.addBox(col5).display(3);
	}
	
	public void derivePlayerDash(){
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
			this.canvas.addBox(playerDash).display(5);
		}
		
		
	}

}
