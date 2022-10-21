package org.example.test;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class LeftJoinOperationImplTest {

    @Test
    void join() {
        List<DataRow<Integer, String>> leftCollection =
                List.of(new DataRow<>(0, "Ukraine"), new DataRow<>(1, "Germany"), new DataRow<>(2, "France"));
        List<DataRow<Integer, String>> rightCollection =
                List.of(new DataRow<>(0, "Kyiv"), new DataRow<>(1, "Berlin"), new DataRow<>(3, "Budapest"));

        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> joinOperation = new LeftJoinOperationImpl<>();
        Collection<JoinedDataRow<Integer, String, String>> join = joinOperation.join(leftCollection, rightCollection);
        assertThat(join.toString(),
                Is.is("[JoinedDataRow(0, Ukraine, Kyiv), JoinedDataRow(1, Germany, Berlin), JoinedDataRow(2, France, null)]"));
    }

    @Test
    void whenKeyMore() {
        List<DataRow<Integer, String>> leftCollection =
                List.of(new DataRow<>(0, "Ukraine"), new DataRow<>(1, "Germany"), new DataRow<>(2, "France"));
        List<DataRow<Integer, String>> rightCollection =
                List.of(new DataRow<>(0, "Kyiv"), new DataRow<>(6, "Berlin"), new DataRow<>(2, "Paris"));

        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow<Integer, String, String>> joinOperation = new LeftJoinOperationImpl<>();
        Collection<JoinedDataRow<Integer, String, String>> join = joinOperation.join(leftCollection, rightCollection);
        assertThat(join.toString(),
                Is.is("[JoinedDataRow(0, Ukraine, Kyiv), JoinedDataRow(1, Germany, null), JoinedDataRow(2, France, Paris)]"));
    }
}