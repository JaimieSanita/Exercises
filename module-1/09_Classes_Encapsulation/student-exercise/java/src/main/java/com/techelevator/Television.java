package com.techelevator;

public class Television {

	
	private boolean isOn = defaultOn;
	private int currentChannel = defaultChannel;
	private int currentVolume = defaultVolume;
	
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
	
    public void turnOff() {
    if (isOn) {
    	this.isOn = false;
    }}
    
    public void turnOn() {
    	if (!isOn) {
    		this.isOn = true;
    		this.currentChannel = defaultChannel;
    		this.currentVolume = defaultVolume;
    	}
    }
    
    public void changeChannel(int newChannel) {
    	if (isOn) {
    		if (newChannel > 3 && newChannel < 8) {
    			this.currentChannel = newChannel;
    		}
    	}
    }
    
    public void channelUp() {
    	if(isOn) {
    		if (getCurrentChannel() > 18) {
    			this.currentChannel = 3;
    		} else {
    			this.currentChannel = getCurrentChannel() + 1;
    			System.out.println(this.currentChannel);
    		}
    		}
    	}
    
    public void channelDown() {
    	if(isOn) {
    		if (getCurrentChannel() > 3) {
    			this.currentChannel = getCurrentChannel() - 1;
    		} else {
    			this.currentChannel = 18;
    		}
    		}
    	}
    
    
    public void raiseVolume() {
    	if(isOn) {
    		if (getCurrentVolume() > 10) {
    			this.currentVolume = getCurrentVolume() + 0;
    		} else {
    			this.currentVolume = getCurrentVolume() +1;
    		}	
    		}
    		}
    		
    
    public void lowerVolume() {
    	if(isOn) {
    		if (getCurrentVolume() > 0) {
    			this.currentVolume = getCurrentVolume() -1;
    		}
    		}
    	}
    }


