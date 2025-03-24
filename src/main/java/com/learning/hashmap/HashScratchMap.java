package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;
import com.learning.hashmap.test.HashScratchMapTest;

import java.util.ArrayList;
import java.util.List;

public class HashScratchMap<Key, Value> extends ScratchMap<Key, Value> {

    public static final Integer HASH_MAP_CODE_COUNT = 16;

    int size;
    int elementsCount;
    double loadFactor;
    HashScratchMapNode<Key, Value>[] nodes;

    public HashScratchMap() {
        this.size = HASH_MAP_CODE_COUNT;
        this.elementsCount = 0;
        nodes = new HashScratchMapNode[HASH_MAP_CODE_COUNT];
        loadFactor = 0.75;
        for (int i = 0; i < size; i++) {
            nodes[i] = null;
        }
    }

    @Override
    public boolean put(Key key, Value value) {
        int hashCode = key.hashCode();
        int position = hashCode % size;
        HashScratchMapNode<Key, Value> node = new HashScratchMapNode<>(key, value);
        if (nodes[position] != null) {
            HashScratchMapNode<Key, Value> curHead = nodes[position];
            while (curHead!= null) {
                if(curHead.getKey().equals(key)) {
                    curHead.setValue(value);
                    return true;
                }
                curHead = curHead.getNext();
            }
            node.setNext(nodes[position]);
        }
        nodes[position] = node;
        this.elementsCount++;
        if((double) this.elementsCount / this.size > this.loadFactor) {
            reIndex();
        }
        return false;
    }

    private void reIndex() {
        List<HashScratchMapNode<Key, Value>> nodeList = new ArrayList<>();
        for(int i=0;i<this.size;i++) {
            HashScratchMapNode<Key, Value> cur = nodes[i];
            while (cur!= null) {
                nodeList.add(cur);
                cur = cur.getNext();
            }
        }
        this.size *= 4;
        this.nodes = new HashScratchMapNode[this.size];
        this.elementsCount = 0;
        for(HashScratchMapNode<Key, Value> node: nodeList) {
            this.put(node.getKey(), node.getValue());
        }
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        int hashCode = key.hashCode();
        int position = hashCode % size;
        if(nodes[position] == null)
            throw new KeyNotFoundException();
        HashScratchMapNode<Key,Value> cur = nodes[position];
        while (cur != null) {
            if(cur.getKey().equals(key))
                return cur.getValue();
            cur = cur.getNext();
        }
        throw new KeyNotFoundException();
    }

    @Override
    public Value getOrDefault(Key key, Value value) {
        try {
            return this.get(key);
        } catch (KeyNotFoundException e) {
            return value;
        }
    }

    @Override
    public int size() {
        return this.elementsCount;
    }

    @Override
    public boolean has(Key key) {
        try {
            this.get(key);
            return true;
        } catch (KeyNotFoundException e) {
            return false;
        }
    }

    @Override
    public Value remove(Key key) throws KeyNotFoundException {
        int position = key.hashCode() % this.size;
        HashScratchMapNode<Key,Value> head = nodes[position];
        if (head == null)
            throw new KeyNotFoundException();
        HashScratchMapNode<Key,Value> prev = null;
        HashScratchMapNode<Key,Value> cur = head;
        if(cur.getKey().equals(key)) {
            Value value = cur.getValue();
            this.elementsCount--;
            nodes[position] = cur.getNext();
            return value;
        }

        while (cur!= null) {
            if(cur.getKey().equals(key)) {
                prev.setNext(cur.getNext());
                this.elementsCount--;
                return cur.getValue();
            }
            prev = cur;
            cur = cur.getNext();
        }
        throw new KeyNotFoundException();

    }
}
