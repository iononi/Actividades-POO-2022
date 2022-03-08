package mx.uv.fiee.iinf.poo;

public class Main {

    public static void main (String [] args) throws NullPointerException {
        var factory = getProvider ("Chair");
        factory.create ("Victorian");
        factory.create ("Modern");

        var factory2 = getProvider ("DbEngine");
        factory2.create ("NoSQL");
    }

    private static IFactory getProvider (String choice) {
        if (choice.equalsIgnoreCase ("DbEngine")) {
            return new DbEngineFactory ();
        } else if (choice.equalsIgnoreCase ("Chair")) {
            return new ChairFactory ();
        } else {
            return null;
        }
    }

}
