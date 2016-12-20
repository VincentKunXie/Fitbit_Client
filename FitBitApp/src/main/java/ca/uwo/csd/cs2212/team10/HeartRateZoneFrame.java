package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

public class HeartRateZoneFrame extends JPanel {

	public HeartRateZoneFrame(int fatBurn, int cardio, int peak, int restHeartRate) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +  
				"<br>Fat Burn: " + fatBurn + 
				"<br>Cardio: " + cardio +
				"<br>Peak: " + peak + 
				"<br>Resting HeartRate: " + restHeartRate + 
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
