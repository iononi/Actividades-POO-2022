import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumericTextField extends JTextField {

    public NumericTextField (int columns) {
        super.setColumns(columns);
        this.addKeyListener ( new KeyListener() {
            @Override
            public void keyTyped (KeyEvent e) {
                if ( !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '(' || e.getKeyChar() == ')' || e.getKeyChar() == ' ')
                      || (e.getKeyChar() == '(' && NumericTextField.this.getText().contains("(")) || (e.getKeyChar() == ')' && NumericTextField.this.getText().contains(")"))
                        || (e.getKeyChar() == ' ' && NumericTextField.this.getText().contains(" ")) || NumericTextField.this.getText().length() == 13 ) {
                    e.consume();
                }

                if ( !NumericTextField.this.getText().matches("\\([\\d]{3}\\)[ ]{1}[\\d]{7}") ) {
                    NumericTextField.this.setBackground(Color.RED);
                    NumericTextField.this.setForeground(Color.WHITE);
                }

                if ( NumericTextField.this.getText().length() == 12 && NumericTextField.this.getText().matches("\\([\\d]{3}\\)[ ]{1}[\\d]{6}") ) {
                    NumericTextField.this.setBackground(Color.WHITE);
                    NumericTextField.this.setForeground(Color.RED);
                }
            }

            @Override
            public void keyPressed (KeyEvent e) {

            }

            @Override
            public void keyReleased (KeyEvent e) {

            }
        });
    }
}