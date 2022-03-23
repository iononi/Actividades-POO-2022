/**
 * This class represent a Dog object.
 * Also, implements the Print interface.
 * @author Eduardo Ruiz Rios
 * @version 1.0, 18/03/2022
 * */

public class Dog implements Print {

    /**
     * The dog's name represented by a String.
     * */
    private String name;
    /**
     * The dog's age.
     * **/
    private int age;

    /**
     * Constructor of Dog Class.
     * @param name A String object representing the dog's name.
     * @param age The current age of the dog.
     * */
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    /**
     * @return A String representation of the dog.
     * */
    @Override
    public String toString() {
        return String.format("Dog Name: %s, Age: %d", this.name, this.age);
    }

    /**
     * Call the method toString() to print on console the String representation of the Dog.
     * */
    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
