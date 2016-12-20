package ca.uwo.csd.cs2212.team10;

import javax.swing.SwingUtilities;

import org.json.JSONException;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override

			public void run() {
				MainWindow window = null;
				try {
					window = new MainWindow();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TokensException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.setVisible(true);
			}
		});
	}
}
