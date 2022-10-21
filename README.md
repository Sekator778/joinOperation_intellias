# joinOperation_intellias
Example:
Having
leftCollection = [DataRow(0, "Ukraine"), DataRow(1, "Germany"), DataRow(2, "France")]
rightCollection = [DataRow(0, "Kyiv"), DataRow(1, "Berlin"), DataRow(3, "Budapest")]
InnerJoinOperation.join gives: [JoinedDataRow(0, "Ukraine", "Kyiv"), JoinedDataRow(1, "Germany", "Berlin")]
LeftJoinOperation.join gives: [JoinedDataRow(0, "Ukraine", "Kyiv"), JoinedDataRow(1, "Germany", "Berlin"), JoinedDataRow(2, "France", null)]
RightJoinOperation.join gives: [JoinedDataRow(0, "Ukraine", "Kyiv"), JoinedDataRow(1, "Germany", "Berlin"), JoinedDataRow(3, null, "Budapest")]
