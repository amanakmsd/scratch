package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public abstract class ScratchMap<Key, Value> {
    abstract void put(Key key, Value value);
    abstract Value get(Key key) throws KeyNotFoundException;
//    abstract Value getOrDefault(Key key, Value value);
//    abstract int size();
//    abstract boolean has(Key key);
}
