
package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Producto;

public class FIAgregarProducto extends JInternalFrame {
    private JLabel labelNombre;
    private JTextField textNombre;
    private JLabel labelCantidad;
    private JButton buttonLimpiar;
    private JButton buttonAgregar;
    private JTextField textPrecio;
    private JLabel labelPrecio;
    private JTextField textCantidad;
    private JTextField textId;
    private JLabel labelId;
    
    public FIAgregarProducto() {
        initGUI();
    }
    
    private void initGUI() {
        setTitle("Agregar Producto");
        setVisible(true);
        setClosable(true);
        getContentPane().setLayout(new GridLayout(5, 2, 0, 0));
        {
            labelId = new JLabel();
            getContentPane().add(labelId);
            labelId.setText("Id");
        }
        {
            textId = new JTextField();
            getContentPane().add(textId);
        }
        {
            labelNombre = new JLabel();
            getContentPane().add(labelNombre);
            labelNombre.setText("Nombre");
        }
        {
            textNombre = new JTextField();
            getContentPane().add(textNombre);
        }
        {
            labelCantidad = new JLabel();
            getContentPane().add(labelCantidad);
            labelCantidad.setText("Cantidad");
        }
        {
            textCantidad = new JTextField();
            getContentPane().add(textCantidad);
        }
        {
            labelPrecio = new JLabel();
            getContentPane().add(labelPrecio);
            labelPrecio.setText("Precio");
        }
        {
            textPrecio = new JTextField();
            getContentPane().add(textPrecio);
        }
        {
            buttonAgregar = new JButton();
            getContentPane().add(buttonAgregar);
            buttonAgregar.setText("Agregar");
            buttonAgregar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    buttonAgregarActionPerformed(evt);
                }
            });
        }
        {
            buttonLimpiar = new JButton();
            getContentPane().add(buttonLimpiar);
            buttonLimpiar.setText("Limpiar");
            buttonLimpiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    buttonLimpiarActionPerformed(evt);
                }
            });
        }
        setSize(250, 150);
    }
    
    private void buttonAgregarActionPerformed(ActionEvent evt) {
        Producto producto = new Producto(Integer.parseInt(this.textId.getText()), this.textNombre.getText(), Integer.parseInt(this.textCantidad.getText()), Long.parseLong(this.textPrecio.getText()));
        JOptionPane.showMessageDialog(this, producto.insertar(), "Agregar", JOptionPane.INFORMATION_MESSAGE);
        buttonLimpiarActionPerformed(evt);
    }
    
    private void buttonLimpiarActionPerformed(ActionEvent evt) {
        textId.setText("");
        textNombre.setText("");
        textCantidad.setText("");
        textPrecio.setText("");
    }
    
}
