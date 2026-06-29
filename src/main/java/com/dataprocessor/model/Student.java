package com.dataprocessor.model;

public class Student {
    private  String  name;
    private int age;
    private  String  grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;

    }

    public String getName()
    {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade='" + grade+"'}";

    }
    /*Code Review — Student.java (Final)
Naming — fields, parameters, methods all consistent and meaningful. 10/10
Encapsulation — private fields, public methods. 10/10
Constructor — correct parameters, correct assignments. 10/10
Structure — getter and setter together for each field. Clean. 10/10
This is production quality for a model class.*/
/*Encapsulation means hiding the data inside a class and controlling access to it. In my Student class,
I made all fields private so no other class can directly access or change them. Instead,
they have to use getName() or setName() — which gives me control over how the data is read and modified."
*/

}
