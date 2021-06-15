import java.awt.Point;

public class DrawRectState extends DrawState implements StatePattern {
	
	Rect r;
	@Override
	public void setUp() {
		r = new Rect();
		PaintManager.getInstance().addFigureList(r);
	}
	@Override
	public void do_something(Point p1, Point p2) {
		setFigure(r,p1,p2);
	}
	@Override
	public void end() {
		
	}

}