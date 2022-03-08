package mx.uv.fiee.iinf.nopattern;

public class Main {

    public static void main(String[] args) {
        var nosql = new NoSQLEngine ();
        nosql.createNoSQLEngine ();

        var rel = new RelationalEngine ();
        rel.createRelationalEngine ();

        var vic = new VictorianChair ();
        vic.createVictorianChair ();

        var mod = new ModernChair ();
        mod.createModernChair ();
    }

}
