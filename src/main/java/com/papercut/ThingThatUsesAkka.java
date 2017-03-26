package com.papercut;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import scala.concurrent.duration.Duration;

import static akka.actor.SupervisorStrategy.resume;
import static akka.actor.SupervisorStrategy.stop;

public class ThingThatUsesAkka extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return new OneForOneStrategy(0, Duration.Zero(), t -> {
            return Math.random() > 0.5 ? stop() : resume();    
        });        
    }
}
