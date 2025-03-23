package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public class ScratchMapMain {

    public static void main(String[] args) throws KeyNotFoundException {
        ScratchMap<String, String> scratchMap = new HashScratchMap<>();
        boolean putResp = scratchMap.put("Aman", "Hi Aman !");
        int count = scratchMap.size();
        System.out.println("Size: "+count);
        System.out.println(putResp);
        putResp = scratchMap.put("Amab", "Hi Amab!");
        count = scratchMap.size();
        System.out.println("Size: "+count);
        System.out.println(putResp);
        String output = scratchMap.get("Aman");
        System.out.println(output);
        putResp = scratchMap.put("Aman", "Hi Aman Singh !");
        count = scratchMap.size();
        System.out.println("Size: "+count);
        System.out.println(putResp);
        output = scratchMap.get("Aman");
        System.out.println(output);
        try {
            output = scratchMap.get("Ahha");
            System.out.println(output);
        } catch (KeyNotFoundException e) {
            System.out.println("Key not found");
        }

        output = scratchMap.getOrDefault("Ahhaa", "Vallah");
        System.out.println(output);

        output = scratchMap.getOrDefault("Aman", "sdsfdfg");
        System.out.println(output);

        boolean isPresent = scratchMap.has("Aman");
        System.out.println(isPresent);

        isPresent = scratchMap.has("Aman111");
        System.out.println(isPresent);
        count = scratchMap.size();
        System.out.println("Size: "+count);

    }
}
