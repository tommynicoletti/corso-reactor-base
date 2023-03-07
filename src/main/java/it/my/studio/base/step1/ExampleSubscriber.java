package it.my.studio.base.step1;

import java.util.concurrent.Flow;

public class ExampleSubscriber implements Flow.Subscriber<Integer> {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("onNext");
        System.out.println(item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError");
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
