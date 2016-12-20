package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

public class SedentaryMinutesFrame extends JPanel {

	public SedentaryMinutesFrame(int sedentaryMins) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +
				"<br>Sedentary Minutes: " + sedentaryMins +  
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
