package com.dataprocessor.reader;
import com.dataprocessor.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
    public List<Student> readStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String grade = parts[2];
                students.add(new Student(name, age, grade));
            }
        }

        return students;
    }}

/*Code Review — StudentReader.java
Naming — readStudents, filePath, students — all clear and meaningful. 9/10
Structure — create list → read file → loop → create object → add to list → return. Correct flow. 10/10
Exception handling — throws IOException declared. 8/10 — we'll improve this later with try-with-resources.
One small thing — remove the comment // risky code here.
 Comments should explain WHY not WHAT. The code itself explains what.

Step 1 — Create empty container
javaList<Student> students = new ArrayList<>();
You created an empty box that will hold Student objects.
Like an empty shelf before putting books on it.

Step 2 — Open the file
javaBufferedReader reader = new BufferedReader(new FileReader(filePath));
FileReader — opens the file at the given path.

BufferedReader — wraps around it to read line by line efficiently.
 Without it you'd read one character at a time. Slow.

Step 3 — Read line by line
javaString line;
while ((line = reader.readLine()) != null) {
readLine() reads one line at a time. When there are no more lines it returns null.
 So the loop stops automatically.

Step 4 — Split each line
javaString[] parts = line.split(",");
Each line looks like John,20,A. Split by comma gives you:
parts[0] = "John"
parts[1] = "20"
parts[2] = "A"

Step 5 — Extract values
javaString name = parts[0];
int age = Integer.parseInt(parts[1]);
String grade = parts[2];
parts[1] is "20" — a String. But age needs to be an int. Integer.parseInt() converts "20" → 20.

Step 6 — Create Student and add to list
javaStudent student = new Student(name, age, grade);
students.add(student);
Create one Student object per line. Add it to the list.

Step 7 — Close and return
javareader.close();
return students;
Always close the file after reading. Then return the full list.

In Main
javafor (Student student : students) {
    System.out.println(student);
}
This is a for-each loop. For every student in the list — print it. println(student) automatically
calls toString() which you built yesterday.
The Big Picture
CSV File → StudentReader → List<Student> → Main prints them
That is a real data pipeline. Small scale. But the exact same pattern used in enterprise frameworks.
 */
