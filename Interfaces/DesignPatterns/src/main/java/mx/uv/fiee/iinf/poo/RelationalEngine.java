package mx.uv.fiee.iinf.poo;

/**
 * IDbEngine implementation with procedure needed to build a Relational Engine
 */
public class RelationalEngine implements IDbEngine {
    @Override
    public void engineProps () {
        System.out.println ("Relational DB Engine created!");
    }
}
