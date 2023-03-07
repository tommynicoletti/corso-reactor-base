package it.my.studio.base.step2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

public class ExamplePublisher implements Flow.Publisher<String> {

    List<String> stringList;

    public ExamplePublisher() {
        stringList = Arrays.asList(new String[]{"cane","gatto","topo","lupo","cinghiale"});
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        this.stringList.forEach(item->{
            System.out.println("PUB - Sending: "+item);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subscriber.onNext(item);
        });
        System.out.println("PUB - Complete");
        subscriber.onComplete();
    }
}
