public class Producto {

    //Se crean los atributos que va a llevar el producto
    private String tipoPrenda;
    private String modelo;
    private String categoria;
    private String marca;
    private double talla;
    private double precio;
    private String gtin;

    //Se crea un constructor para poder usar los datos en la clase principal


    public Producto(String tipoPrenda, String modelo, String categoria, String marca, double talla, double precio, String gtin) {
        this.tipoPrenda = tipoPrenda;
        this.modelo = modelo;
        this.categoria = categoria;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.gtin = gtin;
    }

    public String getModelo() {
        return modelo;
    }

    //Se crea un toString para poder mandar la información a la clase principal


    public String getCategoria() {
        return categoria;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public String getMarca() {
        return marca;
    }

    public String producto() {
        return "Producto{" +
                "gtin='" + gtin + '\'' +
                ", marca='" + marca + '\'' +
                ", talla=" + talla +
                ", modelo='" + modelo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }
}
