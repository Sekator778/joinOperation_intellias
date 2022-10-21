package org.example.test;

import lombok.Data;

@Data
public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    K key;
    V1 value1;
    V2 value2;

    @Override
    public String toString() {
        return "JoinedDataRow(" + key + ", " + value1 + ", " + value2 + ")";
    }
}
