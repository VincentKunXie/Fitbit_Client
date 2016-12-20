package ca.uwo.csd.cs2212.team10;

/**
 * @author Pearson and Patrick
 * This class will be used to modify and store heart rate statistics
 */
public class HeartStats 
{
	//Heart Rate Variables
	private int outOfRange;
	private int fatBurn;
	private int cardio;
	private int peak;
	private int restHeartRate;
	
	/**
	 * Heart Rate Constructor
	 * @param outOfRange
	 * @param fatBurn
	 * @param cardio
	 * @param peak
	 * @param restHeartRate
	 */
	public HeartStats(int outOfRange, int fatBurn, int cardio, int peak, int restHeartRate) 
	{
		this.outOfRange = outOfRange;
		this.fatBurn = fatBurn;
		this.cardio = cardio;
		this.peak = peak;
		this.restHeartRate = restHeartRate;
		
		System.out.println(toString());
	}

	@Override
	public String toString() 
	{
		return "HeartStats [outOfRange = " + outOfRange + ", fatBurn = " + fatBurn + ", cardio = " 
				+ cardio + ", peak = " + peak + ", restHeartRate = " + restHeartRate + "]";
	}
	
	//Heart rate statistics getters
	public int getOutOfRange() {
		return outOfRange;
	}
	public int getFatBurn() {
		return fatBurn;
	}
	public int getCardio() {
		return cardio;
	}
	public int getPeak() {
		return peak;
	}
	public int getRestHeartRate() {
		return restHeartRate;
	}
}
