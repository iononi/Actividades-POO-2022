package mx.uv.fiee.iinf.poo;

public class ChairFactory implements IFactory<IChair> {
    @Override
    public IChair create (String type) {
        switch (type) {
            case "Victorian":
                var vChair =  new VictorianChair ();
                vChair.createChair ();
                return vChair;
            case "Modern":
                var mChair = new ModernChair ();
                mChair.createChair ();
                return mChair;
            default:
                throw new IllegalArgumentException ();
        }
    }
}
