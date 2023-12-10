
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author German Velasquez
 */
public class EstudianteDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    public void listar() {

        String sql = "select * from registro";

        try {
            //con: accede a la base de datos
            //ps: ejecuta el query (la consulta)
            //y el rs: guarda el resultado de ps
            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void crear(estudiante datos) {
        String sql = "INSERT INTO `registro` (`nombre`, `apellido`, `eda`, `nota_promedio`) VALUES ( ?, ?, ?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, datos.getNombre());
            ps.setString(2, datos.getApellido());
            ps.setInt(3, datos.getEdad());
            ps.setInt(4, datos.getNota_promedio());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modificar(modiEstudiante datos) {

        String sql = "UPDATE `registro` SET `nombre` =?, `apellido` =?, `eda` =?, `nota_promedio` =? WHERE `registro`.`id_estudiante` =?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(5, datos.getId_estudiante());
            ps.setString(1, datos.getNombre());
            ps.setString(2, datos.getApellido());
            ps.setInt(3, datos.getEdad());
            ps.setInt(4, datos.getNota_promedio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(int id_estudiante) {
        String sql = "DELETE FROM `registro` WHERE `registro`.`id_estudiante` =?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_estudiante);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    /**
     * public Usuario consultar(String correo_electronico, String contrasenia) {
     *
     * String sql = "select * from usuarios where correo_electronico like ? or
     * contrasenia like ?;";
     *
     * try { //Inicializa la base de datos con = acceso.Conectar(); ps =
     * con.prepareStatement(sql); ps.setString(1, "%" + correo_electronico +
     * "%"); ps.setString(2, "%" + contrasenia + "%"); rs = ps.executeQuery();
     *
     * while (rs.next()) { System.out.println(rs.getString(2));
     * System.out.println(rs.getString(3)); System.out.println(rs.getInt(8));
     *
     * }
     * return null; } catch (Exception e) { System.out.println(e); }
     *
     * return null;
     *
     * }
     */
    public static void main(String[] args) {
        while (true) {
            EstudianteDAO ed = new EstudianteDAO();

            System.out.println("----------------");
            System.out.println("Binevenid@ ");
            System.out.println("----------------");
            System.out.println("QUE DESEA HACER HOY:");
            System.out.println("----------------");
            System.out.println("Crear un nuevo estudiante                (1)");
            System.out.println("Mostrar la lista de estudiantes          (2)");
            System.out.println("actualizar los datos de un estudiante    (3)");
            System.out.println("eliminar un estudiante                   (4)");
            System.out.println("salir de la aplicacion                   (5)");

            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Ingrese los datos: Nombre,Apellido,Edad,nota_promedio");
                    System.out.println("se desplegara una ventanita ve ingresando los datos\n busca la ventanita en tus pestañas\n");
                    String nom = JOptionPane.showInputDialog("Ingresa su Nombre");
                    String ape = JOptionPane.showInputDialog("Ingresa su apellido");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa su edad"));
                    int nota = Integer.parseInt(JOptionPane.showInputDialog("Ingresa su nota"));
                    ed.crear(new estudiante(nom, ape, edad, nota));
                    System.out.println("Se ingreso el estudiante correctamente\n");
                    ed.listar();
                    break;
                case 2:
                    System.out.println("Estudiantes Registrados");
                    System.out.println("-------------------------");
                    ed.listar();
                    break;
                case 3:
                    ed.listar();
                    System.out.println("SELECCIONE EL ID DEL ESTUDIANTE\n SE DESPLEGARA UNA VENTANITA BUSCALA EN TUS PESTAÑAS\n VE MODIFICANDO LOS DATOS\n");
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id que modificara"));
                    String nomModi = JOptionPane.showInputDialog("Ingresa su nuevo Nombre");
                    String apeModi = JOptionPane.showInputDialog("Ingresa su nuevo Apellido");
                    int edadModi = Integer.parseInt(JOptionPane.showInputDialog("Ingresa su nueva Edad"));
                    int notaModi = Integer.parseInt(JOptionPane.showInputDialog("Ingresa su nueva Nota"));
                    ed.modificar(new modiEstudiante(id, nomModi, apeModi, edadModi, 95));
                    System.out.println("se modifico con exito");
                    ed.listar();
                    break;
                case 4:
                    ed.listar();
                    System.out.println("En la pestaña ponga el id que va a elimira (busque en sus pestañas)}n"); 
                   int idDelet = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el Id a eliminar"));
                    ed.eliminar(idDelet);
                    System.out.println("Se elimino al estudiante que selecciono");
                    ed.listar();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }
}
