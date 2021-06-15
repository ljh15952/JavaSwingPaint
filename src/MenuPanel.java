import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener {

	public JMenuBar menuBar;

	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;

	private JMenuItem loadItem;
	private JMenuItem saveItem;
	private JMenuItem exitItem;

	public MenuPanel() {
		super(true);
		setPreferredSize(new Dimension(100, 1));
		setBackground(Color.LIGHT_GRAY);
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");

		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);

		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (loadItem == e.getSource()) {
			System.out.println("LOAD FILE");
			PaintManager.getInstance().Load();
		} else if (saveItem == e.getSource()) {
			System.out.println("SAVE FILE");
			PaintManager.getInstance().Save();
		} else if (exitItem == e.getSource()) {
			System.exit(0);
		}
	}
}
