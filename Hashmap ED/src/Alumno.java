import java.util.Objects;

public class Alumno {
    private String nombre;
    private String apellido;
    private String carrera;
    private String cuatrimestre;

    public Alumno(String _nombre, String _apellido, String _carrera, String _cuatrimestre) {
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.carrera = _carrera;
        this.cuatrimestre = _cuatrimestre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Carrera: " + this.carrera + " Cuatrimestre: " + this.cuatrimestre  ;
    }
}
