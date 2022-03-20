package model;

public class Country implements Comparable<Country>{
	
	//--------------------------------------------------------- variables 
	private String name;
	private int goldMaleMedal;
	private int silverMaleMedal;
	private int bronzeMaleMedal;
	private int goldMFeminineMedal;
	private int silverFeminineMedal;
	private int bronzeFeminineMedal;
	
	//--------------------------------------------------------- Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGoldMaleMedal() {
		return goldMaleMedal;
	}
	public void setGoldMaleMedal(int goldMaleMedal) {
		this.goldMaleMedal = goldMaleMedal;
	}
	public int getSilverMaleMedal() {
		return silverMaleMedal;
	}
	public void setSilverMaleMedal(int silverMaleMedal) {
		this.silverMaleMedal = silverMaleMedal;
	}
	public int getBronzeMaleMedal() {
		return bronzeMaleMedal;
	}
	public void setBronzeMaleMedal(int bronzeMaleMedal) {
		this.bronzeMaleMedal = bronzeMaleMedal;
	}
	public int getGoldMFeminineMedal() {
		return goldMFeminineMedal;
	}
	public void setGoldMFeminineMedal(int goldMFeminineMedal) {
		this.goldMFeminineMedal = goldMFeminineMedal;
	}
	public int getSilverFeminineMedal() {
		return silverFeminineMedal;
	}
	public void setSilverFeminineMedal(int silverFeminineMedal) {
		this.silverFeminineMedal = silverFeminineMedal;
	}
	public int getBronzeFeminineMedal() {
		return bronzeFeminineMedal;
	}
	public void setBronzeFeminineMedal(int bronzeFeminineMedal) {
		this.bronzeFeminineMedal = bronzeFeminineMedal;
	}
	
	
	//------------------------------------------------------------------------ Constructor
	public Country(String name, int goldMaleMedal, int silverMaleMedal, int bronzeMaleMedal, int goldMFeminineMedal, int silverFeminineMedal, int bronzeFeminineMedal) {
		this.name = name;
		this.goldMaleMedal = goldMaleMedal;
		this.silverMaleMedal = silverMaleMedal;
		this.bronzeMaleMedal = bronzeMaleMedal;
		this.goldMFeminineMedal = goldMFeminineMedal;
		this.silverFeminineMedal = silverFeminineMedal;
		this.bronzeFeminineMedal = bronzeFeminineMedal;
	}
	
	//------------------------------------------------------------------------ ToString
	public String toString(int a) {
		String info = "";
		switch(a) {
			case 1:
				info += name + " " + goldMaleMedal + " " + silverMaleMedal + " " + bronzeMaleMedal;
			break;
			case 2:
				info += name + " " + goldMFeminineMedal + " " + silverFeminineMedal + " " + bronzeFeminineMedal;
			break;
			default:
				info += name + " " + (goldMaleMedal + goldMFeminineMedal)+ " " + (silverMaleMedal + silverFeminineMedal)
					 + " " + (bronzeMaleMedal + bronzeFeminineMedal);
			break;
		}
		return info;
	}
	
	//------------------------------------------------------------------------ CompareTo
	@Override
	public int compareTo(Country o) {
		Country A = this;
		Country B = o;
		
		int output = A.getGoldMFeminineMedal() - B.getGoldMFeminineMedal();
		
		if(output == 0) {
			output = A.getSilverFeminineMedal() - B.getSilverFeminineMedal();
			if(output == 0) {
				output = A.getBronzeFeminineMedal() - B.getBronzeFeminineMedal();
				if(output == 0) {
					output = B.getName().compareTo(A.getName());
				}
			}
		}	
		return output;
	}

}
