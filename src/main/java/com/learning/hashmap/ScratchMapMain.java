package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public class ScratchMapMain {

    public static void main(String[] args) throws KeyNotFoundException {
        ScratchMap<String, String> scratchMap = new HashScratchMap<>();
        scratchMap.put("Aman", "Hi Aman !");
        scratchMap.put("Amab", "Hi Amab!");
        String output = scratchMap.get("Aman");
        System.out.println(output);
        scratchMap.put("Aman", "Hi Aman Singh !");
        output = scratchMap.get("Aman");
        System.out.println(output);
    }
}
