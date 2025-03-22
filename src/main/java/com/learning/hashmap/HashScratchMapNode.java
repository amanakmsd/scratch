package com.learning.hashmap;

public class HashScratchMapNode<Key, Value> {
    private Key key;
    private Value value;
    private HashScratchMapNode<Key, Value> next;

    public HashScratchMapNode(Key key, Value value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public HashScratchMapNode<Key, Value> getNext() {
        return next;
    }

    public void setNext(HashScratchMapNode<Key, Value> next) {
        this.next = next;
    }
}
