/*
 * OODP, laboration 3
 *
 * ControlPanel.java
 *
 * Peter Jenke, 2015-01-10
 */
package gui;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ctrl.FigureController;
import model.Drawable;
import model.Figure;

/**
 * ControlPanel är en behållare för olika styrelement.
 * 
 * @author Peter.Jenke@hig.se
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	private DrawingPanel dp;
	private DialogCreator dc;
	private FileNameCreator df;
	
	private FigureController controller;

	/**
	 * Skapar en ny instans av ControlPanel.
	 */
	public ControlPanel (DrawingPanel dp) {
		this.dp = dp;
		controller = new FigureController();
		
		setLayout(new GridLayout(2, 8));

		JButton newPointButton     = new JButton("New Point");
		JButton newLineButton      = new JButton("New Line");
		JButton newTriangleButton  = new JButton("New Triangle");
		JButton newCircleButton    = new JButton("New Circle");
		JButton newRectangleButton = new JButton("New Rectangle");
		JButton moveAllButton      = new JButton("Move All");
		JButton scaleAllButton     = new JButton("Scale All");
		JButton rotateAllButton    = new JButton("Rotate All");
		JButton printAllDataButton = new JButton("Print Data");
		JButton removeAllButton    = new JButton("Remove");
		JButton exportButton       = new JButton("Export");
		
		newPointButton.addActionListener(new NewPointListener());
		newLineButton.addActionListener(new NewLineListener());
		newTriangleButton.addActionListener(new NewTriangleListener());
		newCircleButton.addActionListener(new NewCircleListener());
		newRectangleButton.addActionListener(new NewRectangleListener());
		moveAllButton.addActionListener(new MoveListener());
		scaleAllButton.addActionListener(new ScaleListener());
		rotateAllButton.addActionListener(new RotateListener());
		printAllDataButton.addActionListener(new PrintAllDataListener());
		removeAllButton.addActionListener(new RemoveAllListener());
		exportButton.addActionListener(new ExportListener());
		
		add(newPointButton);
		add(newLineButton);
		add(newTriangleButton);
		add(newCircleButton);
		add(newRectangleButton);
		add(removeAllButton);
		add(moveAllButton);
		add(scaleAllButton);
		add(rotateAllButton);
		add(printAllDataButton);
		add(exportButton);
		
		dc = new DialogCreator();
		df = new FileNameCreator();
	}
	
	void update() {
		 List<Drawable> drawables = new ArrayList<Drawable>();
			
		for(Figure figure : controller.getMovableFigures()) {
			if(figure instanceof Drawable) {
				Drawable temp = (Drawable) figure;
				drawables.add(temp);
			}
		}

		dp.setDrawables(drawables);
		dp.repaint();
	}
	
	private class NewPointListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mx = "x ";
			String my = "y ";
			
			double x = dc.createDoubleDialog(mx);
			double y = dc.createDoubleDialog(my);
			
			// Skapa en ny punkt genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			controller.createPoint(x, y);
			update();
		}	
	}
	
	private class NewLineListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mx0 = "x0 ";
			String my0 = "y0 ";
			String mx1 = "x1 ";
			String my1 = "y1 ";
			
			double x0 = dc.createDoubleDialog(mx0);
			double y0 = dc.createDoubleDialog(my0);
			double x1 = dc.createDoubleDialog(mx1);
			double y1 = dc.createDoubleDialog(my1);
			
			controller.createLine(x0, y0, x1, y1);

			// Skapa en ny linje genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			controller.createLine(x0, y0, x1, y1);
			update();
		}	
	}
	
	private class NewTriangleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mx0 = "x0 ";
			String my0 = "y0 ";
			String mx1 = "x1 ";
			String my1 = "y1 ";
			String mx2 = "x2 ";
			String my2 = "y2 ";
			
			double x0 = dc.createDoubleDialog(mx0);
			double y0 = dc.createDoubleDialog(my0);
			double x1 = dc.createDoubleDialog(mx1);
			double y1 = dc.createDoubleDialog(my1);
			double x2 = dc.createDoubleDialog(mx2);
			double y2 = dc.createDoubleDialog(my2);

			// Skapa en ny linje genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			controller.createTriangle(x0, y0, x1, y1, x2, y2);
			update();
		}	
	}
	
	private class NewCircleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mx = "x ";
			String my = "y ";
			String mr = "radius ";
			
			double x = dc.createDoubleDialog(mx);
			double y = dc.createDoubleDialog(my);
			double r  = dc.createDoubleDialog(mr);

			// Skapa en ny linje genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			controller.createCircle(x, y, r);
			update();
		}	
	}
	
	private class NewRectangleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mx = "x ";
			String my = "y ";
			String mw = "width ";
			String mh = "height ";
			
			double x = dc.createDoubleDialog(mx);
			double y = dc.createDoubleDialog(my);
			double w = dc.createDoubleDialog(mw);
			double h = dc.createDoubleDialog(mh);

			// Skapa en ny linje genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			controller.createRectangle(x, y, w, h);
			update();
		}	
	}

	private class MoveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mdx = "dx ";
			String mdy = "dy ";
			
			double dx = dc.createDoubleDialog(mdx);
			double dy = dc.createDoubleDialog(mdy);
			
			// Flyttar alla figurer som kan förflyttas i riktningen [dx, dy].
			controller.moveAll(dx, dy);
			
			update();
		}	
	}

	private class ScaleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String msx = "sx ";
			String msy = "sy ";
			
			double sx = dc.createDoubleDialog(msx);
			double sy = dc.createDoubleDialog(msy);
			
			// Skalar alla figurer som kan skala med [sx, sy]
			controller.scaleAll(sx,sy);

			update();
		}
	}
	
	private class RotateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String mAngle = "angle ";
			
			double angle = dc.createDoubleDialog(mAngle);
			
			controller.rotateAll(angle);

			update();
		}	
	}
	
	private class PrintAllDataListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.printAll();
			update();
		}	
	}
	
	private class RemoveAllListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.removeAll();
			update();
		}	
	}
	
	private class ExportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			BufferedImage image = new BufferedImage(dp.getWidth(), dp.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = image.createGraphics();
			dp.paint(g2d);
			String mFileName = "Enter file name: ";
			String fileName = df.createFileName(mFileName);
			
			try {
				ImageIO.write(
					image, 
					"png", 
					new File("H:\\beachsand\\OODP Laboration 3\\export\\" + fileName + ".png")
				);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private class DialogCreator {
		double createDoubleDialog (String msg) {
			String inValue = null;				// inmatad text
			String error_msg = "";				// felmeddelandet som visas om texten innehåller
												// andra tecken än bara siffror och en punkt
			double v = 0;
			
			while ((inValue = JOptionPane.showInputDialog (msg + error_msg + ":")) != null) {
				error_msg = "";
				
				/*
				Om texten innehåller något annat än siffror, så genereras en
				NumberFormatException. Vi vill inte att programmet avslutar
				och fångar den. Istället visas ett felmeddelande för användaren.
				*/
				try {
					v = Double.parseDouble (inValue);
					break;
				} catch (NumberFormatException nfe) {
					error_msg = " (Values may only consists of numbers with decimal sign)";
				}
			}

			return v;
		}
	}
	
	private class FileNameCreator {
		String createFileName (String msg){
			
			String error_msg = "";
			String s = "";
			s = JOptionPane.showInputDialog (msg + error_msg + ":");
			
			return s;	
		}
	}
}
