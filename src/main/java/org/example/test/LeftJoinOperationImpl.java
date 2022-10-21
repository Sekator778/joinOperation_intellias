package org.example.test;


import org.example.test.util.AddDataToRow;

import java.util.ArrayList;
import java.util.Collection;

public class LeftJoinOperationImpl<K extends Comparable<K>, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>,
        JoinedDataRow<K, V1, V2>> {

    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection, Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> result = new ArrayList<>();
        for (DataRow<K, V1> leftData : leftCollection) {
            boolean isMatch = false;
            K key = leftData.getKey();
            for (DataRow<K, V2> rightData : rightCollection) {
                if (leftData.getKey().compareTo(key) > 0) {
                    break;
                }
                if (rightData.getKey().compareTo(key) == 0) {
                    AddDataToRow.addDataToRow(key, leftData.getValue(), rightData.getValue(), result);
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                AddDataToRow.addDataToRow(key, leftData.getValue(), null, result);
            }
        }
        return result;
    }
}
