public class Cliente {
    private String nombre;
    private String domicilio;
    private String numero;
    private String email;

    public Cliente(String nombre, String domicilio, String numero, String email) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.numero = numero;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
