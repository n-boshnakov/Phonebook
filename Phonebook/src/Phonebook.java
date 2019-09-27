import java.util.ArrayList;

public class Phonebook {
    private ArrayList<Person> people;

    public Phonebook() {
        this.people = new ArrayList<>();
    }

    public Person createPerson(String name, String number){
        return new Person(name, people.size() + 1, number);
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void deletePerson(int id){
        for (Person person:people) {
            if(id == person.getId()){
                people.remove(person);
                System.out.println(person.getName() + " removed from contacts.");
                break;
            }
        }
    }

    public void printBook(){
        for (Person person:people) {
            System.out.println(person);
        }
    }
}
