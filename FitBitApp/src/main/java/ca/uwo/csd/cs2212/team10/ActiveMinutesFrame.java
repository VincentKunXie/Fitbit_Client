package ca.uwo.csd.cs2212.team10;

import javax.swing.*;

import java.awt.*;

public class ActiveMinutesFrame extends JPanel {

	public ActiveMinutesFrame(int lightActiveMins, int fairlyActiveMins, int veryActiveMins, int activeMinGoals) {
		// Change GridLayout to better organize the panel
		super(new GridLayout(1, 1));
		
		// JLabels to print the text for the testFitBitAPI
		String stringLabel = "<html>" +
				"<u>Active Minutes</u>" +
				"<br>Light: " + lightActiveMins + 
				"<br>Fairly: " + fairlyActiveMins +
				"<br>Very: " + veryActiveMins + 
				"<br><br>Goals: " + activeMinGoals + 
				"</html>";
		JLabel lblName = new JLabel(stringLabel, JLabel.CENTER);
		
		lblName.setOpaque(false);	
		lblName.setToolTipText("tmp");
		this.setBackground(new Color(150, 150, 150));
		
		
		//this.add(content);
		this.add(lblName);
	}
}
