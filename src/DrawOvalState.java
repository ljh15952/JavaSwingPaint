import java.awt.Point;

public class DrawOvalState extends DrawState implements StatePattern {

	Oval o;
	@Override
	public void setUp() {
		o = new Oval();
		PaintManager.getInstance().addFigureList(o);
	}
	@Override
	public void do_something(Point p1, Point p2) {
		setFigure(o,p1,p2);
	}
	@Override
	public void end(Point p1,Point p2) {
		
	}

}