package org.example.test.util;


import org.example.test.JoinedDataRow;

import java.util.Collection;

public final class AddDataToRow {
    private AddDataToRow() {
    }

    public static <K extends Comparable<K>, V1, V2> void addDataToRow(K key, V1 leftData, V2 rightData, Collection<JoinedDataRow<K, V1, V2>> result) {
        JoinedDataRow<K, V1, V2> joinedDataRow = new JoinedDataRow<>();
        joinedDataRow.setKey(key);
        joinedDataRow.setValue1(leftData);
        joinedDataRow.setValue2(rightData);
        result.add(joinedDataRow);
    }
}
