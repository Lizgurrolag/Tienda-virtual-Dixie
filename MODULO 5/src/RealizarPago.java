import java.util.Scanner;

public class RealizarPago {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pago[]pagos = new Pago[100];

        int Opciones;

        System.out.println("*-------------------------------*");
        System.out.println("*         PROGRAMADO POR:       *");
        System.out.println("*  Fernando Salazar Ballesteros *");
        System.out.println("*-------------------------------*");


        do{
            System.out.println("_-_REALIZAR PAGO_-_");
            System.out.println("SELECCIONE UNA OPCIÓN POR FAVOR");
            System.out.println("1.- METODO DE PAGO");
            System.out.println("2.- SALIR");

            Opciones = teclado.nextInt();

            switch(Opciones){
                case 1:
                    informacionparaelPago(pagos);
                    break;
                case 2:
                    System.out.println("QUE TENGA BUEN DIA,ADIOS");
                    break;
            }

            if(Opciones > 2 || Opciones < 0){
                System.out.println("ERROR 404 POR FAVOR ELIJA UNA OPCIÓN");
            }

        }while(Opciones !=2);
    }


    public static void informacionparaelPago(Pago[]pagos){
        Scanner teclado = new Scanner(System.in);

        System.out.println("DIRECCIÓN A LA QUE SERA ENVIADA");
        String direccion = teclado.nextLine();
        System.out.println("NUMERO DE SU TELEFONO");
        String numdetelefono = teclado.nextLine();
        System.out.println("DIGITOS DE SU TARJETA");
        String numdetarjeta = teclado.nextLine();
        System.out.println("INGRESE SU NOMBRE PARA CONTINUAR");
        String nombre = teclado.nextLine();
        System.out.println("¿A QUE BANCO ESTA ASOCIADO?");
        String bancoasociado = teclado.nextLine();

        for(int i = 0; i < pagos.length; i++){
            if(pagos[i] == null){
                pagos[i] = new Pago(direccion, numdetelefono, numdetarjeta, nombre, bancoasociado);
                break;
            }
        }
    }
}
