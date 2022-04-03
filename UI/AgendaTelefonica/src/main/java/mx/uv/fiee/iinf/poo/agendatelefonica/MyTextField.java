package mx.uv.fiee.iinf.poo.agendatelefonica;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyTextField extends JTextField {

    public MyTextField () {
        super ();

        this.setColumns (13);

        addKeyListener(new KeyListener () {
            @Override
            public void keyTyped (KeyEvent e) {
                if ( !(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '(' || e.getKeyChar() == ')' || e.getKeyChar() == ' ')
                        || (e.getKeyChar() == '(' && MyTextField.this.getText().contains("(")) || (e.getKeyChar() == ')' && MyTextField.this.getText().contains(")"))
                        || (e.getKeyChar() == ' ' && MyTextField.this.getText().contains(" ")) || MyTextField.this.getText().length() == 13 ) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased (KeyEvent e) {
                if ( !MyTextField.this.getText().matches("\\([\\d]{3}\\) [\\d]{7}") ) {
                    MyTextField.this.setBackground(Color.RED);
                    MyTextField.this.setForeground(Color.WHITE);
                } else {
                    MyTextField.this.setBackground(Color.WHITE);
                    MyTextField.this.setForeground(Color.BLACK);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}
        });
    }

}
