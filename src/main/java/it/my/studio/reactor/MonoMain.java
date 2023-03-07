package it.my.studio.reactor;

import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonoMain {

    Mono<String> mono = Mono.just("Hello, world!");

    public static void main(String[] args) {
        MonoMain mm = new MonoMain();

        mm.monoJust();
        mm.monoJustMap();
        mm.monoJustFilter();
        mm.monoJustShuffle();
        mm.monoJustNull();
    }

    private void monoJust() {
        System.out.println("Bagin monoJust");
        System.out.println(mono.block());
        System.out.println("End monoJust");
    }

    private void monoJustMap() {
        System.out.println("Bagin monoJustMap");
        System.out.println(mono.map(String::toUpperCase).block());
        System.out.println("End monoJustMap");
    }

    private void monoJustFilter() {
        System.out.println("Bagin monoJustFilter");
        System.out.println(mono.filter(str -> str.startsWith("H")).block());
        System.out.println("End monoJustFilter");
    }

    private void monoJustNull() {
        System.out.println("Begin monoJustNull");
        Mono<String> noValue = Mono.never();
        noValue.subscribe(val->{
            System.out.println(">>> "+val);
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End monoJustNull");
    }

    private void monoJustShuffle(){
        System.out.println("Bagin monoJustShuffle");
        System.out.println(mono.map((MonoMain::shuffle)).block());
        System.out.println("End monoJustShuffle");
    }

    public static String shuffle(String str) {
        StringBuffer ret = new StringBuffer();
        List<String> chars = Arrays.asList(str.split(""));
        Collections.shuffle(chars); // mescola i valori
        chars.forEach(c->ret.append(c));
        return ret.toString();
    }
}
