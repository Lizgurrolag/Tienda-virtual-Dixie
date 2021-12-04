import java.util.Scanner;

public class PerfilCliente {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        Cliente [] clientes = new Cliente[1000];

        int opcionSeleccionada;

        System.out.println("*-------------------------------*");
        System.out.println("*         PROGRAMADO POR:       *");
        System.out.println("*   Lizdybeth Gurrola Grijalva  *");
        System.out.println("*-------------------------------*");

        do {
            System.out.println("BIENVENIDO CLIENTE DIXIE");
            System.out.println("A continuación se presentará el menú de opciones: ");
            //Opción 1
            System.out.println("1. Introducir datos del cliente");
            //Opcion 2
            System.out.println("2. Cerrar sesión y salir");
            System.out.println("Introduzca el número de la opción que desea ejecutar:");
            opcionSeleccionada = t.nextInt(); //Aqui el usuario seleccionará la opción que desea ejecutar por teclado

            //Se introdujo un switch para que se ejecute la opción que el usuario desee
            switch (opcionSeleccionada) {
                case 1:
                    //Función mediante la cual se introducirán los datos
                    datosCliente(clientes);
                    break;
                case 2:
                    //Se cerrará sesión y se mostrará mensaje de agradecimiento
                    System.out.println("**Gracias por usar el portal de DIXIE**");
                    break;
                default:
                    //En caso de introducir un número no marcado en el menú se mostrará este mensaje
                    System.out.println("**Opción no válida**");

            }
        }while (opcionSeleccionada != 2);
    }

    public static void datosCliente(Cliente[]clientes) {
        //Entrada por teclado
        Scanner t = new Scanner(System.in);


        System.out.println("Ha seleccionado introducir datos del cliente ");
        //Se pedirán todos los datos del cliente ´por teclado
        System.out.print("NOMBRE DEL CLIENTE: ");
        String nombreCliente = t.nextLine();
        System.out.print("DOMICILIO: ");
        String domicilioCliente = t.nextLine();
        System.out.print("NÚMERO DE TELÉFONO: ");
        String numeroTelefono = t.next();
        System.out.print("CORREO ELECTRÓNICO: ");
        String correoCliente = t.next();

        for (int posicion = 0; posicion < clientes.length; posicion++){
            if (clientes[posicion] == null){
                clientes[posicion] = new Cliente(nombreCliente, domicilioCliente, numeroTelefono, correoCliente);
                System.out.println(clientes[posicion].toString());
                break;
            }
        }

        //Se le pedirá al cliente que verifique la información que ingresó
        System.out.println("¿LA INFORMACIÓN ES CORRECTA?");
        System.out.println("1. Si      2. No");
        //El cliente ingresará por teclado la opción correspondiente mediante 1 o 2
        int opcion2 = t.nextInt();
        // if para verificar la opción seleccionada por el cliente
        if (opcion2 == 1) {
            // si la información es correcta se guardará
            System.out.println("**LA INFORMACIÓN SE HA GUARDADO CORRECTAMENTE:**");
            System.out.println("Programado por Lizdybeth Gurrola");
            //si la información no es correcta se le pedirá que la introduzca nuevamente
        } else {
            for (int posicion = 0; posicion < clientes.length; posicion++){
                if (clientes[posicion] != null){
                    clientes[posicion] = null;
                    break;
                }
            }
            datosCliente(clientes);
        }
    }

}
