package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public class HashScratchMap<Key, Value> extends ScratchMap<Key, Value> {

    public static final Integer HASH_MAP_CODE_COUNT = 16;

    int size;
    int elementsCount;
    HashScratchMapNode<Key, Value>[] nodes;

    HashScratchMap() {
        this.size = HASH_MAP_CODE_COUNT;
        this.elementsCount = 0;
        nodes = new HashScratchMapNode[HASH_MAP_CODE_COUNT];
        for (int i = 0; i < size; i++) {
            nodes[i] = null;
        }
    }

    @Override
    boolean put(Key key, Value value) {
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
        return false;
    }

    @Override
    Value get(Key key) throws KeyNotFoundException {
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
    Value getOrDefault(Key key, Value value) {
        try {
            return this.get(key);
        } catch (KeyNotFoundException e) {
            return value;
        }
    }

    @Override
    int size() {
        return this.elementsCount;
    }

    @Override
    boolean has(Key key) {
        try {
            this.get(key);
            return true;
        } catch (KeyNotFoundException e) {
            return false;
        }
    }
}
