package org.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataRow<K extends Comparable<K>, V> {
    K key;
    V value;
}
