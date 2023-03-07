package it.my.studio.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FluxMain {

    Flux<Integer> flux = Flux.just(1, 2, 3, 4);

    public static void main(String[] args) {
        FluxMain fm = new FluxMain();
        // fm.collecting();
        // fm.collectingSubscriber();
        // fm.collectingSubscriberBackpressure();
        fm.mappingData();
    }

    private void collecting() {
        System.out.println("Begin collecting");
        List<Integer> elements = new ArrayList<>();
        flux.subscribe(elements::add);
        System.out.println(elements);
        System.out.println("End collecting");
    }

    private void collectingSubscriber() {
        System.out.println("Begin collectingSubscriber");
        List<Integer> elements = new ArrayList<>();
        flux.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                elements.add(integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Complete!");
            }
        });
        System.out.println(elements);
        System.out.println("End collectingSubscriber");
    }

    private void collectingSubscriberBackpressure() {
        System.out.println("Begin collectingSubscriberBackpressure");
        List<Integer> elements = new ArrayList<>();
        flux.subscribe(new Subscriber<Integer>() {
            Subscription s;
            int index;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.s = subscription;
                s.request(2);
            }

            @Override
            public void onNext(Integer integer) {
                elements.add(integer);
                index++;
                if(index%2 == 0){
                    try {
                        System.out.println("Sono in pausa per 2 secondi "+elements);
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    s.request(2);
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Complete!");
            }
        });
        System.out.println(elements);
        System.out.println("End collectingSubscriberBackpressure");
    }

    private void mappingData() {
        System.out.println("Begin collecting");
        List<String> elements = new ArrayList<>();
        Flux.just("a","v", "c", "f").map(String::toUpperCase).subscribe(elements::add);
        System.out.println(elements);
        System.out.println("End collecting");
    }
}
