package teams_assignment.Q_2;

import java.util.Scanner;

class Course {
    int courseID;
    String courseName;
    int credits;

    Course(int courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    int getCourseID() {
        return courseID;
    }

    String getCourseName() {
        return courseName;
    }

    int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + ", Course Name: " + courseName + ", Credits: " + credits;
    }
}

class Enrollment {
    int[][] studentCourses;
    int[] courseCounts;
    int studentCount;

    Enrollment(int studentCount, int maxCourses) {
        this.studentCount = studentCount;
        studentCourses = new int[studentCount][maxCourses];
        courseCounts = new int[studentCount];
    }

    void enroll(int studentID, int courseID) {
        if (studentID < studentCount) {
            studentCourses[studentID][courseCounts[studentID]] = courseID;
            courseCounts[studentID]++;
        } else {
            System.out.println("Invalid Student ID.");
        }
    }

    void drop(int studentID, int courseID) {
        if (studentID < studentCount) {
            for (int i = 0; i < courseCounts[studentID]; i++) {
                if (studentCourses[studentID][i] == courseID) {
                    for (int j = i; j < courseCounts[studentID] - 1; j++) {
                        studentCourses[studentID][j] = studentCourses[studentID][j + 1];
                    }
                    courseCounts[studentID]--;
                    break;
                }
            }
        } else {
            System.out.println("Invalid Student ID.");
        }
    }

    void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        if (studentID < studentCount) {
            System.out.println("Student " + studentID + " is enrolled in:");
            for (int i = 0; i < courseCounts[studentID]; i++) {
                int courseID = studentCourses[studentID][i];
                for (Course course : courseCatalog) {
                    if (course.getCourseID() == courseID) {
                        System.out.println(course);
                    }
                }
            }
        } else {
            System.out.println("Invalid Student ID.");
        }
    }
}

public class CourseEnrollment {
    Course[] courseCatalog;
    Enrollment enrollment;

    CourseEnrollment(int studentCount, int maxCourses) {
        courseCatalog = new Course[] {
                new Course(1, "C", 3),
                new Course(2, "DSA", 4),
                new Course(3, "GO", 3)
        };
        enrollment = new Enrollment(studentCount, maxCourses);
    }

    void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseCatalog) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        CourseEnrollment system = new CourseEnrollment(100, 10);

        String conti = "y";

        while (conti.equals("y")) {
            System.out.print("\n1. Enroll\n2. Drop\n3. Get Enrolled Courses\n4. Exit\n: ");
            int ch = inp.nextInt();
            switch (ch) {
                case 1:
                    system.displayCourses();
                    System.out.print("Enter Student ID: ");
                    int studentID = inp.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = inp.nextInt();
                    system.enrollment.enroll(studentID, courseID);
                    break;

                case 2:
                    system.displayCourses();
                    System.out.print("Enter Student ID: ");
                    studentID = inp.nextInt();
                    System.out.print("Enter Course ID: ");
                    courseID = inp.nextInt();
                    system.enrollment.drop(studentID, courseID);
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = inp.nextInt();
                    system.enrollment.getEnrolledCourses(studentID, system.courseCatalog);
                    break;

                case 4:
                    conti = "n";
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        inp.close();
    }
}
