
package mx.uv.fiee.iinf.poo.demos.generictupla;

/**
 * 
 * @author Eduardo Ruiz Rios <eduardo.ruiz.rios09 at gmail.com>
 */
public class Utilities {
    public static <T, U> boolean compare(T firstTuple, U secondTuple) {
        if (firstTuple instanceof GenericTupla && secondTuple instanceof GenericTupla) {
            GenericTupla myTuple = (GenericTupla) firstTuple;
            GenericTupla anotherTuple = (GenericTupla) secondTuple;
            return myTuple.getKey().equals(anotherTuple.getKey()) && myTuple.getValue().equals(anotherTuple.getValue());
        }
        return false;
    }
}
