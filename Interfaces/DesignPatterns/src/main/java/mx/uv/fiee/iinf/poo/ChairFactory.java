package mx.uv.fiee.iinf.poo;

/**
 * IFactory implementation for IChair
 */
public class ChairFactory implements IFactory<IChair> {
    @Override
    public IChair create (String type) {
        switch (type) {
            case "Victorian":
                var vChair =  new VictorianChair ();
                vChair.chairProps ();
                return vChair;
            case "Modern":
                var mChair = new ModernChair ();
                mChair.chairProps ();
                return mChair;
            default:
                throw new IllegalArgumentException ();
        }
    }
}
