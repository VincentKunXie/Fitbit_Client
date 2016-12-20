package ca.uwo.csd.cs2212.team10;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

import org.json.JSONException; 

public class MainTabWindow extends JPanel {
	
	/**
	 * The main constructor the holds the majority of the UI. 
	 * The constructor is separated into the following sections;
	 * 		Dashboard
	 * 		Dashboard Menu
	 * 		Stats
	 * 		Settings
	 * Each of these sections make their respective content that is housed inside a JTabbedPane container.
	 * 
	 * @throws JSONException
	 * @throws TokensException
	 */
	public MainTabWindow() throws JSONException, TokensException {

		super(new GridLayout(1, 1));

		// Create the API classes and the relevant variables associated with each
		HeartStats heartrate = Fitbit.getHeartActivity("2016", "01", "29");
		int outOfRange = heartrate.getOutOfRange() ;
		int fatBurn = heartrate.getFatBurn() ;
		int cardio = heartrate.getCardio();
		int peak = heartrate.getPeak() ;
		int restHeartRate = heartrate.getRestHeartRate();

		BestLifeStats bestlife=Fitbit.getBestLifeActivity();
		double bestDistance= bestlife. getBestDistance() ;
		String bestDistanceDate= bestlife.getBestDistanceDate();
		double bestFloor = bestlife.getBestFloor();
		String bestFloorDate= bestlife.getBestFloorDate();
		long bestStep= bestlife.getBestStep();
		String bestStepDate= bestlife.getBestStepDate();
		double lifeDistance= bestlife.getLifeDistance() ;
		double lifeFloors= bestlife.getLifeFloors();
		long lifeSteps= bestlife.getLifeSteps();

		DailyStats daily = Fitbit.getDailyActivity("2016", "01", "29");
		int floors = daily. getFloors();
		int steps = daily.getSteps();
		double distance = daily.getDistance();
		int calories = daily.getCalories();
		int sedentaryMins =  daily.getSedentaryMins();
		int lightActiveMins = daily. getLightActiveMins();
		int fairlyActiveMins =daily. getFairlyActiveMins();
		int veryActiveMins = daily. getVeryActiveMins();
		int activeMinGoals = daily. getActiveMinGoals();				 
		int caloriesOutGoals = daily.getCaloriesOutGoals();
		double distanceGoals = daily.getDistanceGoals() ;
		int floorGoals = daily.getFloorGoals();
		int stepGoals = daily.getStepGoals() ;				

		// Investigate. This could possibly be used to set different color themes to the UI
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		//create a tabbed pane that will hold the contents.
		final JTabbedPane tabbedPane = new JTabbedPane();


		/**
		 * Dashboard
		 */


		JComponent panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());

		// A top menu bar that appears when the user first uses the Dashboard Menu
		//		Expand options here in the future. For example; the refresh button
		final JMenuBar desktopMenuBar = new JMenuBar();
		desktopMenuBar.setBackground(new Color(100, 100, 100));
		desktopMenuBar.setBorderPainted(false);
		// Add the button that will lead the user to the Dashboard Menu to add elements
		final JButton btnadd = new JButton("+ Add elements to get started"); 
		btnadd.setBackground(new Color(150, 150, 150));
		btnadd.setBorderPainted(true);
		

		// Add the action
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		desktopMenuBar.add(Box.createHorizontalGlue());
		desktopMenuBar.add(btnadd);
		// Add the menu bar
		panel1.add(desktopMenuBar, BorderLayout.NORTH);


		/* 
		//add a panel that we the elements are going to be added on 
		final JPanel panelback1 = new JPanel();
		panelback1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelback1.setBackground(new Color(40, 40, 40));
		panelback1.setForeground(new Color(40, 40, 40));
		panelback1.setBounds(0, 0, 1128, 644);
		panel1.add(panelback1, BorderLayout.WEST);
		panelback1.setLayout(null);
		 */

		// Adding the JDesktopPane into the "Dashboard" Panel
		JDesktopPane desktop = new JDesktopPane();
		desktop.setPreferredSize( new java.awt.Dimension(600,400) );
		desktop.setBackground(new Color(40, 40, 40));

		// Put the +Add elements to the top of the desktopPane

		/* Elements needed:
		 * 	Map
		 *  HeartRate Zone
		 *  Calories Burned
		 *  Daily Activity Records //
		 *  Sedentary Minutes      //
		 */
		// The Total Distance element 
		final JInternalFrame mapFrame = makeInternalFrame("Interactive Map", 
				0, 0, 200, 200, false, true, true);
		MapFrame mapContent = new MapFrame(bestDistance, bestDistanceDate, lifeDistance);
		mapFrame.add( mapContent);
		desktop.add( mapFrame );

		// The Floors Climbed element
		final JInternalFrame heartRateFrame = makeInternalFrame("Heart Rate Zone", 
				200, 0, 200, 200, false, true, true);
		HeartRateZoneFrame heartRateContent = new HeartRateZoneFrame(fatBurn, cardio, peak, restHeartRate);
		heartRateFrame.add(heartRateContent);
		desktop.add( heartRateFrame );

		// The Steps Taken Element
		final JInternalFrame calBurnFrame = makeInternalFrame("Calories Burned", 
				400, 0, 200, 200, false, true, true);
		CaloriesBurnedFrame calBurnContent = new CaloriesBurnedFrame(calories, caloriesOutGoals);
		calBurnFrame.add(calBurnContent);
		desktop.add( calBurnFrame );


		// The Active Minutes element
		final JInternalFrame activeMinFrame = makeInternalFrame("Active Minutes", 
				600, 0, 200, 200, false, true, true);
		ActiveMinutesFrame activeMinContent = new ActiveMinutesFrame(lightActiveMins, fairlyActiveMins, veryActiveMins, activeMinGoals);
		activeMinFrame.add(activeMinContent);
		desktop.add( activeMinFrame );

		// The Sedentary Minutes element
		final JInternalFrame sedMinFrame = makeInternalFrame("Sedentary Minutes", 
				800, 0, 200, 200, false, true, true);
		SedentaryMinutesFrame sedMinContent = new SedentaryMinutesFrame(sedentaryMins); 
		sedMinFrame.add(sedMinContent);
		desktop.add( sedMinFrame );

		panel1.add(desktop);

		//add the the panel to the tabbed pane
		ImageIcon icon1 = new ImageIcon("home_icon.png");
		tabbedPane.addTab("Dashboard",icon1 , panel1, "tmp1"); // Add the desktop pane to the tabbedPane
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setBackgroundAt(0, Color.WHITE);

		/**
		 * Dashboard Menu
		 */
		JComponent panel2 = makeTextPanel("Dashboard Menu");
		//create a label named dashboard menu and add it to the panel

		JLabel lblmenu = new JLabel("Dashboard Menu");
		lblmenu.setForeground(SystemColor.inactiveCaption);
		lblmenu.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblmenu.setBounds(44, 6, 543, 72);
		panel2.add(lblmenu);
		//add a scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(40, 40, 40));
		scrollPane.setForeground(new Color(40, 40, 40));
		scrollPane.setBounds(18, 77, 1110, 567);

		panel2.add(scrollPane);
		//add a panel on top of the scroll pane to add the elements easier
		JPanel panelscroll = new JPanel();
		panelscroll.setBounds(79, 100, 945, 300);
		panelscroll.setBackground(new Color(40, 40, 40));
		panelscroll.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		scrollPane.setViewportView(panelscroll);

		// Interactive Map description and button add
		JLabel mapDescript = new JLabel("");
		mapDescript.setText("<html>An interactive map that displays the places that you have visited based on the total number of steps taken.</html>");
		mapDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		mapDescript.setForeground(Color.LIGHT_GRAY);
		mapDescript.setBounds(30, 80, 328, 93);	//In the future, make this non-static positions
		panelscroll.add(mapDescript);
		//add a check box for map
		final JCheckBox chckbxMap_1 = new JCheckBox("Map"); 
		chckbxMap_1.setBounds(60, 180, 128, 23);
		chckbxMap_1.setBackground(new Color(40, 40, 40));
		chckbxMap_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopMenuBar.setVisible(chckbxMap_1.isSelected()==false);
				mapFrame.setVisible(chckbxMap_1.isSelected());

			}
		});
		panelscroll.setLayout(null);
		chckbxMap_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		chckbxMap_1.setForeground(Color.WHITE);

		panelscroll.add(chckbxMap_1);

		/* TMP - commented out since the time series is not needed as of 2016.03.01
		// Time Series description and button add 
		JLabel tsDescript = new JLabel("");
		tsDescript.setText("<html>The Time Series displays <BR>the information for all your <BR>accumulated progress,data like: <BR>total steps,calories,distance,<BR>and heart rate.</html>");
		tsDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		tsDescript.setForeground(Color.LIGHT_GRAY);
		tsDescript.setBounds(430, 120, 728, 93);
		panelscroll.add(tsDescript);
		//add a check box for time series
		final JCheckBox chckbxTimeSeries = new JCheckBox("Time Series");
		chckbxTimeSeries.setBounds(460, 220, 128, 23);
		chckbxTimeSeries.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		chckbxTimeSeries.setForeground(Color.WHITE);
		chckbxTimeSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnadd.setVisible(chckbxTimeSeries.isSelected()==false);
				//timeSeriesPanel.setVisible(chckbxTimeSeries.isSelected());

			}
		});
		panelscroll.add(chckbxTimeSeries);
		 */

		// Heart Rate Zone description and button add
		JLabel hrDescript = new JLabel("");
		hrDescript.setText("<html>The Heart Rate displays <BR> your daily heart zone <BR>information and resting <BR>heart rate.</html>");
		hrDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		hrDescript.setForeground(Color.LIGHT_GRAY);
		hrDescript.setBounds(850, 80, 728, 93);
		panelscroll.add(hrDescript);
		//add a check box for heart rate
		final JCheckBox chckbxHeartRate = new JCheckBox("Heart Rate");
		chckbxHeartRate.setBounds(900, 180, 128, 23);
		chckbxHeartRate.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		chckbxHeartRate.setForeground(Color.WHITE);
		chckbxHeartRate.setBackground(new Color(40, 40, 40));
		chckbxHeartRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopMenuBar.setVisible(chckbxHeartRate.isSelected()==false);
				heartRateFrame.setVisible(chckbxHeartRate.isSelected());
			}
		});
		panelscroll.add(chckbxHeartRate);

		// Calorie Zone description and button add
		JLabel cbDescript = new JLabel("");
		cbDescript.setText("<html>The Calories Burned displays <BR>that amount of calories <BR>you burned</html>");
		cbDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		cbDescript.setForeground(Color.LIGHT_GRAY);
		cbDescript.setBounds(30, 320, 728, 93);
		panelscroll.add(cbDescript);

		final JCheckBox caloriesBurned = new JCheckBox("Calories Burned");
		caloriesBurned.setBounds(60, 430, 157, 23);
		caloriesBurned.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		caloriesBurned.setForeground(Color.WHITE);
		caloriesBurned.setBackground(new Color(40, 40, 40));
		caloriesBurned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopMenuBar.setVisible(caloriesBurned.isSelected()==false);
				calBurnFrame.setVisible(caloriesBurned.isSelected());
			}
		});
		panelscroll.add(caloriesBurned);

		// Sedentary Minutes description and button add
		JLabel smDescript = new JLabel("");
		smDescript.setText("<html>The Sedentary Min displays <BR> the time you are <BR>not in active state.</html>");
		smDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		smDescript.setForeground(Color.LIGHT_GRAY);
		smDescript.setBounds(430, 80, 728, 93);
		panelscroll.add(smDescript);

		final JCheckBox sedMin = new JCheckBox("Sedentary Min");
		sedMin.setBounds(460, 180, 168, 23);
		sedMin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		sedMin.setForeground(Color.WHITE);
		sedMin.setBackground(new Color(40, 40, 40));
		sedMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopMenuBar.setVisible(sedMin.isSelected()==false);
				sedMinFrame.setVisible(sedMin.isSelected());
			}
		});
		panelscroll.add(sedMin);

		// Active Minutes description and button add
		JLabel daDescript = new JLabel("");
		daDescript.setText("<html>The Daily Activity <BR>records your daily <BR> activity and progress<BR> you worked with FitBit.</html>");
		daDescript.setFont(new Font ("Courier New",Font.BOLD,16));
		daDescript.setForeground(Color.LIGHT_GRAY);
		daDescript.setBounds(860, 320, 728, 93);
		panelscroll.add(daDescript);

		final JCheckBox dailyAct = new JCheckBox("Daily Activity");
		dailyAct.setBounds(900, 430, 157, 23);
		dailyAct.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		dailyAct.setForeground(Color.WHITE);
		dailyAct.setBackground(new Color(40, 40, 40));
		dailyAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopMenuBar.setVisible(chckbxHeartRate.isSelected()==false);
				activeMinFrame.setVisible(dailyAct.isSelected());
			}
		});
		panelscroll.add(dailyAct);


		//add the panel to the tabbed pane
		ImageIcon icon2 = new ImageIcon("options_icon.png");
		tabbedPane.addTab("Menu", icon2, panel2, "tmp2");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		tabbedPane.setBackgroundAt(1, Color.WHITE);



		/**
		 * Stats page
		 */
		//create a panel and add it to the tabbed pane
		ImageIcon icon3 = new ImageIcon("stats_icon.png");
		JComponent panel3 = makeTextPanel("Stats");
		tabbedPane.addTab("Stats", icon3, panel3, "tmp3");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		panel3.setPreferredSize(new Dimension(410, 50));

		//panel of the life time button
		final JPanel panelLifeTime = new JPanel();
		panelLifeTime.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelLifeTime.setBackground(new Color(40, 40, 40));
		panelLifeTime.setForeground(new Color(40, 40, 40));
		panelLifeTime.setBounds(150, 6, 1000, 639);
		panel3.add(panelLifeTime, BorderLayout.CENTER);
		panelLifeTime.setLayout(null);
		JLabel lblLifetime = new JLabel("Lifetime Totals");
		lblLifetime.setForeground(SystemColor.inactiveCaption);
		lblLifetime.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblLifetime.setBounds(44, 6, 382, 72);

		JLabel distancelifetime= new JLabel("Distance");
		distancelifetime.setForeground(Color.WHITE);
		distancelifetime.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		distancelifetime.setBounds(60, 65, 382, 72);
		panelLifeTime.add(distancelifetime);

		JLabel lifetimeDistance= new JLabel("Total distance Travelled:"+ Double.toString(lifeDistance));
		lifetimeDistance.setForeground(Color.WHITE);
		lifetimeDistance.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lifetimeDistance.setBounds(90, 95, 382, 72);
		panelLifeTime.add(lifetimeDistance);

		JLabel floorsTitleLifetime= new JLabel("Floors");
		floorsTitleLifetime.setForeground(Color.WHITE);
		floorsTitleLifetime.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		floorsTitleLifetime.setBounds(60, 180, 382, 72);
		panelLifeTime.add(floorsTitleLifetime);

		JLabel totalFloorsLifeTime= new JLabel("Total Floors Climbed: "+lifeFloors);
		totalFloorsLifeTime.setForeground(Color.WHITE);
		totalFloorsLifeTime.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		totalFloorsLifeTime.setBounds(90, 210, 382, 72);
		panelLifeTime.add(totalFloorsLifeTime);

		JLabel lifeTimestepsTitle= new JLabel("Steps");
		lifeTimestepsTitle.setForeground(Color.WHITE);
		lifeTimestepsTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lifeTimestepsTitle.setBounds(60, 295, 382, 72);
		panelLifeTime.add(lifeTimestepsTitle);

		JLabel lifeTimeStepsTotal= new JLabel("Total Steps taken: ");//+ lifeSteps);
		lifeTimeStepsTotal.setForeground(Color.WHITE);
		lifeTimeStepsTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lifeTimeStepsTotal.setBounds(90, 325, 382, 72);
		panelLifeTime.add(lifeTimeStepsTotal);
		panelLifeTime.add(lblLifetime);

		//panel of the best days button
		final JPanel panelBestDays = new JPanel();
		panelBestDays.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelBestDays.setBackground(new Color(40, 40, 40));
		panelBestDays.setForeground(new Color(40, 40, 40));
		panelBestDays.setBounds(150, 6, 1000, 639);
		panel3.add(panelBestDays, BorderLayout.CENTER);
		panelBestDays.setLayout(null);

		//these are the labels for the best days we're gonna add the test data when we write the data... I know how to do that i still didn't add it because it doesn't run it on my elcipse but it works	
		JLabel lblBestDays= new JLabel("Best Days");
		lblBestDays.setForeground(SystemColor.inactiveCaption);
		lblBestDays.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblBestDays.setBounds(44, 6, 382, 72);
		panelBestDays.add(lblBestDays);

		JLabel distance2= new JLabel("Distance");
		distance2.setForeground(Color.WHITE);
		distance2.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		distance2.setBounds(60, 65, 382, 72);
		panelBestDays.add(distance2);

		JLabel bestDistancedate= new JLabel("Best Day: "+bestDistanceDate);
		bestDistancedate.setForeground(Color.WHITE);
		bestDistancedate.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		bestDistancedate.setBounds(90, 95, 382, 72);
		panelBestDays.add(bestDistancedate);

		JLabel bestDistance1= new JLabel("Best Distance: "+ bestDistance);
		bestDistance1.setForeground(Color.WHITE);
		bestDistance1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		bestDistance1.setBounds(110, 130, 382, 72);
		panelBestDays.add(bestDistance1);



		JLabel bestFloorstitle= new JLabel("Floors");
		bestFloorstitle.setForeground(Color.WHITE);
		bestFloorstitle.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		bestFloorstitle.setBounds(60, 180, 382, 72);
		panelBestDays.add(bestFloorstitle);

		JLabel bestFloorDtlbl= new JLabel("Best Floor Date: "+bestFloorDate);
		bestFloorDtlbl.setForeground(Color.WHITE);
		bestFloorDtlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		bestFloorDtlbl.setBounds(90, 210, 382, 72);
		panelBestDays.add(bestFloorDtlbl);

		JLabel bestfloorlbl= new JLabel("Best Floor: "+bestFloor);
		bestfloorlbl.setForeground(Color.WHITE);
		bestfloorlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		bestfloorlbl.setBounds(110, 245, 382, 72);
		panelBestDays.add(bestfloorlbl);




		JLabel bestStepstitle= new JLabel("Steps");
		bestStepstitle.setForeground(Color.WHITE);
		bestStepstitle.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		bestStepstitle.setBounds(60, 295, 382, 72);
		panelBestDays.add(bestStepstitle);

		JLabel bestStepsDtlbl= new JLabel("Best Steps Date: "+ bestStepDate);
		bestStepsDtlbl.setForeground(Color.WHITE);
		bestStepsDtlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		bestStepsDtlbl.setBounds(90, 325, 382, 72);
		panelBestDays.add(bestStepsDtlbl);

		JLabel bestStepslbl= new JLabel("Best Steps: "+ bestStep);
		bestStepslbl.setForeground(Color.WHITE);
		bestStepslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		bestStepslbl.setBounds(110, 360, 382, 72);
		panelBestDays.add(bestStepslbl);




		//panel of the accolades button
		final JPanel panelAccolades = new JPanel();
		panelAccolades.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelAccolades.setBackground(new Color(40, 40, 40));
		panelAccolades.setForeground(new Color(40, 40, 40));
		panelAccolades.setBounds(150, 6, 1000, 639);
		panel3.add(panelAccolades, BorderLayout.CENTER);
		panelAccolades.setLayout(null);
		JLabel lblAccolades= new JLabel("Accolades");
		lblAccolades.setForeground(SystemColor.inactiveCaption);
		lblAccolades.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblAccolades.setBounds(44, 6, 382, 72);
		panelAccolades.add(lblAccolades);

		//panel where the buttons are added 
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setForeground(new Color(40, 40, 40));
		panel_1.setBounds(6, 6, 118, 583);
		panel3.add(panel_1, BorderLayout.CENTER);
		panel3.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//add button lifetime toals 
		JToggleButton tglbtnNewToggleButton;
		JToggleButton tglbtnNewToggleButton_1;
		JToggleButton tglbtnAccolades;
		final ButtonGroup buttonGroupobj = new ButtonGroup();
		tglbtnNewToggleButton = new JToggleButton("Lifetime Totals   ");
		tglbtnNewToggleButton.setSelected(true);
		//show the lifetime total panel  and hide the rest
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelBestDays.setVisible(false);
				panelAccolades.setVisible(false);
				panelLifeTime.setVisible(true);

			}
		});
		panel_1.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setBackground(new Color(55,55,55));
		tglbtnNewToggleButton.setOpaque(true);	
		buttonGroupobj.add(tglbtnNewToggleButton);

		//add button Best days
		tglbtnNewToggleButton_1 = new JToggleButton("Best Days           ");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			//show the best days panel  and hide the rest
			public void actionPerformed(ActionEvent e) {

				panelBestDays.setVisible(true);
				panelAccolades.setVisible(true);
				panelLifeTime.setVisible(false);

			}
		});
		tglbtnNewToggleButton_1.setBackground(new Color(55,55,55));
		tglbtnNewToggleButton_1.setOpaque(true);	
		panel_1.add(tglbtnNewToggleButton_1);
		buttonGroupobj.add(tglbtnNewToggleButton_1);

		//add button Accolades
		tglbtnAccolades = new JToggleButton("Accolades          ");
		panel_1.add(tglbtnAccolades);
		tglbtnAccolades.setBackground(new Color(55,55,55));
		//show the Accolades panel  and hide the rest
		tglbtnAccolades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelBestDays.setVisible(false);
				panelAccolades.setVisible(true);
				panelLifeTime.setVisible(false);

			}
		});
		tglbtnAccolades.setOpaque(true);	
		buttonGroupobj.add(tglbtnAccolades);


		//Add a vertical Glue so the Settings option is at the bottom of the tab bar on the left
		//	Figure out how to do this
		//

		/**
		 * settings
		 * 
		 */
		//create a settings panel
		JComponent panel4 = makeTextPanel( "Settings");
		// create the label settings on tpo
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setForeground(SystemColor.inactiveCaption);
		lblSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		lblSettings.setBounds(44, 6, 257, 72);
		panel4.add(lblSettings); 
		//create the units  label
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblUnits.setForeground(SystemColor.inactiveCaption);
		lblUnits.setBounds(101, 95, 61, 16);
		panel4.add(lblUnits);	

		//create the time format label
		JLabel lblTimeFormat = new JLabel("Time format");
		lblTimeFormat.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblTimeFormat.setForeground(SystemColor.inactiveCaption);
		lblTimeFormat.setBounds(101, 147, 118, 16);
		panel4.add(lblTimeFormat);
		//create the data format label 

		JLabel lblDateFormat = new JLabel("Date format");
		lblDateFormat.setForeground(SystemColor.inactiveCaption);
		lblDateFormat.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblDateFormat.setBounds(101, 195, 118, 16);
		panel4.add(lblDateFormat);

		//create the Languages label
		JLabel lblLanguages = new JLabel("Languages");
		lblLanguages.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblLanguages.setForeground(SystemColor.inactiveCaption);
		lblLanguages.setBounds(101, 232, 118, 33);
		panel4.add(lblLanguages);
		//create the Pages label
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblPages.setForeground(SystemColor.inactiveCaption);
		lblPages.setBounds(101, 274, 93, 35);
		panel4.add(lblPages);
		//add a comboBox for the dateformat
		String[] dateformat= {"dd/mm/yyyy","mm/dd/yyyy"};
		JComboBox comboBox = new JComboBox(dateformat);
		comboBox.setBounds(262, 195, 140, 27);
		panel4.add(comboBox);

		//add a comboBox for the langauges

		String[] language= {"English","French"};
		JComboBox comboBox_1 = new JComboBox(language);
		comboBox_1.setBounds(262, 235, 140, 27);
		panel4.add(comboBox_1);
		//add a checkbox for pages
		final JCheckBox chckbxTimeSeriesData = new JCheckBox("Time series data");
		chckbxTimeSeriesData.setForeground(Color.WHITE);
		chckbxTimeSeriesData.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxTimeSeriesData.setBounds(262, 274, 177, 23);
		panel4.add(chckbxTimeSeriesData);

		final JCheckBox chckbxHeartRateZones = new JCheckBox("Heart rate zones");
		chckbxHeartRateZones.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxHeartRateZones.setForeground(Color.WHITE);
		chckbxHeartRateZones.setBounds(262, 310, 177, 23);
		panel4.add(chckbxHeartRateZones);

		final JCheckBox chckbxMap = new JCheckBox("Map");
		chckbxMap.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxMap.setForeground(Color.WHITE);
		chckbxMap.setBounds(262, 346, 128, 23);
		panel4.add(chckbxMap);

		final JCheckBox chckbxDailyGoals = new JCheckBox("Daily Goals");
		chckbxDailyGoals.setForeground(Color.WHITE);
		chckbxDailyGoals.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		chckbxDailyGoals.setBounds(262,380, 155, 23);
		panel4.add(chckbxDailyGoals);
		//add a radiobutton for the units
		JRadioButton rdbtnMetric = new JRadioButton("Metric");
		ButtonGroup buttonGroup = new ButtonGroup();
		ButtonGroup buttonGroup_1 = new ButtonGroup();
		buttonGroup.add(rdbtnMetric);
		rdbtnMetric.setSelected(true);
		rdbtnMetric.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnMetric.setForeground(Color.WHITE);
		rdbtnMetric.setBounds(262, 95, 141, 23);
		panel4.add(rdbtnMetric);

		//add a radiobutton for the time format
		JRadioButton rdbtnhourClock = new JRadioButton("12-hour clock");
		buttonGroup_1.add(rdbtnhourClock);
		rdbtnhourClock.setSelected(true);
		rdbtnhourClock.setForeground(Color.WHITE);
		rdbtnhourClock.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnhourClock.setBounds(262, 147, 155, 23);
		panel4.add(rdbtnhourClock);

		//add a radiobutton for the time format
		JRadioButton rdbtnhourClock_1 = new JRadioButton("24-hour clock");
		buttonGroup_1.add(rdbtnhourClock_1);
		rdbtnhourClock_1.setForeground(Color.WHITE);
		rdbtnhourClock_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnhourClock_1.setBounds(460, 147, 177, 23);
		panel4.add(rdbtnhourClock_1);

		//add a radiobutton for the units
		JRadioButton rdbtnImperial = new JRadioButton("Imperial");
		buttonGroup.add(rdbtnImperial);
		rdbtnImperial.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		rdbtnImperial.setForeground(Color.WHITE);
		rdbtnImperial.setBounds(460, 95, 141, 23);
		panel4 .add(rdbtnImperial);
		final JPanel panelback = new JPanel();
		panelback.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(35, 35, 35)));
		panelback.setBackground(new Color(40, 40, 40));
		panelback.setForeground(new Color(40, 40, 40));
		panelback.setBounds(18, 77, 1110, 567);
		panel4.add(panelback, BorderLayout.WEST);

		panel4.setPreferredSize(new Dimension(410, 50));

		ImageIcon icon = new ImageIcon("settings_icon.png");
		tabbedPane.addTab("Settings", icon, panel4, "tmp4");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_3);

		tabbedPane.setBackgroundAt(3, Color.WHITE);

		// PLace the tab to the left
		tabbedPane.setTabPlacement(tabbedPane.LEFT);

		//The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		// Set the Attributes
		tabbedPane.setOpaque(true);

		//tabbedPane.setForeground(Color.WHITE);	Discuss the colors we want with the tabs
		tabbedPane.setBackground(new Color(70,70,70));

		//Add the tabbed pane to this panel.
		this.add(tabbedPane);
	}
	/**
	 * a method that will create  panel 
	 * @param text
	 * @return
	 */
	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setBackground(new Color (55,55,55));
		panel.setLayout(null);
		return panel;
	}

	/**
	 * A Method that will make the JInternalFrames (ie- the elements in the Dashboard)
	 * The parameters will dictate that frames initial values, who will change as the 
	 * navigates the app.
	 * @param title
	 * @param locationX
	 * @param locationY
	 * @param sizeX
	 * @param sizeY
	 * @param boolVisible
	 * @param boolResize
	 * @param boolIcon		Whether or not it can be set to the bottom of the screen
	 * @return The internalFrame created
	 */
	private JInternalFrame makeInternalFrame(String title, int locationX, int locationY, int sizeX, int sizeY, 
			boolean boolVisible, boolean boolResize, boolean boolIcon) {
		JInternalFrame iFrame = new JInternalFrame(title);
		iFrame.setLocation( locationX, locationY );
		iFrame.setSize( sizeX, sizeY );
		iFrame.setVisible( boolVisible );
		iFrame.setResizable( boolResize );
		iFrame.setIconifiable( boolIcon );

		return iFrame;
	}

}