package ctrl;

import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 * Klassen â€œFigureControllerâ€� har som syfte att hantera den logiska och styrande 
 * delen av programmet. Den skapar och sorterar de olika figurerna i listor som 
 * beskriver beteenden. Det finns tre beteenden som figurerna klassificeras enligt 
 * med genom operationen classify(): movableFigures, scalableFigures och 
 * rotatableFigures. Alla figurer Ã¤r flyttbara och vissa figurer har alla tre 
 * beteenden.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class FigureController implements FigureHandler, FigureMover, FigureScalor, FigureRotor, FigurePrinter {
	private List<Figure> movableFigures;
	private List<Scale> scalableFigures;
	private List<Rotate> rotatableFigures;
	
	public FigureController() {
		movableFigures = new ArrayList<Figure>();
		scalableFigures = new ArrayList<Scale>();
		rotatableFigures = new ArrayList<Rotate>();
	}

	@Override
	public void createPoint(double x, double y) {
		movableFigures.add(new Point(new Vertex2D(x, y)));
	}

	@Override
	public void createLine(double x0, double y0, double x1, double y1) {
		Line line = new Line(
			new Vertex2D(x0, y0), 
			new Vertex2D(x1, y1)
		);
		
		movableFigures.add(line);
		scalableFigures.add(line);
		rotatableFigures.add(line);
	}

	@Override
	public void createTriangle(double x0, double y0, double x1, double y1, double x2, double y2) {
		Triangle triangle = new Triangle(
			new Vertex2D(x0, y0), 
			new Vertex2D(x1, y1),
			new Vertex2D(x2, y2)
		);
		
		movableFigures.add(triangle);
		scalableFigures.add(triangle);
		rotatableFigures.add(triangle);
	}

	@Override
	public void createCircle(double x, double y, double radius) {
		Circle circle = new Circle(
			new Vertex2D(x, y), 
			radius
		);
		
		movableFigures.add(circle);
		scalableFigures.add(circle);
	}

	@Override
	public void createRectangle(double x, double y, double width, double height) {
		Rectangle rectangle = new Rectangle(
			new Vertex2D(x, y), 
			width, 
			height
		);
		
		movableFigures.add(rectangle);
		scalableFigures.add(rectangle);
		rotatableFigures.add(rectangle);
	}

	@Override
	public void moveAll(double dx, double dy) {
		List<Figure> tempMovableFigures = new ArrayList<Figure>();
		
		for(Figure figure : movableFigures) {
			tempMovableFigures.add(figure.translate(dx, dy));
		}
		
		movableFigures = tempMovableFigures;
	}

	@Override
	public void scaleAll(double xFactor, double yFactor) {
		List<Scale> tempScalableFigures = new ArrayList<Scale>();
		
		for(Scale scalable : scalableFigures) {
			tempScalableFigures.add((Scale) scalable.scale(xFactor, yFactor));
		}
		
		scalableFigures = tempScalableFigures;
	}

	@Override
	public void rotateAll(double angle) {
		List<Rotate> tempRotatableFigures = new ArrayList<Rotate>();
		
		for(Rotate rotate : rotatableFigures) {
			tempRotatableFigures.add((Rotate) rotate.rotate(angle));
		}
		
		rotatableFigures = tempRotatableFigures;
	}

	@Override
	public void removeAll() {
		/*
		 *  This removes all figures from scalableFigures that are in the movableFigures list.
		 *  
		 */
		scalableFigures.removeAll(movableFigures);
		/*
		 *  This removes all figures from rotatableFigures that are in the movableFigures list.
		 *  
		 */
		rotatableFigures.removeAll(movableFigures);
		/*
		 *  This removes all figures from the movableFigures list.
		 *  
		 */
		movableFigures.removeAll(movableFigures);
	}

	@Override
	public void printAll() {
		for(Figure figure : movableFigures) {
			System.out.println(figure);
		}
	}
	
	public List<Figure> getMovableFigures() {
		return movableFigures;
	}
	
	public List<Scale> getScalableFigures() {
		return scalableFigures;
	}
	
	public List<Rotate> getRotatableFigures() {
		return rotatableFigures;
	}
}
