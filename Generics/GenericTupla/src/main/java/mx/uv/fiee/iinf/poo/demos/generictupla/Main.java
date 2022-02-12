package mx.uv.fiee.iinf.poo.demos.generictupla;

public class Main {
    
    public static void main (String [] args) {
        GenericTupla<Integer, String> point1 = new GenericTupla<>(1, "Eduardo");
        GenericTupla<Integer, String> point2 = new GenericTupla<>(2, "Eduardo");
        ObjectTupla objTuple = new ObjectTupla(3, "Mimi");
        boolean isEqual = Utilities.compare(point1, point2);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(objTuple);
        System.out.println("Checking tuples' equality using equals method: " + point1.equals(point2));
        System.out.println("Checking tuples' equiality using Utilities.compare method: " + isEqual);
        System.out.println("Comparing point1 and objTuple: " + Utilities.compare(point1, objTuple));
    }

}
