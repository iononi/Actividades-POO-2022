public class Family<T extends Print> {

    private T father;
    private T mother;
    private T[] children;

    public Family(T father, T mother, T[] children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public T getFather() {
        return father;
    }

    public T getMother() {
        return mother;
    }

    public T getChild(int index) {
        return children[index];
    }
}
