package mx.uv.fiee.iinf.poo;

/**
 * IFactory implementation for IDbEngine
 */
public class DbEngineFactory implements IFactory<IDbEngine> {
    @Override
    public IDbEngine create (String type) {
        switch (type) {
            case "Relational":
                var rel = new RelationalEngine ();
                rel.engineProps ();
                return rel;
            case "NoSQL":
                var nosql = new NoSQLEngine ();
                nosql.engineProps ();
                return nosql;
            default:
                throw new IllegalArgumentException ();
        }
    }
}
