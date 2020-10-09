package com.epam.triangle.data;

import com.epam.triangle.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FileDataReaderTest {

    private static final String FILE_CORRECT = "src/test/resources/TriangleTest.txt";
    private static final String FILE_EMPTY = "src/test/resources/TriangleTestEmpty.txt";
    private static final String FILE_LOST = "src/test/resources/TriangleTestLost.txt";

    @Test
    public void getRecordsTestShouldReturnListOfStringLinesWhenFileIsCorrect() throws DataException {
        //given
        FileDataReader reader = new FileDataReader(FILE_CORRECT);
        //when
        List<String> actual = reader.getRecords();
        //then
        List<String> expected = List.of("line1", "line2", "", "line4");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getRecordsTestShouldReturnEmptyListWhenFileIsEmpty() throws DataException {
        //given
        FileDataReader reader = new FileDataReader(FILE_EMPTY);
        //when
        List<String> actual = reader.getRecords();
        //then
        List<String> expected = List.of();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = DataException.class)
    public void getRecordsTestShouldThrowExceptionWhenFileLost() throws DataException {
        //given
        FileDataReader reader = new FileDataReader(FILE_LOST);
        //when
        reader.getRecords();
        //then
    }


}
