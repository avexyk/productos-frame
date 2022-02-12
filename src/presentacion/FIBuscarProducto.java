
package presentacion;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logica.Producto;

public class FIBuscarProducto extends JInternalFrame {
    
    private JTextField textFiltro;
    private JTable tableResultados;
    private JScrollPane scrollPaneResultados;
    
    public FIBuscarProducto() {
        initGUI();
    }
    
    private void initGUI() {
        setTitle("Buscar Producto");
        setVisible(true);
        setClosable(true);
        getContentPane().setLayout(new BorderLayout());
        {
            textFiltro = new JTextField();
            getContentPane().add(textFiltro, BorderLayout.NORTH);
            textFiltro.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent evt) {
                    textFiltroKeyReleased(evt);
                }
            });
        }
        {
            scrollPaneResultados = new JScrollPane();
            getContentPane().add(scrollPaneResultados, BorderLayout.CENTER);
            {
                tableResultados = new JTable();
                scrollPaneResultados.setViewportView(tableResultados);
                tableResultados.setPreferredSize(new java.awt.Dimension(250, 100));
            }
        }
        setSize(250, 150);
    }
    
    private void textFiltroKeyReleased(KeyEvent evt) {
        Producto producto = new Producto();
        String [][] datos = producto.buscar(this.textFiltro.getText());
        String [] titulos = new String[] {"Id", "Nombre", "Cantidad", "Precio"};
        TableModel tableModelResultados = new DefaultTableModel(datos, titulos);
        tableResultados.setModel(tableModelResultados);
        tableResultados.setPreferredSize(new java.awt.Dimension(350, datos.length*16));
        TableRowSorter ordenador = new TableRowSorter(tableModelResultados);
        this.tableResultados.setRowSorter(ordenador);
    }
    
}
