package it.my.studio.base.step3;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ExampleProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer,Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Raddoppia");
        submit(item*2);
        // subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError");
    }

    @Override
    public void onComplete() {
        close();
    }
}
