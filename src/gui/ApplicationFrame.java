/*
 * OODP, laboration 3
 *
 * ControlPanel.java
 *
 * Peter Jenke, 2015-01-10
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame
{
	DrawingPanel drawingPanel;
	
	public ApplicationFrame (String title) throws HeadlessException
	{
		super (title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize (new Dimension (1065, 600));

		// mainPanel innehåller
		// - DrawingPanel - en JPanel där figurerna ritas ut
		// - ControlPanel - en JPanel som innehåller styrelementen
		JPanel mainPanel = new JPanel ();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel);

		drawingPanel = new DrawingPanel();
		
		ControlPanel controlPanel = new ControlPanel(drawingPanel);
		
		mainPanel.add(drawingPanel, BorderLayout.CENTER);
		mainPanel.add(controlPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}
	
	// Uppgifter:
	// Skapa metoder som kan användas för att tilldela handler-objekt
	// till ControlPanel-instansen.
}
