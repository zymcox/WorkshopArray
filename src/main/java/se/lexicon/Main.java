package se.lexicon;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nName Repository Menu:");
            System.out.println("1. Add Name");
            System.out.println("2. Find Name");
            System.out.println("3. Remove Name");
            System.out.println("4. Show All Names");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name to add: ");
                    String nameToAdd = scanner.nextLine();
                    if (NameRepository.add(nameToAdd)) {
                        System.out.println("Name added successfully.");
                    } else {
                        System.out.println("Name already exists.");
                    }
                    break;
                case 2:
                    System.out.print("Enter name to find: ");
                    String nameToFind = scanner.nextLine();
                    String foundName = NameRepository.find(nameToFind);
                    if (foundName != null) {
                        System.out.println("Name found: " + foundName);
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    if (NameRepository.remove(nameToRemove)) {
                        System.out.println("Name removed successfully.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;
                case 4:
                    System.out.println("All names: ");
                    for (String name : NameRepository.findAll()) {
                        System.out.println(name);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}