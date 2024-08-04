package teams_assignment.Q_1;

import java.util.Scanner;

class Student {
    int StudentID, Age;
    String Name, Department;

    Student(int studentID, String name, int age, String department) {
        this.StudentID = studentID;
        this.Name = name;
        this.Age = age;
        this.Department = department;
    }

    int getStudentID() {
        return StudentID;
    }

    String getName() {
        return Name;
    }

    int getAge() {
        return Age;
    }

    String getDepartment() {
        return Department;
    }

    public String toString() {
        return "StudentID: " + StudentID + ", Name: " + Name + ", Age: " + Age + ", Department: " + Department;
    }
}

class StudentRecordSystem {
    Student students[];
    int count;

    StudentRecordSystem(int size) {
        students = new Student[size];
        count = 0;
    }

    void addStudent(Student student) {
        if (count < students.length) {
            students[count++] = student;
        } else {
            System.out.println("Student array is full. Cannot add more students.");
        }
    }

    public Student getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == studentID) {
                return students[i];
            }
        }
        return null;
    }

    void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}

public class StudentRecordMGMT {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int cont = 1;

        System.out.print("Enter the maximum number of students: ");
        int maxStudents = inp.nextInt();

        StudentRecordSystem srs = new StudentRecordSystem(maxStudents);
        Student student;

        while (cont == 1) {
            System.out.print("\n 1. Enter Student. \n 2. Display Student \n 3. Display All Student \n 4. Exit \n : ");
            int ch = inp.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int stdid = inp.nextInt();
                    inp.nextLine();

                    System.out.print("Enter Student Name: ");
                    String stdname = inp.nextLine();

                    System.out.print("Enter Student age: ");
                    int stdage = inp.nextInt();
                    inp.nextLine();

                    System.out.print("Enter Department: ");
                    String stddep = inp.nextLine();

                    student = new Student(stdid, stdname, stdage, stddep);
                    srs.addStudent(student);
                    break;

                case 2:
                    System.out.println("Enter student id which you want to search: ");
                    stdid = inp.nextInt();

                    System.out.println(srs.getStudent(stdid));
                    break;

                case 3:
                    srs.displayAllStudents();
                    break;
                case 4:
                    cont = 0;
                    break;
                default:
                    System.out.println("Choose Valid Option...");
                    break;
            }
        }
        inp.close();
    }
}