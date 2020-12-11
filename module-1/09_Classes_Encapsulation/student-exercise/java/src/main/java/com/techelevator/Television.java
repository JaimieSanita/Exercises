package com.techelevator;

public class Television {

	
	private boolean isOn;
	private int currentChannel;
	private int currentVolume;
	
	public boolean isOn() {
		return this.isOn;
	}
	
	public int getCurrentChannel() {
		return currentChannel;
	}
	
	public int getCurrentVolume () {
		return currentVolume;
	}
	
	// However, the instance variables need default values: a new TV is off by default. The channel is set to three and the volume level to two.
	
	public static final boolean defaultOn = false;
	public static final int defaultChannel = 3;
	public static final int defaultVolume = 2;
	
	
}
