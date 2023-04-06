package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{
	String tempo;
	String terrain;

	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
		super(n, d, m, y, h, min, s, dist);
		
		this.terrain = terrain;
		this.tempo = tempo;
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the terrain
	 */
	public String getTerrain() {
		return terrain;
	}
	/**
	 * @return the tempo
	 */
	public String getTempo() {
		return tempo;
	}
	@Override
	public String getEntry () {
		   String result = getName()+" cycled " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear() + " on "
		             +getTerrain()+ " at " +getTempo()+ " tempo" + "\n";
		   return result;
		  }
	


}
