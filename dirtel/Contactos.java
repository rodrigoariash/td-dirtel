package dirtel;

/**
 *
 * @author Rodrigo Arias Hurtado
 * Julio 2018
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Arias Hurtado 
 */
public class Contactos{
      
/**
 *
 * @author Rodrigo Arias Hurtado 
     * @param sTextoBusqueda 
     * @return numCoincidencias
 */
    public int numResultadosBusqueda(String sTextoBusqueda, String frNombreArchivo){
        int iCoincidencias = 0;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(frNombreArchivo))) {
                String line = "";
                while((line = reader.readLine())!= null){
                    if(line.contains(sTextoBusqueda.toUpperCase())){
                        iCoincidencias++;
                    }
                }
            }
           } catch (FileNotFoundException e) {
          } catch (IOException e) {        }
        return iCoincidencias;
    }
    
    public int numeroRegistros (){
        int iRegistros = 0;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("dir5.txt"))) {
                String sCadena = "";
                while((sCadena = reader.readLine())!= null){
                    iRegistros++;
                }
            }
           } catch (FileNotFoundException e) {
          } catch (IOException e) {        }
        return iRegistros;
    }
    
    
    /**
     *
     * @param textoBuscar
     * @param numElementosEncontrados
     * @return
     */
    public String [][] buscar(String textoBuscar, int numElementosEncontrados){
        
        String[][] datosEmpleado = new String[numElementosEncontrados][14];
        int empleado = 0;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("dir5.txt"))) {
                String line = "";
                while((line = reader.readLine())!= null){
                    if(line.contains(textoBuscar.toUpperCase())){
                        //Numero de Empleado
                        datosEmpleado[empleado][0] = line.substring(0, 8);
                        
                        /*Nombre completo
                        * datosEmpleado[empleado][1]=line.substring(8, 38)+" "+line.substring(8, 38)+" "+line.substring(8, 38);
                        */
                        
                        //Apellido Paterno
                        datosEmpleado[empleado][1] = line.substring(8, 38);
                        //Apellido Materno
                        datosEmpleado[empleado][2] = line.substring(38, 68);
                        //Nombre
                        datosEmpleado[empleado][3] = line.substring(68, 98);
                        //Puesto
                        datosEmpleado[empleado][4] = line.substring(98, 163);
                        //Extensión
                        datosEmpleado[empleado][5] = line.substring(163, 188);
                        //Teléfono
                        datosEmpleado[empleado][6] = line.substring(188, 228);
                        //Celular
                        datosEmpleado[empleado][7] = line.substring(228, 258);
                        //Ubicación
                        datosEmpleado[empleado][8] = line.substring(258, 308);
                        //Piso
                        datosEmpleado[empleado][9] = line.substring(308, 316);
                        //Codigo de Departamento
                        datosEmpleado[empleado][10] = line.substring(316, 324);
                        //Departamento
                        datosEmpleado[empleado][11] = line.substring(324, 394);
                        //Gerencia
                        datosEmpleado[empleado][12] = line.substring(394, 464);
                        //Jefe Directo
                        datosEmpleado[empleado][13] = line.substring(464, 510);
                        empleado++;
                    }
                }
            }
          } catch (FileNotFoundException e) {
          } catch (IOException e) {e.printStackTrace();
        }
        return datosEmpleado;
    }
        
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        int resultados = 0;
        int lineas = 0;
        
        //Muestra el número de coincidencias de la búsqueda a través de una caja de diálogo.
        Contactos empleados = new Contactos();
        resultados = empleados.numResultadosBusqueda("rodrigo", "dir5.txt");
        JOptionPane.showMessageDialog(null, "Concurrencias: " + resultados );
        
        lineas = empleados.numeroRegistros();
        JOptionPane.showMessageDialog(null, "Número de lineas " + lineas );
        
        String[][] datos = new String [resultados][14];
        datos = empleados.buscar("Rodrigo", resultados);
        
        for (int i=0; i <=5; i++){
            for (int j=0; j <=14; j++){
                System.out.println(datos[i][j]);
            }
        }
    }

    int numResultadosBusqueda(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}