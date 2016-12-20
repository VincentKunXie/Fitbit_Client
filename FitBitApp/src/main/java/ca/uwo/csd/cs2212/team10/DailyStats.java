package ca.uwo.csd.cs2212.team10;

/**
 * @author Pearson and Patrick
 * This class will be used to modify and store daily statistics 
 */
public class DailyStats 
{
		//Daily Statistics Variables
		private int floors;
		private int steps;
		private double distance;
		private int calories;
		private int sedentaryMins;
		private int lightActiveMins;
		private int fairlyActiveMins;
		private int veryActiveMins;
		
		//Goal Statistics Variables
		private int activeMinGoals;
		private int caloriesOutGoals;
		private double distanceGoals;
		private int floorGoals;
		private int stepGoals;

		/**
		 * Daily and Goal Constructor
		 * @param floors
		 * @param steps
		 * @param distance
		 * @param calories
		 * @param sedentaryMins
		 * @param lightActiveMins
		 * @param fairlyActiveMins
		 * @param veryActiveMins
		 * @param activeMinGoals
		 * @param caloriesOutGoals
		 * @param distanceGoals
		 * @param floorGoals
		 * @param stepGoals
		 */
		public DailyStats(int floors, int steps, double distance, int calories, int sedentaryMins, int lightActiveMins, int fairlyActiveMins,
				int veryActiveMins, int activeMinGoals, int caloriesOutGoals, double distanceGoals, int floorGoals, int stepGoals) 
		{
			this.floors = floors;
			this.steps = steps;
			this.distance = distance;
			this.calories = calories;
			this.sedentaryMins = sedentaryMins;
			this.lightActiveMins = lightActiveMins;
			this.fairlyActiveMins = fairlyActiveMins;
			this.veryActiveMins = veryActiveMins;
			this.activeMinGoals = activeMinGoals;
			this.caloriesOutGoals = caloriesOutGoals;
			this.distanceGoals = distanceGoals;
			this.floorGoals = floorGoals;
			this.stepGoals = stepGoals;
			
			System.out.println(toString());
		}
		
		@Override
		public String toString() {
			return "DailyStats [floors = " + floors + ", steps = " + steps + ", distance = " + distance + ", calories = " + calories
					+ ", sedentaryMins = " + sedentaryMins + ", lightActiveMins = "	+ lightActiveMins + ", fairlyActiveMins = "
					+ fairlyActiveMins + ", veryActiveMins = " + veryActiveMins + "]" + "\nGoalStats [activeMinGoals = " + activeMinGoals
					+ ", caloriesOutGoals = " + caloriesOutGoals + ", distanceGoals = " + distanceGoals + ", floorGoals = "
					+ floorGoals + ", stepGoals = " + stepGoals + "]";
		}

		//Daily Statistics Getters
		public int getFloors() {
			return floors;
		}
		public int getSteps() {
			return steps;
		}
		public double getDistance() {
			return distance;
		}
		public int getCalories() {
			return calories;
		}
		public int getSedentaryMins() {
			return sedentaryMins;
		}
		public int getLightActiveMins() {
			return lightActiveMins;
		}
		public int getFairlyActiveMins() {
			return fairlyActiveMins;
		}
		public int getVeryActiveMins() {
			return veryActiveMins;
		}
		
		//Goal Statistics Getters
		public int getActiveMinGoals() {
			return activeMinGoals;
		}
		public int getCaloriesOutGoals() {
			return caloriesOutGoals;
		}
		public double getDistanceGoals() {
			return distanceGoals;
		}
		public int getFloorGoals() {
			return floorGoals;
		}
		public int getStepGoals() {
			return stepGoals;
		}
}
