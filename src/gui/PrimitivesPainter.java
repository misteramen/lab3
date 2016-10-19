package gui;

import model.Vertex2D;

public interface PrimitivesPainter {
	public void paintPoint(Vertex2D v);
	public void paintLine(Vertex2D v0, Vertex2D v1);
	public void paintEllipse(Vertex2D v, double a, double b);
}
