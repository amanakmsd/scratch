package com.learning.hashmap.test;

import com.learning.hashmap.HashScratchMap;
import com.learning.hashmap.ScratchMap;
import com.learning.hashmap.exception.KeyNotFoundException;


public class HashScratchMapTest {

    public ScratchMap<Integer, Integer> initialise() {
        ScratchMap<Integer, Integer> scratchMap = new HashScratchMap<>();
        for(int i=0;i<500;i++) {
            scratchMap.put(i, i);
        }
        return scratchMap;
    }

    public Integer getCheck() throws KeyNotFoundException {
        ScratchMap<Integer, Integer> map = initialise();
        return map.get(10);
    }

    public void removeCheck() throws KeyNotFoundException {
        ScratchMap<Integer, Integer> map = initialise();
        map.remove(68);
        map.get(10);
    }
}
