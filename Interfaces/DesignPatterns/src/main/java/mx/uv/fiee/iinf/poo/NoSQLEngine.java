package mx.uv.fiee.iinf.poo;

public class NoSQLEngine implements IDbEngine {
    @Override
    public void createEngine () {
        System.out.println ("NoSQL DB Engine created!");
    }
}
