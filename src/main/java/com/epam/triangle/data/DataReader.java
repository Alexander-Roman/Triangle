package com.epam.triangle.data;

import com.epam.triangle.exception.DataException;

import java.util.List;

public interface DataReader {

    List<String> getRecords() throws DataException;
}
