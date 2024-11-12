package com.thread.threadprocessing.concurrency2;

import java.util.ArrayList;
import java.util.List;

public class SampleGenericsClass2<K,V> {
    List<K> key=new ArrayList<>();
    List<V> values=new ArrayList<>();
    void put(K key,V value){
        System.out.println("put method");
    }
    V getKey(K key){
        return null;
    }
}
