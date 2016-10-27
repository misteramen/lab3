package model;

/**
 * The <code>Rotatable</code> interface adds rotation functionality to its 
 * implemented classes.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 3.0
 *
 */
public interface Rotate {
	/**
	 * This method applies rotation by a supplied <code>angle</code>.
	 * 
	 * @param angle - The angle by which the coordinates are to be rotated by.
	 * 
	 * @return Figure - A new instance of the <code>Figure</code> class is returned.
	 * 
	 */
	public Figure rotate(double angle);
}
