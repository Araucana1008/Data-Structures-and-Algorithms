//Press 1 add
//Press 2 update
//Press 3 remove
//Press 4 display all
//Press 5 display specific
//Press 6 searchkey
//Press7 display total
//Press 8 clear
//Press 0 exit


import java.util.HashMap;
import java.util.Scanner;

public class HashMapMain{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMapSubclass subclass = new HashMapSubclass();

        System.out.println("\n-- TYPE THE NUMBER FOR THE COMMAND --");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Remove Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Display Specific Student");
        System.out.println("6. Search Student ID if it EXIST");
        System.out.println("7. Display the Total Number of Students");
        System.out.println("8. Clear Hash Map");
        System.out.println("0. Exit");

        int command = -1;

        while (command != 0) {

            System.out.print("\nType the Command No. : ");
            command = scan.nextInt();

            switch (command) {
                case 1:
                    subclass.addStudent();
                    break;
                case 2:
                    subclass.updateStudent();
                    break;
                case 3:
                    subclass.removeStudent();
                    break;
                case 4:
                    subclass.displayAll();
                    break;
                case 5:
                    subclass.displaySpecific();
                    break;
                case 6:
                    subclass.searchKey();
                    break;
                case 7:
                    subclass.displaySize();
                    break;
                case 8:
                    subclass.clear();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    scan.close();
    }
}

class HashMapSubclass extends HashMapAbstractClass{
    Scanner scan = new Scanner(System.in);
    HashMap<Integer, String> students = new HashMap<>();

    @Override
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scan.nextInt();

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        scan.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scan.nextLine();

        students.put(id, name);
        System.out.println("Student successfully added!");
    }

    @Override
    public void updateStudent() {

        System.out.print("ID of the Student to UPDATE: ");
        int id = scan.nextInt();
        scan.nextLine();

        if (students.containsKey(id)) {

            System.out.print("Enter New Student Name: ");
            String name = scan.nextLine();

            students.put(id, name);

            System.out.println("Student ID " + id + " successfully updated!");

        }else {
            System.out.println("Student ID " + id + " does not exist!");
        }
    }
    

    @Override
    public void removeStudent() {

        System.out.print("Enter the Student ID to REMOVE: ");
        int id = scan.nextInt();

        if (students.containsKey(id)) {

            students.remove(id);

            System.out.println("Student ID " + id + " successfully removed!");

        }else {
            System.out.println("Student ID " + id + " does not exist!");
        }

    };

    @Override
    public void displayAll(){
        System.out.println("All Students:");
        System.out.println(students);
    }

    @Override
    public void displaySpecific() {
        System.out.print("Student with ID: ");
        int id = scan.nextInt();

        if (students.containsKey(id)) {
            System.out.println("Student Name: " + students.get(id));
        } else {
            System.out.println("Student ID does not exist!");
        }
    }

    @Override
    public int searchKey(){
        System.out.print("Check Student ID if it EXIST: ");
        int id = scan.nextInt();

        System.out.println("Result: " + students.containsKey(id));
        return id;
    }

    @Override
    public void displaySize(){
        System.out.println("\nTotal Students:");
        System.out.println(students.size());
    }

    @Override
    public void clear(){
        students.clear();

        System.out.println("After Clearing All Students:");
        System.out.print(students + "\n");
    }
}

abstract class HashMapAbstractClass{
    public abstract void addStudent();
    public abstract void updateStudent();
    public abstract void removeStudent();
    public abstract void displayAll();
    public abstract void displaySpecific();
    public abstract int searchKey();
    public abstract void displaySize();
    public abstract void clear();
}