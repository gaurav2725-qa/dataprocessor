package com.dataprocessor;

import com.dataprocessor.model.Student;
import com.dataprocessor.processor.Studentprocessor;
import com.dataprocessor.reader.StudentReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    private static final String TEST_DATA_PATH =
            "src/main/resources/students.csv";

    public static void main(String[] args) {
        logger.info("DataProcessor application starting");

        try {
            StudentReader reader = new StudentReader();
            List<Student> students = reader.readStudents(TEST_DATA_PATH);

            Studentprocessor processor = new Studentprocessor();

            List<Student> gradeA = processor.filterByGrade(students, "A");
            gradeA.forEach(s -> logger.info("Grade A student: {}", s));

            Student oldest = processor.getOldestStudent(students);
            logger.info("Oldest student: {}", oldest);

            double avgAge = processor.getAverageAge(students);
            logger.info("Average age: {}", avgAge);

        } catch (IOException e) {
            logger.error("Failed to read student data: {}", e.getMessage());
        }

        logger.info("DataProcessor application completed");
    }
}