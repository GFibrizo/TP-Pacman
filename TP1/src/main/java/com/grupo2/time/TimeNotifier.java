package com.grupo2.time;

/**
 *
 * @author ivan
 */
public class TimeNotifier{
	private long ticksSoFar;
	//private observers
	public TimeNotifier() {
		this.ticksSoFar = 0;
	}

	public void requestNotification(TimeoutWaiter waiter) {
		//add to observers list
	}
	
	public long getTicksSoFar() {
		return ticksSoFar;
	}

	public void addTick() {
		this.ticksSoFar++;
		//For each observer check if tick = tick expected then call timeout
	}



}
