package model;

/**
 * The <code>Scalable</code> interface adds scale functionality to its 
 * implemented classes.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 3.0
 *
 */
public interface Scale {
	/**
	 * This method applies scaling in the x and y-axis by the factors xFactor and yFactor.
	 * 
	 * @param xFactor - The factor by which the x-coordinate is to be scaled in the x-axis.
	 * @param yFactor - The factor by which the y-coordinate is to be scaled in the y-axis.
	 * 
	 * @return Figure - A new scaled instance of the <code>Figure</code> class is returned.
	 * 
	 */
	public Figure scale(double xFactor, double yFactor);
}
