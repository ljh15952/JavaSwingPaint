import java.awt.Color;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PaintManager implements Serializable {
	private static PaintManager _instance = null;

	/*
	 * 필요한 변수 팬 두께 팬 색깔 상태
	 */
	private Color penColor = new Color(1, 1, 1);
	private int penSize = 1;
	private ArrayList<Figure> figureList = new ArrayList<>();
	private StatePattern nowState = null;
	private DrawPanel drawPanel = null;

	private PaintManager() {
		// 생성자가 private
	}

	public void setDrawPanel(DrawPanel p) {
		drawPanel = p;
	}

	public void Save() {
		try {
			FileOutputStream fout = new FileOutputStream("example.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(figureList);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Load() {
		try {
			FileInputStream fin = new FileInputStream("example.ser");
			ObjectInputStream in = new ObjectInputStream(fin);
			figureList = (ArrayList<Figure>) in.readObject();
			drawPanel.SetFigureCount();
			drawPanel.repaint();
			System.out.println(figureList.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void endEvnet(Point p1, Point p2) {
		if (nowState == null)
			return;
		nowState.end(p1, p2);
	}

	public void setStatePattern(StatePattern s) {
		nowState = s;
	}

	public void removeFigure(Figure f) {
		figureList.remove(f);
		// repaint();
	}
}
