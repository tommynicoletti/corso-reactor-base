package it.my.studio.base.step2;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ExampleProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("PROC - Subscription");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("PROC - Uppercase: "+item);
        submit(item.toUpperCase());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("PROC - Error");
    }

    @Override
    public void onComplete() {
        System.out.println("PROC - Complete");
        close();
    }
}
