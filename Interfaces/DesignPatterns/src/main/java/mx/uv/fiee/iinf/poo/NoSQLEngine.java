package mx.uv.fiee.iinf.poo;

/**
 * IDbEngine implementation with procedure needed to build a NoSQL Engine
 */
public class NoSQLEngine implements IDbEngine {
    @Override
    public void engineProps () {
        System.out.println ("NoSQL DB Engine created!");
    }
}
