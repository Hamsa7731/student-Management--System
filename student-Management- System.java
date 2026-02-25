import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static class Student {
        int id;
        String name;
        int age;
        String grade;

        Student(int id, String name, int age, String grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.View 3.Update 4.Delete 5.Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Grade: ");
                String grade = sc.nextLine();

                list.add(new Student(id, name, age, grade));
                System.out.println("Student Added Successfully!");

            } else if (choice == 2) {

                if (list.isEmpty()) {
                    System.out.println("No Students Found!");
                } else {
                    for (Student s : list) {
                        System.out.println(s.id + " " + s.name + " " + s.age + " " + s.grade);
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter ID to Update: ");
                int id = sc.nextInt();
                sc.nextLine();

                boolean found = false;
                for (Student s : list) {
                    if (s.id == id) {
                        System.out.print("New Name: ");
                        s.name = sc.nextLine();
                        found = true;
                        System.out.println("Updated Successfully!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student Not Found!");
                }

            } else if (choice == 4) {

                System.out.print("Enter ID to Delete: ");
                int id = sc.nextInt();

                boolean removed = list.removeIf(s -> s.id == id);

                if (removed) {
                    System.out.println("Deleted Successfully!");
                } else {
                    System.out.println("Student Not Found!");
                }

            } else if (choice == 5) {
                System.out.println("Thank You!");
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }
}