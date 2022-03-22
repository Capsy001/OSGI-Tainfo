package models;

public class Train {

	int TID;
	char[] facility;	//A-Air conditioned, B-Adjustable seats, C-Refreshments, N-none
	char crowd;			//L low, N normal, C crowded
	String origin;
	String dest;
	char type;			//E express, S slow, N normal
	
	
	public int getTID() {
		return TID;
	}


	public void setTID(int tID) {
		TID = tID;
	}


	public char[] getFacility() {
		return facility;
	}


	public void setFacility(char[] facility) {
		this.facility = facility;
	}


	public char getCrowd() {
		return crowd;
	}


	public void setCrowd(char crowd) {
		this.crowd = crowd;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDest() {
		return dest;
	}


	public void setDest(String dest) {
		this.dest = dest;
	}


	public char getType() {
		return type;
	}


	public void setType(char type) {
		this.type = type;
	}


	public Train(int tID, char[] facility, char crowd, String origin, String dest, char type) {
		super();
		TID = tID;
		this.facility = facility;
		this.crowd = crowd;
		this.origin = origin;
		this.dest = dest;
		this.type = type;
	}
}
