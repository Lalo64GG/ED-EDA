import java.util.Objects;

public class Pasajero {
    private String nombre;
    private String num;

    public Pasajero(String _nombre, String _num) {
        this.nombre = _nombre;
        this.num = _num;
    }

    public String getNum() {
        return num;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " num: " + num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasajero pasajero = (Pasajero) o;
        return num.equals(pasajero.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
