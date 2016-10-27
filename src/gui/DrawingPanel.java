package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import model.Drawable;

/**
 * <code>DrawingPanel</code> is used to draw geometrical figures on its surface.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
class DrawingPanel extends JPanel implements MouseListener {
	private FigurePainterImpl figurePainter;
	
	/**
	 * Creates a new instance of DrawingPanel.
	 * 
	 */
	public DrawingPanel()
	{
		addMouseListener(this);
		
		figurePainter = new FigurePainterImpl();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		figurePainter.setGraphics(g2d);
		figurePainter.paintAll();
	}
	
	public void setDrawables(List<Drawable> drawables) {
		figurePainter.setDrawables(drawables);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		repaint ();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		repaint ();
	}
}
