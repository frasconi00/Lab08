package it.polito.tdp.extflightdelays.model;

public class CoppiaAirport {
	
	private int originAirportId;
	private int destinationAirportId;
	private double distanzaMedia;
	private int numeroVoli;
	
	public CoppiaAirport(int originAirportId, int destinationAirportId, double distanzaMedia, int numeroVoli) {
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.distanzaMedia = distanzaMedia;
		this.numeroVoli = numeroVoli;
	}

	public int getOriginAirportId() {
		return originAirportId;
	}

	public void setOriginAirportId(int originAirportId) {
		this.originAirportId = originAirportId;
	}

	public int getDestinationAirportId() {
		return destinationAirportId;
	}

	public void setDestinationAirportId(int destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}

	public double getDistanzaMedia() {
		return distanzaMedia;
	}

	public void setDistanzaMedia(double distanzaMedia) {
		this.distanzaMedia = distanzaMedia;
	}

	public int getNumeroVoli() {
		return numeroVoli;
	}

	public void setNumeroVoli(int numeroVoli) {
		this.numeroVoli = numeroVoli;
	}

	@Override
	public String toString() {
		return "CoppiaAirport [originAirportId=" + originAirportId + ", destinationAirportId=" + destinationAirportId
				+ ", distanzaMedia=" + distanzaMedia + ", numeroVoli=" + numeroVoli + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destinationAirportId;
		result = prime * result + originAirportId;
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
		CoppiaAirport other = (CoppiaAirport) obj;
		if (destinationAirportId != other.destinationAirportId)
			return false;
		if (originAirportId != other.originAirportId)
			return false;
		return true;
	}
	
	

}
