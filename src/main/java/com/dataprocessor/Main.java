package com.dataprocessor;

import com.dataprocessor.model.Student;
import com.dataprocessor.reader.StudentReader;
import java.io.IOException;

import java.util.List;


public class Main {
    private static final String TEST_DATA_PATH =
            "src/main/resources/students.csv";
    public static void main(String[] args)  {
        try {

            StudentReader reader = new StudentReader();
            List<Student> students = reader.readStudents(TEST_DATA_PATH);

        for (Student student : students) {
            System.out.println(student);
        }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }

    }
}