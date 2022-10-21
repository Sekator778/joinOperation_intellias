package org.example.test;


import org.example.test.util.AddDataToRow;

import java.util.ArrayList;
import java.util.Collection;

public class RightJoinOperationImpl<K extends Comparable<K>, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>,
        JoinedDataRow<K, V1, V2>> {

    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection, Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> result = new ArrayList<>();
        for (DataRow<K, V2> rightData : rightCollection) {
            boolean isMatch = false;
            K key = rightData.getKey();
            for (DataRow<K, V1> leftData : leftCollection) {
                /*TODO look this compareTo()*/
                if (leftData.getKey().compareTo(key) > 0) {
                    break;
                }
                if (leftData.getKey().compareTo(key) == 0) {
                    AddDataToRow.addDataToRow(key, leftData.getValue(), rightData.getValue(), result);
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                AddDataToRow.addDataToRow(key, null, rightData.getValue(), result);
            }
        }
        return result;
    }
}
