/*
 * OODP, laboration 3
 *
 * ControlPanel.java
 *
 * Peter Jenke, 2015-01-10
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ctrl.FigureController;
import model.Figure;

/**
 * ControlPanel Ã¤r en behÃ¥llare fÃ¶r olika styrelement.
 * 
 * @author Peter.Jenke@hig.se
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	private DrawingPanel dp;
	private DialogCreator dc;
	
	private FigureController controller;

	/**
	 * Skapar en ny instans av ControlPanel.
	 */
	public ControlPanel (DrawingPanel dp) {
		this.dp = dp;
		controller = new FigureController();
		
		setLayout(new GridLayout(2, 8));
		
		JButton rotatePlusButton = new JButton("Rotate+");
		JButton rotateMinusButton = new JButton("Rotate-");
		JButton scaleUpButton = new JButton("Bigger");
		JButton scaleDownButton = new JButton("Smaller");
		JButton upButton = new JButton("\u2191");
		JButton downButton = new JButton("\u2193");
		JButton leftButton = new JButton("\u2190");
		JButton rightButton = new JButton("\u2192");
		JButton newPointButton = new JButton("New Point");
		JButton newLineButton = new JButton("New Line");
		JButton newTriangleButton = new JButton("New Triangle");
		JButton newCircleButton = new JButton("New Circle");
		JButton newRectangleButton = new JButton("New Rectangle");
		JButton removeAllButton = new JButton("Remove");
		JButton paintAllButton = new JButton("Paint");
		JButton printAllDataButton = new JButton("Print Data");
		
		rotatePlusButton.addActionListener(new RotatePlusListener());
		rotateMinusButton.addActionListener(new RotateMinusListener());
		scaleUpButton.addActionListener(new ScaleUpListener());
		scaleDownButton.addActionListener(new ScaleDownListener());
		upButton.addActionListener(new MoveUpListener());
		downButton.addActionListener(new MoveDownListener());
		leftButton.addActionListener(new MoveLeftListener());
		rightButton.addActionListener(new MoveRightListener());
		newPointButton.addActionListener(new NewPointListener());
		newLineButton.addActionListener(new NewLineListener());
		newTriangleButton.addActionListener(new NewTriangleListener());
		newCircleButton.addActionListener(new NewCircleListener());
		newRectangleButton.addActionListener(new NewRectangleListener());
		removeAllButton.addActionListener(new RemoveAllListener());
		paintAllButton.addActionListener(new PaintAllListener());
		printAllDataButton.addActionListener(new PrintAllDataListener());
		
		add(rotatePlusButton);
		add(rotateMinusButton);
		add(scaleUpButton);
		add(scaleDownButton);
		add(leftButton);
		add(upButton);
		add(downButton);
		add(rightButton);
		add(newPointButton);
		add(newLineButton);
		add(newTriangleButton);
		add(newCircleButton);
		add(newRectangleButton);
		add(removeAllButton);
		add(paintAllButton);
		add(printAllDataButton);
		
		dc = new DialogCreator();
	}
	
	// Uppgifter:
	// Skapa metoder som kan anvÃ¤ndas fÃ¶r att tilldela handler-objekt
	// till ControlPanel-instansen.
	
	// Lyssnare-klasser som nedan fÃ¶ljer fÃ¥ngar upp hÃ¤ndelser som genereras
	// nÃ¤r anvÃ¤ndaren trycker pÃ¥ en knapp.
	// I varje actionPerformed-metod mÃ¥ste det finnas ett metodanrop
	// som t.ex. rotateAll eller moveAll. Man mÃ¥ste alltsÃ¥ ha tillgÃ¥ng
	// till objekt som definierar metoderna.
	private class RotatePlusListener implements ActionListener {
		/**
		 * Metoden anropas nÃ¤r 'Rotate+'-knappen aktiveras.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// Rotation 5 grader
			controller.rotateAll(5);
			dp.repaint();
			
			System.out.println("Rotate+");
		}	
	}

	private class RotateMinusListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Rotation -5 grader
			controller.rotateAll(-5);
			dp.repaint();
			
			System.out.println("Rotate-");
		}	
	}

	private class ScaleUpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Skalning, faktor 1.05 i x and y, 
			controller.scaleAll(1.05, 1.05);
			dp.repaint();
			
			System.out.println("Bigger");
		}	
	}

	private class ScaleDownListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Skalning, faktor 0.95 i x and y, 
			controller.scaleAll(0.95, 0.95);
			dp.repaint();
			
			System.out.println("Smaller");
		}	
	}

	private class MoveUpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Flytta i positiv y-riktning med avstÃ¥nd (0.0, 0.5)
			controller.moveAll(0.0, -2.0);
			dp.repaint();
			
			System.out.println("Move Up");
		}	
	}

	private class MoveDownListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Flytta i negativ y-riktning med avstÃ¥nd (0.0, -0.5)
			controller.moveAll(0.0, 2.0);
			dp.repaint();
			
			System.out.println("Move Down");
		}	
	}

	private class MoveLeftListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Flytta i negativ x-riktning med avstÃ¥nd (-0.5, 0.0)
			controller.moveAll(-2.0, 0.0);
			dp.repaint();
			
			System.out.println("Move Left");
		}	
	}

	private class MoveRightListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Flytta i positiv x-riktning med avstÃ¥nd (0.5, 0.0)
			controller.moveAll(2.0, 0.0);
			dp.repaint();
			
			System.out.println("Move Right");
		}	
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
			dp.repaint();
			
			System.out.println("Created A New Point!");
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
			dp.repaint();
			
			System.out.println("Created A New Line!");
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
			dp.repaint();
			
			System.out.println("Created A New Triangle!");
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
			dp.repaint();
			
			System.out.println("Created A New Circle!");
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
			dp.repaint();
			
			System.out.println("Created A New Rectangle!");
		}	
	}
	
	private class RemoveAllListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.removeAll();
			dp.repaint();
			
			System.out.println("Remove All!");
		}	
	}
	
	private class PaintAllListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<Drawable> drawables = new ArrayList<Drawable>();
			
			for(Figure figure : controller.getMovableFigures()) {
				if(figure instanceof Drawable) {
					drawables.add((Drawable) figure);
				}
			}

			dp.setDrawables(drawables);
			dp.repaint();
			
			System.out.println("Paint All!");
		}	
	}
	
	private class PrintAllDataListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.printAll();
			dp.repaint();
			
			System.out.println("Print All Data!");
		}	
	}
	
	private class DialogCreator {
		double createDoubleDialog (String msg) {
			String inValue = null;				// inmatad text
			String error_msg = "";				// felmeddelandet som visas om texten innehÃ¥ller
												// andra tecken Ã¤n bara siffror och en punkt
			double v = 0;
			
			while ((inValue = JOptionPane.showInputDialog (msg + error_msg + ":")) != null) {
				error_msg = "";
				
				/*
				Om texten innehÃ¥ller nÃ¥got annat Ã¤n siffror, sÃ¥ genereras en
				NumberFormatException. Vi vill inte att programmet avslutar
				och fÃ¥ngar den. IstÃ¤llet visas ett felmeddelande fÃ¶r anvÃ¤ndaren.
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
}



















