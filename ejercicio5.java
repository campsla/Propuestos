package Propuestos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ejercicio5 {

    public static void main(String[] args) {
        List<empleado> listaEmpleados = cargarEmpleados();

        System.out.println("Empleados con una letra especifica en el apellido.");
        for (empleado empl: listarPorLetra(listaEmpleados,'A')) {
            System.out.println(empl);
        }

        System.out.println("\nEmpleado más viejo y empleado más joven.");
        Map<String, empleado> respuesta = empleadoJV(listaEmpleados);
        respuesta.forEach((k,v) ->
        System.out.println(k +" : " + v.toString() + ", edad: "+ v.getEdad()+" años"));

        System.out.println("\nEmpleado con mejor y peor salario.");
        Map<String, empleado> mejorPeorPago = mejorPeorPago(listaEmpleados);
        mejorPeorPago.forEach((k,v) ->
        System.out.println(k +" : " + v.toString() + ", Salario: $"+ v.getSalario()));

        System.out.println("\nLista de empleados ordenados alfabeticamente por nombre y apellido.");
        for (empleado empl: ordenarNombreApellido(listaEmpleados)) {
            System.out.println(empl);
        }
    }

    public static List<empleado> cargarEmpleados() 
    {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String[] empleado;
        List<empleado> listaEmpleado = new ArrayList<>();

        try {
            file = new File("D:/JavaInformatorio/Repositorio-Java-Informatorio/Propuestos/empleados.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String empleadoStr;
            while ((empleadoStr = bufferedReader.readLine()) != null) {
                empleado = empleadoStr.split(",");
                listaEmpleado.add(new empleado(empleado[0], empleado[1], empleado[2], empleado[3]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listaEmpleado;
    }

    public static List<empleado> listarPorLetra(List<empleado> empleados, Character letra) {
        List<empleado> listaEmpleado = new ArrayList<>();
        for (empleado empleado : empleados) {
            if (letra == empleado.getApellido().charAt(0)){
                listaEmpleado.add(empleado);
            }
        }
        return listaEmpleado;
    }

    public static Map<String, empleado> empleadoJV(List<empleado> empleados) {
        Map<String, empleado> JovenViejo = new HashMap<>();
        empleados.sort(Comparator.comparing(empleado::getEdad));
        JovenViejo.put("Joven", empleados.get(0));
        JovenViejo.put("Viejo", empleados.get(empleados.size() - 1));
        return JovenViejo;
    }

    private static Map<String, empleado> mejorPeorPago(List<empleado> empleados) {
        Map<String, empleado> mejorPeor = new HashMap<>();
        empleados.sort(Comparator.comparing(empleado::getSalario));
        mejorPeor.put("Peor Pago", empleados.get(0));
        mejorPeor.put("Mejor Pago", empleados.get(empleados.size() - 1));
        return mejorPeor;
    }

    public static List<empleado> ordenarNombreApellido(List<empleado> empleados) {
        empleados.sort(Comparator.comparing(empleado::getNombre).thenComparing(empleado::getApellido));
        return empleados;
    }
}