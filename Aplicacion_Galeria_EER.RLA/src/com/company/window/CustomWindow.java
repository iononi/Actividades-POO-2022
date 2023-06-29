package com.company.window;
//SegundoParcial Aplicacion Galeria// Eduardo Ruiz Rios & Roberto Lagunes Alvarez
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomWindow extends JFrame {

    private final JPanel PANEL;
    private final JLabel ETIQUETA;

    String[] urls = {"https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150593-768x510.jpg",
    "http://www.thelandofsnows.com/wp-content/uploads/2012/05/DSC01533.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150256-768x512.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150651-2-768x444-1456047722.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150447-768x522.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/03/Nepal-EBC22-1024x683.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20160176-768x509.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2013/03/EBC-1024x683.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150352-768x590.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150299-768x512.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150335-768x495.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/07/untitled20150004-2-1024x682.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2015/05/untitled20150427-768x512.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2016/03/untitled20150491-768x498.jpg",
    "https://www.thelandofsnows.com/wp-content/uploads/2016/03/untitled20150534-768x512.jpg"};

    public CustomWindow() {
        PANEL = new JPanel();
        ETIQUETA = new JLabel();
        setSize(800,500); //Tamaño de la ventana
        setLayout( new BorderLayout() );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Termina la ejecucion del programa cerrando la ventana
        setTitle("Aplicacion Galeria"); //Establecemos el titulo de la ventana
        setLocationRelativeTo(null); //Ponemos la ventana en el centro de la pantalla
        //setResizable(false); //La ventana no podra cambiar tamaño
        this.getContentPane().setBackground(Color.DARK_GRAY); //Establecemos un color gris de fondo
        componentes();
        obtenRecursos();
    }

    private void componentes() {
        PANEL.setBackground(Color.orange); //Color del PANEL Fondo
        this.getContentPane().add(PANEL, BorderLayout.CENTER); //Agregamos el PANEL creado en el centro del Frame
        PANEL.setLayout( new GridLayout(3, 3, 3, 3) );

        ETIQUETA.setText("Galeria de Imagenes"); //Texto ETIQUETA
        ETIQUETA.setHorizontalAlignment(SwingConstants.CENTER); // Alineamos el texto al centro
        ETIQUETA.setForeground(Color.white); //Color letra ETIQUETA
        ETIQUETA.setFont(new Font("Arial", Font.PLAIN,50));//Fuente del texto
        this.add(ETIQUETA, BorderLayout.NORTH); // Agregamos la ETIQUETA en la parte superior del Frame
    }

    private void obtenRecursos() {
        // Por cada imagen, obtenemos y procesamos los recursos, y agregamos al JPanel
        for (String url: urls) {
            //Galeria de Imagenes
            try {
                URL myURL = new URL(url);
                BufferedImage myImage = ImageIO.read(myURL); // Leemos la imagen contenida en este recurso
                Image img = myImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT); // redimensionamos la imagen
                JLabel image = new JLabel( new ImageIcon(img) );
                image.setToolTipText(myURL.toExternalForm()); // Tool tip con la url de donde se obtuvo la imagen
                PANEL.add(image, BorderLayout.CENTER); // Agregamos la imagen al PANEL
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this.getContentPane(), e, "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                Logger.getLogger(CustomWindow.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

}
