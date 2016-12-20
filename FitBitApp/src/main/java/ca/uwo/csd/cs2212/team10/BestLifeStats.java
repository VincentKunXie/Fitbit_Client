package ca.uwo.csd.cs2212.team10;

/**
 * @author Pearson and Patrick
 * This class will be used to modify and store best statistics 
 */
public class BestLifeStats 
{
	//Best Statistics Variables
	private double bestDistance;
	private String bestDistanceDate;
	private double bestFloor;
	private String bestFloorDate;
	private long bestStep;
	private String bestStepDate;
	
	//Lifetime Statistics Variables
	private double lifeDistance;
	private double lifeFloors;
	private long lifeSteps;
	
	
	/**
	 * Best and Lifetime Constructor
	 * @param bestDistance
	 * @param bestDistanceDate
	 * @param bestFloor
	 * @param bestFloorDate
	 * @param bestStep
	 * @param bestStepDate
	 * @param lifeDistance
	 * @param lifeFloors
	 * @param lifeSteps
	 */
	public BestLifeStats(double bestDistance, String bestDistanceDate, double bestFloor, String bestFloorDate,
			long bestStep, String bestStepDate, double lifeDistance, double lifeFloors, long lifeSteps) 
	{
		this.bestDistance = bestDistance;
		this.bestDistanceDate = bestDistanceDate;
		this.bestFloor = bestFloor;
		this.bestFloorDate = bestFloorDate;
		this.bestStep = bestStep;
		this.bestStepDate = bestStepDate;
		this.lifeDistance = lifeDistance;
		this.lifeFloors = lifeFloors;
		this.lifeSteps = lifeSteps;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() 
	{
		return "BestStats [bestDistance = " + bestDistance + ", bestDistanceDate = " + bestDistanceDate + ", bestFloor = "
				+ bestFloor + ", bestFloorDate = " + bestFloorDate + ", bestStep = " + bestStep + ", bestStepDate = "
				+ bestStepDate + "]" + "\nLifeStats [lifeDistance = " + lifeDistance + ", lifeFloors = " + lifeFloors + ", lifeSteps = "
				+ lifeSteps + "]";
	}

	//Best Statistics Getters
	public double getBestDistance() {
		return bestDistance;
	}
	public String getBestDistanceDate() {
		return bestDistanceDate;
	}
	public double getBestFloor() {
		return bestFloor;
	}
	public String getBestFloorDate() {
		return bestFloorDate;
	}
	public long getBestStep() {
		return bestStep;
	}
	public String getBestStepDate() {
		return bestStepDate;
	}
	
	//Lifetime Statistics Getters
	public double getLifeDistance() {
		return lifeDistance;
	}
	public double getLifeFloors() {
		return lifeFloors;
	}
	public long getLifeSteps() {
		return lifeSteps;
	}
}
