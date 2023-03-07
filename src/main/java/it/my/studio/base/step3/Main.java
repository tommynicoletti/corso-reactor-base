package it.my.studio.base.step3;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // differenza tra submission publisher e publisher

        // SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        ExamplePublisher publisher = new ExamplePublisher(10);
        ExampleProcessor processor = new ExampleProcessor();
        ExampleSubscriber subscriber = new ExampleSubscriber();

        processor.subscribe(subscriber);
        publisher.subscribe(processor);

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
