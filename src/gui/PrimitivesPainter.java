package gui;

import model.Vertex2D;

/**
 * <code>PrimitivesPainter</code> defines three paint*() methods which
 * each aim to draw one of three basic geometric objects: A point, a Line 
 * and an ellipse.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public interface PrimitivesPainter {
	public void paintPoint(Vertex2D v);
	public void paintLine(Vertex2D v0, Vertex2D v1);
	public void paintEllipse(Vertex2D v, double a, double b);
}
