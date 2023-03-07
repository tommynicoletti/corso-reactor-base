package it.my.studio.base.step2;

import java.util.concurrent.Flow;

public class ExampleSubscriber implements Flow.Subscriber<String> {
    Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("SUB - onSubscribe");
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("SUB - onNext: "+item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("SUB - ERROR");
    }

    @Override
    public void onComplete() {
        System.out.println("SUB - COMPLETED");
    }
}
