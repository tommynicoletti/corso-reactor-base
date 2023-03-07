package it.my.studio.base.step2;

public class Main {
    public static void main(String[] args) {
        ExamplePublisher publisher = new ExamplePublisher();
        ExampleProcessor processor = new ExampleProcessor();
        ExampleSubscriber subscriber = new ExampleSubscriber();

        processor.subscribe(subscriber);
        publisher.subscribe(processor);
    }
}
