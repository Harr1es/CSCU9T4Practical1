package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
	int repetitions;
	int recovery;
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int reps, int rec) {
		super(n, d, m, y, h, min, s, dist);
		
		this.repetitions = reps;
		this.recovery = rec;
		// TODO Auto-generated constructor stub
	}
	public int getRepetitions() {
		return repetitions;
	}
	/**
	 * @return the recovery
	 */
	public int getRecovery() {
		return recovery;
	}
	@Override 
	public String getEntry () {
		   String result = getName()+" sprinted " + getRepetitions()
		   			 + "x" +(int)getDistance() + "m in " +
		             +getHour()+":"+getMin()+":"+ getSec() + " with " + getRecovery() + 
		             " minutes recovery on " +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getEntry

	

}
