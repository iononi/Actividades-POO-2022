public class Human implements Print {

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("Human Name: %s, Age: %d", this.name, this.age);
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
