package com.dataprocessor;

import com.dataprocessor.model.Student;
import com.dataprocessor.processor.Studentprocessor;
import com.dataprocessor.reader.StudentReader;
import com.dataprocessor.util.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("DataProcessor application starting");

        try {
            // Config drives everything — no hardcoded values
            String dataPath = ConfigManager.getInstance()
                    .get("data.students.path");

            StudentReader reader = new StudentReader();
            List<Student> students = reader.readStudents(dataPath);

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