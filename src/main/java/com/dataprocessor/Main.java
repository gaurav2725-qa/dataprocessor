package com.dataprocessor;

import com.dataprocessor.model.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            Student s = new Student("John", 20, "A");
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getGrade());
            System.out.println(s); //That's Java printing the memory address of your object


    }
    /*Your first Java program running successfully.
John
20
A
Process finished with exit code 0
Exit code 0 means no errors. Program ran and finished cleanly. ✅

What Just Happened — The Big Picture
Look at what you actually built and ran:
Student.java — a blueprint. Defines what a student looks like. Lives in model package.
Main.java — created a real Student object from that blueprint, and printed its data using getters.
This is Object Oriented Programming in action. You didn't just read about it — you did it.
In one session, starting from zero, you have:

Created a Maven project with correct structure
Understood why packages exist
Built a complete Student model class with fields, constructor, getters, setters, and toString()
Ran it successfully
*/

}