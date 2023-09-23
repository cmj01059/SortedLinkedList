import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        File input = new File(args[0]);
        SortedLinkedList list = new SortedLinkedList();
        try {
                Scanner fileReader = new Scanner(input);
                while (fileReader.hasNextInt()) {
                    int item = fileReader.nextInt();
                    System.out.println(item);
                    list.insertItem(new ItemType(item));
                }
            fileReader.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found.");
        }

        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find interesection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");
        System.out.println();

        boolean isRunning = true;
        Scanner keyboard = new Scanner(System.in);
        String userInput;
        while(isRunning) {
            System.out.println();
            System.out.print("Enter a command: ");
            userInput = keyboard.next();
            userInput.trim();
            switch (userInput) {
                case "p":
                    System.out.print("The list is: ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    break;
                
                case "l":
                    System.out.println("The length of the list is " + list.getLength());
                    break;

                case "i":
                    System.out.print("Enter a number to insert: ");
                    int insertNum = keyboard.nextInt();
                    System.out.print("Original list : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    list.insertItem(new ItemType(insertNum));
                    System.out.print("New List : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    break;

                case "d": 
                    System.out.print("Enter a number to delete: ");
                    int delNum = keyboard.nextInt();
                    System.out.print("Original list : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    list.deleteItem(new ItemType(delNum));
                    System.out.print("New List : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    break;

                case "s":
                    System.out.print("Enter a number to search: ");
                    int searchNum = keyboard.nextInt();
                    System.out.print("Original list : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    int index = list.searchItem(new ItemType(searchNum));
                    if (index == -1) {
                        System.out.println("Item is not present in the list");
                    } else {
                        System.out.println("The item is present at index " + index);
                    }
                    break;

                case "r": 
                    list.resetList();
                    System.out.println("Iterator is reset");
                    break;

                case "n":
                    System.out.println(list.getNextItem());
                    break;

                case "a":
                    System.out.print("Original list : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    list.deleteAlternateNodes();
                    System.out.print("New List : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    break;

                case "m":
                    System.out.print("Enter the length of the new list: ");
                    int length = keyboard.nextInt();
                    SortedLinkedList newList = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int count = 0; count < length; count++) {
                        newList.insertItem(new ItemType(keyboard.nextInt()));
                    }
                    System.out.print("list 1 : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    System.out.print("list 2 : ");
                    newList.resetList();
                    for (int count = 0; count < newList.getLength(); count++) {
                        System.out.print(newList.getNextItem() + " ");
                    }
                    SortedLinkedList mergeList = list.mergeList(newList);
                    System.out.print("Merged list : ");
                    mergeList.resetList();
                    for (int count = 0; count < mergeList.getLength(); count++) {
                        System.out.print(mergeList.getNextItem() + " ");
                    }
                    break;

                case "t":
                    System.out.print("Enter the length of the new list: ");
                    int length2 = keyboard.nextInt();
                    SortedLinkedList newList2 = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int count = 0; count < length2; count++) {
                        newList2.insertItem(new ItemType(keyboard.nextInt()));
                    }
                    System.out.print("list 1 : ");
                    list.resetList();
                    for (int count = 0; count < list.getLength(); count++) {
                        System.out.print(list.getNextItem() + " ");
                    }
                    System.out.println();
                    System.out.print("list 2 : ");
                    newList2.resetList();
                    for (int count = 0; count < newList2.getLength(); count++) {
                        System.out.print(newList2.getNextItem() + " ");
                    }
                    System.out.println();
                    list.intersection(newList2);
                    break;

                case "q": 
                    isRunning = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid command try again.");
                    break;
            }
        }
        keyboard.close();
    }
}
