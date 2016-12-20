package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

public class TotalDistanceFrame extends JPanel {


	public TotalDistanceFrame(int floors, int steps, double distance) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		JLabel lblName = new JLabel("<html><i>Floors:</i> " + floors + 
				".<br><i>Steps:</i> " + steps + 
				"<br><i>Distance:</i> " + distance + "</html>",
				JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}

}