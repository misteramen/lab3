package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The <code>FigurePainterImpl</code> class is used to draw its set
 * of <code>Drawable</code> instances to the screen.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class FigurePainterImpl implements FigurePainter {
	private List<Drawable> drawables;
	private PrimitivesPainterImpl painter;
	
	public FigurePainterImpl() {
		super();
		
		drawables = new ArrayList<Drawable>();
		painter = new PrimitivesPainterImpl();
	}
	
	@Override
	public void paintAll() {
		for(Drawable drawable : drawables) {
			drawable.draw(painter);
		}
	}
	
	public void setDrawables(List<Drawable> drawables) {
		this.drawables = drawables;
	}
	
	public void setGraphics(Graphics g) {
		painter.setGraphics(g);
	}
}
