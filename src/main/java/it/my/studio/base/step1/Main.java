package it.my.studio.base.step1;

public class Main {
    public static void main(String[] args) {
        ExamplePublisher publisher = new ExamplePublisher(10);
        publisher.subscribe(new ExampleSubscriber());
    }
}
