package com.dataprocessor.processor;

import com.dataprocessor.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Studentprocessor {

    private static final Logger logger =
            LoggerFactory.getLogger(Studentprocessor.class);

    public List<Student> filterByGrade(List<Student> students, String grade) {
        logger.info("Filtering students by grade: {}", grade);

        List<Student> filtered = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade().equalsIgnoreCase(grade)) {
                filtered.add(student);
            }
        }

        logger.info("Found {} students with grade: {}",
                filtered.size(), grade);
        return filtered;
    }

    public Student getOldestStudent(List<Student> students) {
        logger.info("Finding oldest student from {} records",
                students.size());

        Student oldest = students.get(0);
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }

        logger.info("Oldest student: {} age {}",
                oldest.getName(), oldest.getAge());
        return oldest;
    }

    public double getAverageAge(List<Student> students) {
        logger.info("Calculating average age for {} students",
                students.size());

        int total = 0;
        for (Student student : students) {
            total += student.getAge();
        }

        double average = (double) total / students.size();
        logger.info("Average age: {}", average);
        return average;
    }
}