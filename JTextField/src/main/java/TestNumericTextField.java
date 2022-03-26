import javax.swing.JFrame;
import java.awt.FlowLayout;


public class TestNumericTextField {
    public static void main(String[] args) {
        JFrame fm = new JFrame("Prueba de JTextField con entrada numerica");

        fm.setSize(640, 480);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setLayout( new FlowLayout(FlowLayout.CENTER, 20, 20) );

        NumericTextField ntf = new NumericTextField(20);

        fm.add(ntf);
        fm.setVisible(true);
    }
}
