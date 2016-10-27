package gui;

import java.awt.Graphics;

import model.Vertex2D;

/**
 * The <code>PrimitivesPainterImpl</code> is used to draw the three basic geometric
 * objects defined by the interface <code>PrimitivesPainter</code>.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class PrimitivesPainterImpl implements PrimitivesPainter {
	private Graphics g;
	
	public PrimitivesPainterImpl() {
		super();
	}
	
	@Override
	public void paintPoint(Vertex2D v) {
		g.fillOval((int) v.getX(), (int) v.getY(), (int) 5, (int) 5);
	}

	@Override
	public void paintLine(Vertex2D v0, Vertex2D v1) {
		g.drawLine((int) v0.getX(), (int) v0.getY(), (int) v1.getX(), (int) v1.getY());
	}

	@Override
	public void paintEllipse(Vertex2D v, double a, double b) {
		g.drawOval((int) v.getX(), (int) v.getY(), (int) a, (int) b);
	}
	
	public void setGraphics(Graphics g) {
		this.g = g;
	}
}
