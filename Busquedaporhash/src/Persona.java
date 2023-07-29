public class Persona {
    private String nombre;
    private String edad;


    public Persona(String _nombre, String _edad) {
        this.nombre = _nombre;
        this.edad = _edad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEdad(){
        return edad;
    }
}
