package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public abstract class ScratchMap<Key, Value> {
    /**
     * Use to put Item in Map
     * @param key - key of the map
     * @param value - Value associated with key
     * @return - boolean true --> if key is already present and is updated. false --> if it is new key
     */
    abstract boolean put(Key key, Value value);

    /**
     * Gets the value from map
     * @param key - Provided key  to be fetched value
     * @return - Returns the value
     * @throws KeyNotFoundException - If value is not present, throw me.
     */
    abstract Value get(Key key) throws KeyNotFoundException;

    /**
     *
     * Gets the value from map
     * @param key - Provided key  to be fetched value
     * @param value - default value
     * @return - Returns the value if present else return the provided value
     */
    abstract Value getOrDefault(Key key, Value value);
//    abstract int size();
//    abstract boolean has(Key key);
}
