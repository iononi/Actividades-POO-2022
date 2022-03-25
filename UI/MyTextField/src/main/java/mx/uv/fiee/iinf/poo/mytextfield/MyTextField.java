package mx.uv.fiee.iinf.poo.mytextfield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class MyTextField extends JTextField implements KeyListener {
    
    public MyTextField () {
        this.addKeyListener (this);
    }
    
    @Override
    public void keyTyped (KeyEvent e) {
        if ( (!((e.getKeyChar () >= '0' && e.getKeyChar () <= '9') || e.getKeyChar () == '-')) ||
                (e.getKeyChar () == '-' && this.getText ().contains ("-")) ) {

            e.consume ();

        }
    }

    @Override
    public void keyPressed (KeyEvent e) {
    }

    @Override
    public void keyReleased (KeyEvent e) {
    }

    @Override
    public void paint (Graphics g) {
        super.paint (g);

//        g.setColor (Color.red);
//        g.drawRect (getSize ().width - 25, getSize ().height - 30, 20, 20);
//
//        g.setColor(Color.red);
//        g.fillRect (getSize ().width - 25, getSize ().height - 30, 20, 20);
//
//        g.dispose ();

        try {
            URL url = getClass ().getResource ("/images/ico.png");
            File file = new File (url.getPath ());
            BufferedImage img = ImageIO.read (file);
            g.drawImage (img, getSize ().width - 30, getSize ().height - 30, null);
        }
        catch (IOException ex) {
            System.out.println (ex.getMessage ());
        }
    }

    
    
    
}
