package mx.uv.fiee.iinf.poo.agendatelefonica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Clase que representa nuestra interfaz para la agenda telefónica
 */
class Agenda extends JFrame {
    private JTextField tfName; // campos de datos
    private JButton btnAdd, btnDelete, btnSave; // acciones
    private MyTextField tfPhone; //JTextfield personalizado
    // JTable nos sirve para almacenar el listado de datos que deseamos mostrar al usuario
    private JTable table;
    private DefaultTableModel model; // JTable utiliza un modelo para mantener referencia a los datos

    public Agenda() {
        super("Agenda Telefónica");

        tfName = new JTextField(); // instanciamos al JTextField nombre
        tfPhone = new MyTextField(); // instanciamos al JTextField teléfono
        tfPhone.setToolTipText("Format: (###) #######"); // establecemos un mensaje de ayuda al usuario

        btnAdd = new JButton("Add"); // instanciamos al botón ADD
        // manejador del evento clic del botón ADD
        btnAdd.addActionListener(new ActionListener() {
            /**
             * cada vez que el usuario hace clic se ejecuta el método actionPerformed
             *
             * @param e parámetro con información de la fuente del evento
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // validamos que los campos no estén vacíos
                if (tfPhone.getText().matches("\\([\\d]{3}\\) [\\d]{7}") && tfName.getText().length() > 0) {
                    // anexamos los valores de los campos al modelo
                    model.addRow(new String[]{tfName.getText(), tfPhone.getText()});
                }

                // si alguno de los campos está vacío, pasamos el foco a él
                if (tfName.getText().length() == 0)
                    tfName.grabFocus();
                else if (tfPhone.getText().length() == 0 || !tfPhone.getText().matches("\\([\\d]{3}\\) [\\d]{7}"))
                    tfPhone.grabFocus();

                if ( tfName.getText().length() > 0 && tfPhone.getText().matches("\\([\\d]{3}\\) [\\d]{7}") ) {
                    tfName.setText("");
                    tfPhone.setText("");
                    tfPhone.setBackground(Color.WHITE);
                    tfPhone.setForeground(Color.BLACK);
                }
            }
        });

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agenda.this.saveOnFile();
            }
        });

        btnDelete = new JButton("Delete"); // instanaciamos al botón ELIMINAR
        // manejador del evento clic del botón ELIMINAR
        btnDelete.addActionListener(new ActionListener() {
            /**
             * cada vez que el usuario hace clic se ejecuta el método actionPerformed
             *
             * @param e parámetro con información de la fuente del evento
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() > -1) { // validamos si existe algún elemento seleccionado
                    model.removeRow(table.getSelectedRow()); // si existe, se elimina del modelo
                    Agenda.this.saveOnFile();
                }

            }
        });

        // definimos la estructura del modelo que será utilizado por el JTable
        model = new DefaultTableModel();
        model.addColumn("Nombre"); // constará de dos columnas, nombre
        model.addColumn("Teléfono"); // y teléfono
        loadtoTable();

        // creamos al JTable y definimos algunas características
        table = new JTable(model);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);

        // como contenedor para los campos de datos usamos un JPanel
        // con un layout tipo GridLayout de 2 x 2
        JPanel pnlFields = new JPanel();
        pnlFields.setLayout(new GridLayout(2, 2));

        // agreamos los controles al panel de campos de datos
        pnlFields.add(new JLabel("Nombre: ")); // la etiqueta no requiere más que instanciación con el texto correspodiente
        pnlFields.add(tfName);
        pnlFields.add(new JLabel("Teléfono: "));
        pnlFields.add(tfPhone);

        // para organizar al panel de campos + el botón de acción ADD, utilizamos un BoxLayout
        // con alineación vertical
        JPanel pnlTOP = new JPanel();
        BoxLayout boxLayout = new BoxLayout(pnlTOP, BoxLayout.Y_AXIS);
        pnlTOP.setLayout(boxLayout);
        pnlTOP.add(pnlFields);
        pnlTOP.add(btnAdd);
        pnlTOP.add(btnSave);

        // al botón ELIMINAR lo colocamos en un contenedor JPanel, con el objetivo de agegar más controles
        // en esa sección posteriormente
        JPanel pnlBOTTOM = new JPanel();
        pnlBOTTOM.add(btnDelete);

        // establecemos las dimensiones iniciales
        setSize(new Dimension(300, 400));
        setLayout(new BorderLayout()); // y definimos al BorderLayout como layout principal

        // colocamos cada uno de los páneles y controles que corresponden a las secciones,
        // arriba, centro, abajo
        // pnlTOP -> pnlFields + botón ADD
        // table -> JTable para el listado
        // pnlBOTTOM -> botón ELIMINAR
        add(BorderLayout.NORTH, pnlTOP);
        add(BorderLayout.CENTER, table);
        add(BorderLayout.SOUTH, pnlBOTTOM);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // establece el comportamiento de cierre
    }

    private void saveOnFile() {
        try {
            File f = new File("Agenda.txt");
            if ( !f.exists() ) {
                try {
                    f.createNewFile();
                }catch (IOException ex) {
                    JOptionPane.showMessageDialog(Agenda.this, "Failed while creating 'Agenda.txt' file",
                            "Error creating file", JOptionPane.ERROR_MESSAGE);
                }
            }
            FileOutputStream fos = new FileOutputStream(f, false);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (int i = 0; i < table.getRowCount(); i++) {
                String name = "", phone = "";
                for (int j = 0; j < table.getColumnCount() - 1; j++) {
                    name = (String) table.getValueAt(i, j);
                    phone = (String) table.getValueAt(i, j + 1);
                }
                bw.write(String.format("%s:%s\r\n", name, phone));
            }
            bw.close();
            osw.close();
            fos.close();

        }catch (IOException ex) {
            JOptionPane.showMessageDialog(Agenda.this, "Error saving contacts",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadtoTable() {
        File f = new File("Agenda.txt");
        if ( !f.exists() ) {
            try{
                f.createNewFile();
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(Agenda.this, "Failed while creating 'Agenda.txt' file",
                        "Error creating file", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String[] data;
            String line = "";
            while ( (line = br.readLine()) != null ) {
                data = line.split(":");
                model.addRow(data);
            }
            br.close();
            fr.close();
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(Agenda.this, "Failed while reading 'Agenda.txt' file",
                    "File 'Agenda.txt' not found", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}