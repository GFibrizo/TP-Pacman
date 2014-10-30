package com.grupo2.time;

import com.grupo2.eventHandling.Subscriber;

/**
 *
 * @author ivan
 */
public interface TimeoutWaiter extends Subscriber {

    public void timeout();

}
