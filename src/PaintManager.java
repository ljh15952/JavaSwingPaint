import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class PaintManager {
	private static PaintManager _instance = null;

	/*
	 * 필요한 변수 팬 두께 팬 색깔 상태
	 */
	private Color penColor = new Color(1,1,1);
	private int penSize = 1;
	private ArrayList<Figure> figureList = new ArrayList<>();
	private StatePattern nowState = null;

	private PaintManager() {
		// 생성자가 private
	}

	public static PaintManager getInstance() {
		if (_instance == null)
			_instance = new PaintManager();
		return _instance;
	}

	public void setPenColor(Color c) {
		penColor = c;
	}

	public Color getPenColor() {
		return penColor;
	}

	public void setPenSize(int c) {
		penSize = c;
	}

	public int getPenSize() {
		return penSize;
	}

	public void addFigureList(Figure g) {
		figureList.add(g);
	}

	public ArrayList<Figure> getFigureList() {
		return figureList;
	}

	public void setUp() {
		if (nowState == null)
			return;
		nowState.setUp();
	}

	public void do_something(Point p1, Point p2) {
		if (nowState == null)
			return;
		nowState.do_something(p1, p2);
	}
	
	public void endEvnet(Point p1,Point p2) {
		if (nowState == null)
			return;
		nowState.end(p1,p2);
	}
	
	public void setStatePattern(StatePattern s) {
		nowState = s;
	}
	
	public void removeFigure(Figure f) {
		figureList.remove(f);
		//repaint();
	}
}
