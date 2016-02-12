package com.systemintegration.beans;

public class CodeVO {
	private String Hex,quawk,radarType,planetType,flugeugId;
	private double latitude,longitude;
	private int track, altitude,date;
	private float speed;
	
	
	
	
	
	
	public CodeVO(String hex,double latitude,double longitude,int track,
			int altitude,float speed,String quawk, String radarType,
			String planetType, String flugeugId,
			   int date) {
		super();
		Hex = hex;
		this.quawk = quawk;
		this.radarType = radarType;
		this.planetType = planetType;
		this.flugeugId = flugeugId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.track = track;
		this.altitude = altitude;
		this.date = date;
		this.speed = speed;
	}

	
	
	
	
	
	/**
	 * @return the hex
	 */
	public String getHex() {
		return Hex;
	}

	/**
	 * @param hex the hex to set
	 */
	public void setHex(String hex) {
		Hex = hex;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the track
	 */
	public int getTrack() {
		return track;
	}

	/**
	 * @param track the track to set
	 */
	public void setTrack(int track) {
		this.track = track;
	}

	/**
	 * @return the altitude
	 */
	public int getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the quawk
	 */
	public String getQuawk() {
		return quawk;
	}

	/**
	 * @param quawk the quawk to set
	 */
	public void setQuawk(String quawk) {
		this.quawk = quawk;
	}

	/**
	 * @return the radarType
	 */
	public String getRadarType() {
		return radarType;
	}

	/**
	 * @param radarType the radarType to set
	 */
	public void setRadarType(String radarType) {
		this.radarType = radarType;
	}

	/**
	 * @return the flugeugId
	 */
	public String getFlugeugId() {
		return flugeugId;
	}

	/**
	 * @param flugeugId the flugeugId to set
	 */
	public void setFlugeugId(String flugeugId) {
		this.flugeugId = flugeugId;
	}

	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * @return the planetType
	 */
	public String getPlanetType() {
		return planetType;
	}

	/**
	 * @param planetType the planetType to set
	 */
	public void setPlanetType(String planetType) {
		this.planetType = planetType;
	}


	
}
