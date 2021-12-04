public class Pago {
    private String direccion;
    private String numdetelefono;
    private String numdetarjeta;
    private String nombre;
    private String bancoasociado;

    public Pago(String direccion, String numdetelefono, String numdetarjeta, String nombre, String bancoasociado) {
        this.direccion = direccion;
        this.numdetelefono = numdetelefono;
        this.numdetarjeta = numdetarjeta;
        this.nombre = nombre;
        this.bancoasociado = bancoasociado;
    }

    @Override
    public String toString() {
        return "AtributosRP{" + "direccion=" + direccion + ", numdetelefono=" + numdetelefono + ", numdetarjeta=" + numdetarjeta + ", nombre=" + nombre + ", bancoasociado=" + bancoasociado + '}';
    }
}
