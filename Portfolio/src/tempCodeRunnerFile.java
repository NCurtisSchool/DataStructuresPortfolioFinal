/*
Name: Nathan Curtis
Date: 2/10/2025
Class: Data Structures and Algorithms 24WB-CSC400-1
Teacher: Herbert Pensado
Assignment: Mod 8 portfolio Assignment - Option 1
GitHub: https://github.com/NCurtisSchool/DataStructuresPortfolioFinal.git
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Variables
        int size = 0;

        // Prep Queue
        Queue queue = new Queue();

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // 5 Iterations. Get user input. Create Person object with inputs. Add to queue object
        for (int i = 0; i < 5; i++) {
            // User inputs
            System.out.println("Give first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Give last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Give age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            // Create new person object
            Person person = new Person(firstName, lastName, age);

            // Add to queue
            queue.addToQueue(person);

            // Increase size
            size++;
        }

        scanner.close();

        // Do sorting mehtods with outputs
        // Age
        queue.startSort(0, size - 1, 0);
        System.out.println(queue.toString());
        // Last Name
        queue.startSort("a", size - 1, 0);
        System.out.println(queue.toString());
    }
}
