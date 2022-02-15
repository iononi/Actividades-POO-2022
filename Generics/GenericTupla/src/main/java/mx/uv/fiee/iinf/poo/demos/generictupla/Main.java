package mx.uv.fiee.iinf.poo.demos.generictupla;

public class Main {

    public static void main (String [] args) {
        GenericTupla<Integer, Integer> point1 = new GenericTupla<>(1, 5);
        GenericTupla<Integer, Integer> point2 = new GenericTupla<>(1, 15);

        boolean result = Utilities.compare (point1, point2);
        System.out.println (result);

        boolean result2 = Utilities.compare ("Hola", "Hola");
        System.out.println (result2);

        boolean result3 = Utilities.compare (3.0, 3.0);
        System.out.println (result3);
    }

}
