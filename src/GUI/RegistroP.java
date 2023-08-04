package GUI;

import javax.swing.*;

public class RegistroP {
    private JPanel rootPanel;
    private JTextField inputCod;
    private JTextField inputCedula;
    private JTextField inputNombre;
    private JTextField inputFechaNac;
    private JComboBox comboBoxSignoZ;
    private JButton botonBorrarElPresenteButton;
    private JButton botonActualizarElPresenteButton;
    private JButton botonIngresarElPresenteButton;
    private JButton limpiarFormularioButton;
    private JButton botonBuscarPorSignoButton;
    private JButton botonBuscarPorNombreButton;
    private JButton botonBuscarPorCódigoButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro Personas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setContentPane(new RegistroP().rootPanel);
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
    }
}
