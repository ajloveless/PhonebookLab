import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LovelessPhonebook {

    public static void main(String[] args) {

        ArrayList < LovelessPerson > phonebook = new ArrayList < LovelessPerson > ();
        ArrayList < LovelessPerson > matches = new ArrayList < LovelessPerson > ();
        Scanner scan = new Scanner(System.in);
        String selection = "";
        boolean success = false;
        String name = "", phoneNumber = "";
        int age, idNumber, zipCode;



        phonebook.add(new LovelessPerson("John Doe", 71, 101, "404-555-0148", 30041));
        phonebook.add(new LovelessPerson("Jane Doe", 17, 10, "404-555-5381", 30024));
        phonebook.add(new LovelessPerson("John Doe Jr.", 10, 12, "404-555-1037", 30004));

        while (selection != "10") {
            System.out.println("" +
                "1. Create a new phonebook" + "\n" +
                "2. Print the phonebook" + "\n" +
                "3. Add person to the phonebook" + "\n" +
                "4. Remove a person from the phonebook" + "\n" +
                "5. Sort" + "\n" +
                "6. Modify a person" + "\n" +
                "7. Search for a person by name" + "\n" +
                "8. Save to a data file" + "\n" +
                "9. Retreive phonebook from data file" + "\n" +
                "10. Quit" + "\n\n" +

                "Type a number to make a selection");

            selection = scan.nextLine(); //String type to accept all inputs
            switch (selection) {

                case "1": //Create a new phonebook
                    phonebook.clear();
                    System.out.println("The phonebook has been cleared.\n");
                    break;

                case "2": //Print the phonebook
                    printPhonebook(phonebook);
                    break;

                case "3": //Add person to the phonebook

                    System.out.println("Input the person's name:");
                    name = scan.nextLine();
                    System.out.println("Input the person's age:");
                    age = scan.nextInt();
                    System.out.println("Input the person's ID number:");
                    idNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Input the person's phone number:");
                    phoneNumber = scan.nextLine();
                    System.out.println("Input the person's zip code:");
                    zipCode = scan.nextInt();


                    phonebook.add(new LovelessPerson(name, age, idNumber, phoneNumber, zipCode));
                    break;

                case "4": //Remove a person from the phonebook
                    printPhonebook(phonebook);

                    success = false;
                    while (!success) {
                        System.out.println("Which person would you like to remove?");
                        int removalNumber = scan.nextInt() - 1;

                        if (removalNumber > 0 && removalNumber <= phonebook.size()) {
                            phonebook.remove(removalNumber);
                            success = true;
                        } else System.out.print("Invalid input. ");
                    }
                    break;

                case "5": //Sort
                    System.out.println("What would you like to sort by?" + "\n" +
                        "1. Name" + "\n" +
                        "2. Age" + "\n" +
                        "3. ID Number" + "\n" +
                        "4. Phone Number" + "\n" +
                        "5. Zip Code");
                    int sortNumber = scan.nextInt();
                    switch (sortNumber) {
                        case 1: //Name
                            for (int i = 0; i < phonebook.size(); i++) {
                                for (int j = i + 1; j < phonebook.size(); j++) {
                                    if (phonebook.get(i).name.toLowerCase().compareTo(phonebook.get(j).name.toLowerCase()) > 0) {
                                        LovelessPerson temp = phonebook.get(i);
                                        phonebook.set(i, phonebook.get(j));
                                        phonebook.set(j, temp);
                                    }
                                }
                            }
                            break;

                        case 2: //Age
                            for (int i = 0; i < phonebook.size(); i++) {
                                for (int j = i + 1; j < phonebook.size(); j++) {
                                    if (phonebook.get(i).age > phonebook.get(j).age) {
                                        LovelessPerson temp = phonebook.get(i);
                                        phonebook.set(i, phonebook.get(j));
                                        phonebook.set(j, temp);
                                    }
                                }
                            }
                            break;

                        case 3: //ID Number
                            for (int i = 0; i < phonebook.size(); i++) {
                                for (int j = i + 1; j < phonebook.size(); j++) {
                                    if (phonebook.get(i).idNumber > phonebook.get(j).idNumber) {
                                        LovelessPerson temp = phonebook.get(i);
                                        phonebook.set(i, phonebook.get(j));
                                        phonebook.set(j, temp);
                                    }
                                }
                            }
                            break;

                        case 4: //Phone Number
                            for (int i = 0; i < phonebook.size(); i++) {
                                for (int j = i + 1; j < phonebook.size(); j++) {
                                    if (phonebook.get(i).phoneNumber.toLowerCase().compareTo(phonebook.get(j).phoneNumber.toLowerCase()) > 0) {
                                        LovelessPerson temp = phonebook.get(i);
                                        phonebook.set(i, phonebook.get(j));
                                        phonebook.set(j, temp);
                                    }
                                }
                            }
                            break;

                        case 5: //Zip Code        
                            for (int i = 0; i < phonebook.size(); i++) {
                                for (int j = i + 1; j < phonebook.size(); j++) {
                                    if (phonebook.get(i).zipCode > phonebook.get(j).zipCode) {
                                        LovelessPerson temp = phonebook.get(i);
                                        phonebook.set(i, phonebook.get(j));
                                        phonebook.set(j, temp);
                                    }
                                }
                            }
                            break;
                    }

                    System.out.println("What order?" + "\n" +
                        "1. Ascending" + "\n" +
                        "2. Descending" + "\n");
                    if (scan.nextInt() == 2) Collections.reverse(phonebook);
                    printPhonebook(phonebook);


                    break;

                case "6": //Modify a person
                    printPhonebook(phonebook);

                    success = false;
                    while (!success) {
                        System.out.println("Which entry would you like to modify?");
                        int modifyNumber = scan.nextInt() - 1;
                        scan.nextLine();

                        if (modifyNumber > 0 && modifyNumber <= phonebook.size()) {
                            System.out.println("Modifying the entry for " + phonebook.get(modifyNumber).name + "...\n");

                            System.out.println("Input the person's name (originally \"" + phonebook.get(modifyNumber).name + "\"):");
                            name = scan.nextLine();
                            System.out.println("Input the person's age (originally \"" + phonebook.get(modifyNumber).age + "\"):");
                            age = scan.nextInt();
                            System.out.println("Input the person's ID number (originally \"" + phonebook.get(modifyNumber).idNumber + "\"):");
                            idNumber = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Input the person's phone number (originally \"" + phonebook.get(modifyNumber).phoneNumber + "\"):");
                            phoneNumber = scan.nextLine();
                            System.out.println("Input the person's zip code (originally \"" + phonebook.get(modifyNumber).zipCode + "\"):");
                            zipCode = scan.nextInt();
                            phonebook.set(modifyNumber, new LovelessPerson(name, age, idNumber, phoneNumber, zipCode));
                            success = true;
                        } else System.out.print("Invalid input. ");
                    }

                    break;

                case "7": //Search for a person by name
                    matches.clear();
                    System.out.println("Enter the name of the person:");
                    String searchTerm = scan.nextLine();
                    for (LovelessPerson person: phonebook) {
                        if (person.name.toLowerCase().contains(searchTerm.toLowerCase())) {
                            matches.add(person);
                        }
                    }
                    System.out.println("Matches: " + matches.size());

                    if (matches.size() > 0) printPhonebook(matches);
                    else System.out.println("\n");
                    break;

                    //8 and 9 return errors

                case "10": //Quit
                    return;


                default:
                    System.out.println("Invalid input.\n");
                    break;
            }
        }
    }

    public static void printPhonebook(ArrayList < LovelessPerson > phonebook) {
        String format = "%-20s %-20s %-20s %-20s %-20s %-20s\n";
        System.out.printf(format, "", "Name", "Age", "ID Number", "Phone Number", "Zip Code");



        for (int i = 0; i < phonebook.size(); i++) {



            LovelessPerson printPerson = phonebook.get(i);
            System.out.printf(format, (i + 1), printPerson.name, printPerson.age, printPerson.idNumber, printPerson.phoneNumber, printPerson.zipCode);
            //System.out.println((i+1) + "\t" + printPerson.name + "\t\t\t\t" + printPerson.age + "\t\t\t\t" + printPerson.idNumber + "\t\t\t\t" + printPerson.phoneNumber + "\t\t\t\t" + printPerson.zipCode );
        }
        System.out.println("\n");
    }

}