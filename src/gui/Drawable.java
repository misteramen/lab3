package gui;

/**
 * The <code>Drawable</code> interface enables a class to be drawn by an implemented
 * instance of the PrimitivePainter interface.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public interface Drawable {
	public void draw(PrimitivesPainter painter);
}
