import java.time.LocalDate;
import java.time.Period;

class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;

    public Persona(String nombre, String apellido, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;

    }

    public Persona(String nombre, String apellido, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        int dia = Integer.parseInt(fechaDeNacimiento.split("/")[0]);
        int mes = Integer.parseInt(fechaDeNacimiento.split("/")[1]);
        int anio = Integer.parseInt(fechaDeNacimiento.split("/")[2]);
        this.fechaDeNacimiento = LocalDate.of(anio, mes, dia);

    }

    public int getEdad() {
        LocalDate hoy = LocalDate.now();
        return Period.between(hoy, fechaDeNacimiento).getYears();
    }
}