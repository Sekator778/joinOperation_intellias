package org.example.test;

import java.util.ArrayList;
import java.util.Collection;

public class InnerJoinOperationImpl<K extends Comparable<K>, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>,
        JoinedDataRow<K, V1, V2>> {

    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection, Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> result = new ArrayList<>();

        for (DataRow<K, V1> leftData : leftCollection) {
            for (DataRow<K, V2> rightData : rightCollection) {
                if (leftData.key.compareTo(rightData.key) == 0) {
                    JoinedDataRow<K, V1, V2> joinedDataRow = new JoinedDataRow<>();
                    joinedDataRow.setKey(leftData.getKey());
                    joinedDataRow.setValue1(leftData.getValue());
                    joinedDataRow.setValue2(rightData.getValue());
                    result.add(joinedDataRow);
                }
            }
        }
        return result;
    }
}
