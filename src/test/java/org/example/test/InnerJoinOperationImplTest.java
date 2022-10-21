package org.example.test;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class InnerJoinOperationImplTest {

    @Test
    void joinWhenIntegerKey() {
        List<DataRow<Integer, String>> leftCollection =
                List.of(new DataRow<>(0, "Ukraine"), new DataRow<>(1, "Germany"), new DataRow<>(2, "France"));
        List<DataRow<Integer, String>> rightCollection =
                List.of(new DataRow<>(0, "Kyiv"), new DataRow<>(1, "Berlin"), new DataRow<>(3, "Budapest"));

        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> joinOperation = new InnerJoinOperationImpl<>();
        Collection<JoinedDataRow<Integer, String, String>> join = joinOperation.join(leftCollection, rightCollection);
        assertThat(join.toString(),
                Is.is("[JoinedDataRow(0, Ukraine, Kyiv), JoinedDataRow(1, Germany, Berlin)]"));
    }

    @Test
    void joinWhenStringKey() {
        List<DataRow<String, String>> leftCollection =
                List.of(new DataRow<>("A", "Ukraine"), new DataRow<>("B", "Germany"), new DataRow<>("C", "France"));
        List<DataRow<String, String>> rightCollection =
                List.of(new DataRow<>("A", "Kyiv"), new DataRow<>("B", "Berlin"), new DataRow<>("D", "Budapest"));

        JoinOperation<DataRow<String, String>, DataRow<String, String>, JoinedDataRow<String, String, String>> joinOperation = new InnerJoinOperationImpl<>();
        Collection<JoinedDataRow<String, String, String>> join = joinOperation.join(leftCollection, rightCollection);
        assertThat(join.toString(),
                Is.is("[JoinedDataRow(A, Ukraine, Kyiv), JoinedDataRow(B, Germany, Berlin)]"));
    }
}