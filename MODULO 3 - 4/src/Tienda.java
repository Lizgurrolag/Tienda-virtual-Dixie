import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Producto [] productos = new Producto [100];

        int opcion;

        System.out.println("*-------------------------------*");
        System.out.println("*         PROGRAMADO POR:       *");
        System.out.println("*   Jonathan Jesus Gomez Gamez  *");
        System.out.println("*   Jesus Emmanuel Lugo Montaño *");
        System.out.println("*-------------------------------*");

        do{

            System.out.println("\n####################################");
            System.out.println("\tPORTAL DE DIXIE");
            System.out.println("1.- REGISTRAR PRODUCTOS");
            System.out.println("2.- BUSCAR PRODUCTO");
            System.out.println("3.- VER PRODUCTOS");
            System.out.println("4.- VER MIS FAVORITOS");
            System.out.println("5.-- CERRAR MODULO --");
            System.out.print("-->");
            opcion = teclado.nextInt();
            System.out.println("####################################\n");

            //Una estructura condicional que actua segun la opcion ingresada
            switch(opcion){
                case 1:{
                    //OPCION 1
                    System.out.println("|> REGISTRO DE PRODUCTO <|\n");
                    registrarProductos(productos);
                    break;
                }
                case 2:{
                    //OPCION 2
                    System.out.println("|> BUSCADOR DE PRODUCTOS <|\n");
                    buscarProducto(productos);
                    break;
                }
                case 3:{
                    //OPCION 3
                    System.out.println("|> PRODUCTOS <|\n");
                    verProductos(productos);
                    break;
                }
                case 4:{
                    //OPCION 4
                    System.out.println("|> VER FAVORITOS <|\n");
                    verFavoritos(productos);
                    break;
                }
                    
                case 5: {

                    System.out.println("***************************");
                    System.out.println("*--GRACIAS POR SU VISITA--*");
                    System.out.println("***************************");
                    break;
                }
                default:{
                    System.out.println("OPCION INVALIDA");
                    System.out.println("POR FAVOR VUELVA A INTENATRLO");
                    break;
                }
            }

        }while(opcion != 5);

        System.out.println("*-------------------------------*");
        System.out.println("*         PROGRAMADO POR:       *");
        System.out.println("*   Jonathan Jesus Gomez Gamez  *");
        System.out.println("*   Jesus Emmanuel Lugo Montaño *");
        System.out.println("*-------------------------------*");
    }

    //OPCION 1
    // Metodo para registrar productos
    public static void registrarProductos(Producto [] productos){
        Scanner teclado=new Scanner(System.in);
        String modelo, marca, gtin, categoria, prenda = "";
        int talla = 0;
        double precio = 0.0;

        System.out.println("INGRESE LOS SIGUIENTES DATOS");
        System.out.print("PRENDA : ");
        prenda = teclado.nextLine();
        System.out.print("MODELO : ");
        modelo = teclado.nextLine();
        System.out.print("CATEGORIA : ");
        categoria = teclado.nextLine();
        System.out.print("MARCA : ");
        marca = teclado.nextLine();
        System.out.print("TALLA : ");
        talla = teclado.nextInt();
        System.out.print("PRECIO : ");
        precio = teclado.nextDouble();
        System.out.print("GTIN :");
        gtin = teclado.next();

        for(int posicion = 0; posicion < productos.length; posicion ++){
            if(productos[posicion] == null){
                productos[posicion] = new Producto(prenda, modelo, categoria, marca, talla, precio, gtin);
                System.out.println("PRODUCTO " + prenda + " REGISTRADO\n");
                break;
            }
        }

    }

    //OPCION 2
    public static void buscarProducto(Producto [] productos){
        Scanner teclado=new Scanner(System.in);
        String modelo, marca, categoria, prendaVestir;
        int opcionBuscador;
        boolean productoBuscado = false;
        double precio = 0.0;

        System.out.println("SELECCIONE EL MODO DE BUSQUEDA:");
        System.out.println("1. PRENDA");
        System.out.println("2. MODELO");
        System.out.println("3. CATEGORIA");
        System.out.println("4. MARCA");
        System.out.print(">>>");
        opcionBuscador = teclado.nextInt();

        teclado.nextLine();
        switch (opcionBuscador){
            case 1:{
                System.out.println("\nBUCAR POR PRENDA");
                System.out.print("🔎 ");
                prendaVestir = teclado.next();
                for(int posicion = 0; posicion < productos.length; posicion ++){
                    if(productos[posicion] != null){
                        if (productos[posicion].getTipoPrenda().equalsIgnoreCase(prendaVestir)){
                            System.out.println(productos[posicion].producto());
                            productoBuscado = true;
                        }
                    }
                }
                if (productoBuscado == true){
                    añadirFavorito(productos);
                }else {
                    System.out.println("PRODUCTO NO ENCONTRADA");
                }
                break;
            }

            case 2:{
                System.out.println("\nBUCAR POR MODELO");
                System.out.print("🔎 ");
                modelo = teclado.nextLine();
                for(int posicion = 0; posicion < productos.length; posicion ++){
                    if(productos[posicion] != null){
                        if (productos[posicion].getModelo().equalsIgnoreCase(modelo)){
                            System.out.println(productos[posicion].producto());
                        }
                    }
                }
                if (productoBuscado == true){
                    añadirFavorito(productos);
                }else {
                    System.out.println("PRODUCTO NO ENCONTRADA");
                }
                break;
            }

            case 3:{
                System.out.println("\nBUCAR POR CATEGORIA");
                System.out.print("🔎");
                categoria = teclado.nextLine();
                for(int posicion = 0; posicion < productos.length; posicion ++){
                    if(productos[posicion] != null){
                        if (productos[posicion].getCategoria().equalsIgnoreCase(categoria)){
                            System.out.println(productos[posicion].producto());
                        }
                    }
                }
                if (productoBuscado == true){
                    añadirFavorito(productos);
                }else {
                    System.out.println("PRODUCTO NO ENCONTRADA");
                }
                break;
            }

            case 4:{
                System.out.println("\nBUCAR POR MARCA");
                System.out.print("🔎");
                marca = teclado.nextLine();
                for(int posicion = 0; posicion < productos.length; posicion ++){
                    if(productos[posicion] != null){
                        if (productos[posicion].getMarca().equalsIgnoreCase(marca)){
                            System.out.println(productos[posicion].producto());
                        }
                    }
                }
                if (productoBuscado == true){
                    añadirFavorito(productos);
                }else {
                    System.out.println("PRODUCTO NO ENCONTRADA");
                }
                break;

            }
            default:{
                System.out.println("\nOPCION INVALIDA");
                System.out.println("POR FAVOR VUELVA A INTENTARLO");
                buscarProducto(productos);
            }
        }
    }

    public static void añadirFavorito(Producto [] productos){
        Scanner teclado=new Scanner(System.in);
        String modeloFa, marcaFa, gtinFa, categoriaFa, prendaFa = "";
        int tallaFa = 0;
        double precioFa = 0.0;
        int opcion;
        Producto favorito;

        System.out.println("\nDESEA AGREGAR UN PRODUCTO A FAVORITOS?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        System.out.print("-->");
        opcion = teclado.nextInt();

        teclado.nextLine();
        favorito = null;
        if (opcion == 1){
            System.out.println("INGRESE LOS SIGUIENTES DATOS");
            System.out.print("PRENDA : ");
            prendaFa = teclado.nextLine();
            System.out.print("MODELO : ");
            modeloFa = teclado.nextLine();
            System.out.print("CATEGORIA : ");
            categoriaFa = teclado.nextLine();
            System.out.print("MARCA : ");
            marcaFa = teclado.nextLine();
            System.out.print("TALLA : ");
            tallaFa = teclado.nextInt();
            System.out.print("PRECIO : ");
            precioFa = teclado.nextDouble();
            System.out.print("GTIN :");
            gtinFa = teclado.next();

            favorito = new ProductoFavorito(prendaFa,modeloFa,categoriaFa,marcaFa, tallaFa, precioFa, gtinFa);
        }
    }

    //OPCION 3
    public static void verProductos(Producto [] productos){
        boolean productosBuscados = false;
        for(int posicion = 0; posicion < productos.length; posicion ++){
            if(productos[posicion] != null){
                System.out.println(productos[posicion].producto());
                productosBuscados = true;
            }
        }
        if (productosBuscados == true){
            añadirFavorito(productos);
        }else {
            System.out.println("NO SE ENCUENTRAN PRODUCTOS");
        }
    }

    //OPCION 4
    public static void verFavoritos(Producto [] productos){
        boolean productosBuscados = false;
        for(int posicion = 0; posicion < productos.length; posicion ++){
            if(productos[posicion] != null){
               if (productos[posicion] instanceof ProductoFavorito){
                   productos[posicion].producto();
                   productosBuscados = true;
               }
            }
        }

        if (productosBuscados == false){
            System.out.println("NO HAY PRODUCTOS EN FAVORITO");
        }
    }
}
