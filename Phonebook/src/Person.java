import java.util.Random;

public class Person {
    private int id;
    private String name;
    private String number;
    private int calls;

    public String getName() {
        return name;
    }

    public int getCalls() {
        return calls;
    }

    public int getId() {
        return id;
    }

    public Person(String name, int id, String number) {
        Random rand = new Random();
        this.id = id;
        this.name = name;
        this.number = number;
        this.calls = rand.nextInt(7);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toDatabase(){
        return id + "/" + name + "/" + number + "/" + calls;
    }
    @Override
    public String toString() {
        return id + ". " + name + " has number " + number + " and was called " + calls + " times.";
    }
}
