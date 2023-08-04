package GUI;

//importacion de clases en Package
import Conexion.ConexionBD;
import PersonaBL.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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


    //-----------------------INGRESAR-----------------------------------------
    public RegistroP() {
        botonIngresarElPresenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mandar a llamar al metodo recuperar
                Persona persona1=recuperarDatosGUI();
                //se instancia un objeto de la clase conexion para ejecutar el Query
                ConexionBD conexionMySQL= new ConexionBD();
                //Declaracion de la sentencia insert
                //la info de la GUI a la clase y de la clase a la setencia
                String sentenciaInsert = String.format("INSERT INTO Personas (Codigo, Cedula, Nombre, FechaNac, Signo)" +
                        "VALUES ('%s','%s','%s','%s','%s');",persona1.getCodigo(),persona1.getCedula(),persona1.getNombre(),persona1.getFechaNac(),persona1.getSignoZ());

                //llamar al metodo para hacer el insert
                conexionMySQL.ejecutarQuery(sentenciaInsert);
            }
        });
        //--------------------UPDATE-----------------------------------------
        botonActualizarElPresenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD conexionMysql=new ConexionBD();
                Persona personaUpdate = recuperarDatosGUI();
                String strSetenciaUpdate=String.format("UPDATE personas set Nombre='%s' WHERE Codigo='%s';",personaUpdate.getNombre(),personaUpdate.getCodigo());
                conexionMysql.ejecutarQuery(strSetenciaUpdate);
            }
        });
        botonBorrarElPresenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD conexionMySQL = new ConexionBD();
                Persona personaDelete =recuperarDatosGUI();
                String strSetenciaDelete=String.format("DELETE FROM personas WHERE Codigo=%s",personaDelete.getCodigo());
                conexionMySQL.ejecutarQuery(strSetenciaDelete);
            }
        });
        botonBuscarPorCódigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD conexionMySql=new ConexionBD();
                Persona personaConsulta=recuperarDatosGUI();
                try{
                    ResultSet resultado = conexionMySql.consultarRegistros(String.format("SELECT * FROM personas WHERE Codigo='%s';",personaConsulta.getCodigo()));
                    //la info obtenida debe ser leida
                    while (resultado.next()){
                        //Con esto se lee la info que está en cada columna, por eso se deben poner los labelcolumn como estan en la BD
                        System.out.println(resultado.getString("Codigo"));
                        System.out.println(resultado.getString("Cedula"));
                        System.out.println(resultado.getString("Nombre"));
                        System.out.println(resultado.getString("FechaNac"));
                        System.out.println(resultado.getString("Signo"));
                    }
                }catch (Exception excp){
                    System.out.println("Hubo un error: "+excp);
                }
            }
        });
        botonBuscarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD conexionMySql=new ConexionBD();
                Persona personaConsulta=recuperarDatosGUI();
                try{
                    ResultSet resultado = conexionMySql.consultarRegistros(String.format("SELECT * FROM personas WHERE Nombre='%s';",personaConsulta.getNombre()));
                    //la info obtenida debe ser leida
                    while (resultado.next()){
                        //Con esto se lee la info que está en cada columna, por eso se deben poner los labelcolumn como estan en la BD
                        System.out.println(resultado.getString("Codigo"));
                        System.out.println(resultado.getString("Cedula"));
                        System.out.println(resultado.getString("Nombre"));
                        System.out.println(resultado.getString("FechaNac"));
                        System.out.println(resultado.getString("Signo"));
                    }
                }catch (Exception excp){
                    System.out.println("Hubo un error: "+excp);
                }
            }
        });
    }

    //-----METODO PARA RECUPERAR DATOS DE LA GUI A LA CLASE------------------
    public Persona recuperarDatosGUI(){
        Persona individuo=new Persona();
        individuo.setCodigo(inputCod.getText());
        individuo.setCedula(inputCedula.getText());
        individuo.setNombre(inputNombre.getText());
        individuo.setFechaNac(inputFechaNac.getText());
        individuo.setSignoZ(String.valueOf(comboBoxSignoZ.getSelectedItem()));

        return individuo;//se retorna el objeto seteado con lo del GUI
    }

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
