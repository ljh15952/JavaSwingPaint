
public class PaintManager {
	private static PaintManager _instance = null;

	/*
	 * 필요한 변수
	 * 팬 두께
	 * 팬 색깔
	 * 상태
	 */
	
	private PaintManager() {
		//생성자가 private
	}

	public static PaintManager getInstance() {
		if (_instance == null)
			_instance = new PaintManager();
		return _instance;
	}

	public void speak() {
		System.out.println("HI IM SINGLETON PAINT MANAGER");
	}
}
