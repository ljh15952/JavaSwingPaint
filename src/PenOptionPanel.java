import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PenOptionPanel extends JPanel implements ChangeListener {

	private JSlider[] colorSlider;
	private JSlider penSizeSlider;

	public PenOptionPanel() {
		setPreferredSize(new Dimension(100, 150));
		setBackground(Color.LIGHT_GRAY);

		colorSlider = new JSlider[3];

		for (int i = 0; i < 3; i++) {
			colorSlider[i] = new JSlider(0, 255, 1);
			colorSlider[i].setPreferredSize(new Dimension(500, 30));
			colorSlider[i].setPaintTicks(true);
			colorSlider[i].setPaintTrack(true);
			colorSlider[i].setMajorTickSpacing(50);
			colorSlider[i].setMinorTickSpacing(10);
			colorSlider[i].addChangeListener(this);
			add(colorSlider[i]);
		}

		colorSlider[0].setBackground(Color.RED);
		colorSlider[1].setBackground(Color.GREEN);
		colorSlider[2].setBackground(Color.BLUE);

		penSizeSlider = new JSlider(1, 10, 1);
		penSizeSlider.setPreferredSize(new Dimension(500, 30));
		penSizeSlider.setPaintTicks(true);
		penSizeSlider.setMajorTickSpacing(1);
		penSizeSlider.setForeground(Color.BLACK);
		penSizeSlider.addChangeListener(this);
		add(penSizeSlider);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int r = colorSlider[0].getValue();
		int g = colorSlider[1].getValue();
		int b = colorSlider[2].getValue();
		PaintManager.getInstance().setPenColor(new Color(r, g, b));
		PaintManager.getInstance().setPenSize(penSizeSlider.getValue());
	}
}
