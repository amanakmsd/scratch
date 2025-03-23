package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public class ScratchMapMain {

    public static void main(String[] args) throws KeyNotFoundException {
        ScratchMap<String, String> scratchMap = new HashScratchMap<>();
        boolean putResp = scratchMap.put("Aman", "Hi Aman !");
        System.out.println(putResp);
        putResp = scratchMap.put("Amab", "Hi Amab!");
        System.out.println(putResp);
        String output = scratchMap.get("Aman");
        System.out.println(output);
        putResp = scratchMap.put("Aman", "Hi Aman Singh !");
        System.out.println(putResp);
        output = scratchMap.get("Aman");
        System.out.println(output);
        try {
            output = scratchMap.get("Ahha");
        } catch (KeyNotFoundException e) {
            System.out.println("Key not found");
        }

        output = scratchMap.getOrDefault("Ahhaa", "Vallah");
        System.out.println(output);

    }
}
