package Propuestos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class empleado {
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private double salario;

    public empleado(String nombre, String apellido, String fechaNac, String salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.salario = Double.parseDouble(salario);
    }

    public String toString() {
        return "Empleado: " +
                "nombre: " + nombre +
                ", apellido: " + apellido +
                ", fechaNac: " + fechaNac.toString() +
                ", salario: $" + salario
                ;
    } 
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public int getEdad() {
        Period edad = Period.between(this.fechaNac, LocalDate.now());
        return edad.getYears();
    }

}