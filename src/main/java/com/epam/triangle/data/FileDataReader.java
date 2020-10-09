package com.epam.triangle.data;

import com.epam.triangle.exception.DataException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {

    private final String fileName;

    public FileDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> getRecords() throws DataException {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new DataException("File reading problem!", e);
        }
        return lines;
    }
}
