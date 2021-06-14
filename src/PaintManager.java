import java.awt.Color;

public class PaintManager {
	private static PaintManager _instance = null;

	/*
	 * 필요한 변수 팬 두께 팬 색깔 상태
	 */
	private Color penColor;
	private int penSize;

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
}
