package mx.uv.fiee.iinf.poo;

public class DbEngineFactory implements IFactory<IDbEngine> {
    @Override
    public IDbEngine create (String type) {
        switch (type) {
            case "Relational":
                var rel = new RelationalEngine ();
                rel.createEngine ();
                return rel;
            case "NoSQL":
                var nosql = new NoSQLEngine ();
                nosql.createEngine ();
                return nosql;
            default:
                throw new IllegalArgumentException ();
        }
    }
}
