package OOPS;

import java.util.Arrays;
import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("Sparsh");
        StringBuilder b = a;
        StringBuilder c = a;

        System.out.println("A -> " + a + " B -> " + b + " C -> " + c + "\n");
        System.out.println("Before changing a...\n");
        a.replace(0, a.length(), "Hello World"); // This statement changes all 3 objects
        System.out.println("After changing a...");
        System.out.println("A -> " + a + " B -> " + b + " C -> " + c + "\n");

        Student[] students = new Student[2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter Age : ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name : ");
            String name = scanner.nextLine();
            double[] marks = new double[5];

            for (int j = 0; j < 5; j++) {
                System.out.print("Enter Marks in Subject " + j + " : ");
                marks[j] = scanner.nextDouble();
            }

            System.out.println(Arrays.toString(marks));

            students[i] = new Student(name, marks, age);
        }

        System.out.println("\n\nStudents Data : \n\n");

        for (int i = 0; i < 2; i++) {
            System.out.println(students[i].toString());
        }
    }
}

class Student{
    String name;
    double[] marks;
    int age;

    public Student(String name, double[] marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", age=" + age +
                '}';
    }
}
