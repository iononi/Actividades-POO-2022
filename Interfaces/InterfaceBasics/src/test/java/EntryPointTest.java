import mx.uv.fiee.iinf.poo.Draw;
import mx.uv.fiee.iinf.poo.Rectangle;
import mx.uv.fiee.iinf.poo.Circle;
import org.junit.Assert;
import org.junit.Test;

public class EntryPointTest {

    @Test
    public void RectangleTest() {
        Rectangle rec1 = new Rectangle(4, 10, Draw.BLACK, Draw.WHITE);
        Rectangle rec2 = new Rectangle(2, 20, Draw.BLUE, Draw.RED);
        Assert.assertEquals(rec1.compareTo(rec2), 0);
    }

    @Test
    public void CircleTest() {
        Circle cir1 = new Circle(4, Draw.GREEN, Draw.RED);
        Circle cir2 = new Circle(5, Draw.BLACK, Draw.BLACK);
        Assert.assertEquals(cir1.compareTo(cir2), -1);
    }

}
