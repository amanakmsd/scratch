package com.learning.hashmap;

import com.learning.hashmap.exception.KeyNotFoundException;

public abstract class ScratchMap<Key, Value> {
    /**
     * Use to put Item in Map
     * @param key - key of the map
     * @param value - Value associated with key
     * @return - boolean true --> if key is already present and is updated. false --> if it is new key
     */
    public abstract boolean put(Key key, Value value);

    /**
     * Gets the value from map
     * @param key - Provided key  to be fetched value
     * @return - Returns the value
     * @throws KeyNotFoundException - If value is not present, throw me.
     */
    public abstract Value get(Key key) throws KeyNotFoundException;

    /**
     *
     * Gets the value from map
     * @param key - Provided key  to be fetched value
     * @param value - default value
     * @return - Returns the value if present else return the provided value
     */
    public abstract Value getOrDefault(Key key, Value value);

    /**
     * Get the size of map
     * @return - Return the count of elements in the map
     */
    public abstract int size();

    /**
     * Checks if key is present in the provided map
     * @param key - Check for this key
     * @return - boolean based on key is present (true) or not (false)
     */
    public abstract boolean has(Key key);

    /**
     * Remove the key, value from map
     * @param key - Specific key to be removed
     * @return = Return the value associated with key
     * @throws KeyNotFoundException - Throws if key is not present
     */
    public abstract Value remove(Key key) throws KeyNotFoundException;
}
