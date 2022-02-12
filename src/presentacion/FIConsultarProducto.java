
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

public class FIConsultarProducto extends JInternalFrame {
    private JLabel labelNombre;
    private JTextField textNombre;
    private JLabel labelCantidad;
    private JButton buttonActualizar;
    private JButton buttonConsultar;
    private JButton buttonEliminar;
    private JButton buttonCerrar;
    private JTextField textPrecio;
    private JLabel labelPrecio;
    private JTextField textCantidad;
    private JTextField textId;
    private JLabel labelId;
    
    public FIConsultarProducto() {
        initGUI();
    }
    
    private void initGUI() {
        setTitle("Consultar Producto");
        setVisible(true);
        setClosable(true);
        getContentPane().setLayout(new GridLayout(6, 2, 0, 0));
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
            buttonConsultar = new JButton();
            getContentPane().add(buttonConsultar);
            buttonConsultar.setText("Consultar");
            buttonConsultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    buttonConsultarActionPerformed(evt);
                }
            });
        }
        {
            buttonActualizar = new JButton();
            getContentPane().add(buttonActualizar);
            buttonActualizar.setText("Actualizar");
            buttonActualizar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    buttonActualizarActionPerformed(evt);
                }
            });
        }
        {
            buttonEliminar = new JButton();
            getContentPane().add(buttonEliminar);
            buttonEliminar.setText("Eliminar");
            buttonEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    buttonEliminarActionPerformed(evt);
                }
            });
        }
        {
            buttonCerrar = new JButton();
            getContentPane().add(buttonCerrar);
            buttonCerrar.setText("Cerrar");
            buttonCerrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    dispose();
                }
            });
        }
        setSize(300, 150);
    }
    
    private void buttonConsultarActionPerformed(ActionEvent evt) {
        Producto producto = new Producto(Integer.parseInt(this.textId.getText()));
        if (producto.consultar()) {
            this.textNombre.setText(producto.getNombre());
            this.textCantidad.setText(String.valueOf(producto.getCantidad()));
            this.textPrecio.setText(String.valueOf(producto.getPrecio()));
        } else {
            JOptionPane.showMessageDialog(this, "No hay resultados", "Consultar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void buttonActualizarActionPerformed(ActionEvent evt) {
        Producto producto = new Producto(Integer.parseInt(this.textId.getText()), this.textNombre.getText(), Integer.parseInt(this.textCantidad.getText()), Long.parseLong(this.textPrecio.getText()));
        JOptionPane.showMessageDialog(this, producto.actualizar(), "Actualizar", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void buttonEliminarActionPerformed(ActionEvent evt) {
        Producto producto = new Producto(Integer.parseInt(this.textId.getText()));
        if (producto.consultar()) {
            producto.eliminar();
            JOptionPane.showMessageDialog(this, "Producto eliminado", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No existe el producto", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
