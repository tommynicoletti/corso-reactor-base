package it.my.studio.base.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow;

public class ExamplePublisher implements Flow.Publisher<Integer> {

    private List<Integer> numbers;

    public ExamplePublisher(int size) {
        this.numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(100));
        }
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        // numbers.iterator().forEachRemaining(subscriber::onNext);
        numbers.forEach( number -> {
            System.out.println("Sending " +number);
            subscriber.onNext(number);
        });
        subscriber.onComplete();
    }
}
