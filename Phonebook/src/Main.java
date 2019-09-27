import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Phonebook phonebook = new Phonebook();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readFromFile(phonebook);
        System.out.println("Welcome to your phonebook. List of commands: ");
        printCommands();
        String input = "";
        input = reader.readLine()
                .toLowerCase();
        do{
            switch(input){
                case "1":
                    addPerson(phonebook, reader);
                    break;
                case "2":
                    System.out.println("ID: ");
                    String text = reader.readLine();
                    int id = Integer.parseInt(text);
                    phonebook.deletePerson(id);
                    break;
                case "3":
                    phonebook.printBook();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
            printCommands();
            input = reader.readLine()
                    .toLowerCase();
        } while(!("4".equals(input)));

        writeToFile(phonebook);
    }

    private static void writeToFile(Phonebook phonebook) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\n_bos\\IdeaProjects\\Phonebook\\Database.txt");
        try(PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Person person : phonebook.getPeople()) {
                printWriter.println(person.toDatabase());
            }
        }
    }

    private static void readFromFile(Phonebook phonebook) throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:\\Users\\n_bos\\IdeaProjects\\Phonebook\\Database.txt");
        try(Scanner buffFileReader = new Scanner(fileReader)){
            while(buffFileReader.hasNext()){
                String[] split = buffFileReader.nextLine().split("/");
                phonebook.addPerson(phonebook.createPerson(split[1], split[2]));
            }
        }
    }

    private static void printCommands() {
        System.out.println("1. Add a new contact.");
        System.out.println("2. Remove a contact.");
        System.out.println("3. Print all contacts.");
        System.out.println("4. Exit");
    }

    private static void addPerson(Phonebook phonebook, BufferedReader reader) throws IOException {
        System.out.println("Name: ");
        String name = reader.readLine();
        System.out.println("Number: ");
        String number = reader.readLine();
        phonebook.addPerson(phonebook.createPerson(name, number));
    }
}
