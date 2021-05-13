package it.polito.tdp.borders.model;

public class Country {
	
	int ccode;
	String stateAbb;
	String stateNme;

	public Country(int ccode, String stateAbb, String stateNme) {
		this.ccode = ccode;
		this.stateAbb = stateAbb;
		this.stateNme = stateNme;
	}

	public int getCcode() {
		return ccode;
	}

	public void setCcode(int ccode) {
		this.ccode = ccode;
	}

	public String getStateAbb() {
		return stateAbb;
	}

	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}

	public String getStateName() {
		return stateNme;
	}

	public void setStateName(String stateName) {
		this.stateNme = stateNme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ccode;
		result = prime * result + ((stateAbb == null) ? 0 : stateAbb.hashCode());
		result = prime * result + ((stateNme == null) ? 0 : stateNme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (ccode != other.ccode)
			return false;
		if (stateAbb == null) {
			if (other.stateAbb != null)
				return false;
		} else if (!stateAbb.equals(other.stateAbb))
			return false;
		if (stateNme == null) {
			if (other.stateNme != null)
				return false;
		} else if (!stateNme.equals(other.stateNme))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return stateNme;
	}
	
	
	
	

}
