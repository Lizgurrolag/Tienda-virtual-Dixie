import java.util.Scanner; //La clase Principal

public class LogIn {
    public static void main(String[] args) { //El metodo Principal
        Scanner teclado = new Scanner(System.in); // Ingresar datos por teclado

        System.out.println("*-------------------------------*");
        System.out.println("*         PROGRAMADO POR:       *");
        System.out.println("*   Jonathan Jesus Gomez Gamez  *");
        System.out.println("*-------------------------------*");

        Usuario [] usuarios = new Usuario[1000]; //Arreglo de Usuarios

        int opcion; //Variable Opcion Utilizada para el Menu Princopal

                 //Menu Princiapal
        do {     //Bucle do-while
            System.out.println();
            System.out.println("      BIENVENIDO");
            System.out.println(" .-.-. D I X I E .-.-. ");
            System.out.println();
            System.out.println("Seleccione una opccion:");
            System.out.println("1.- REGISTRO DE USUARIO");
            System.out.println("2.- INICIAR SESION");
            System.out.println("3.- SALIR");
            System.out.print("--> ");
            opcion = teclado.nextInt();   //Valor de la variable opcion, ingresado desde teclado

            switch (opcion){ //Estructura condicionante switch, que tiene como parametro el valor de opcion
                case 1:{ //En caso de que opcion sea == 1, hara lo siguiente
                    //REGISTRO DE USUARIO
                    System.out.println("*Ingrese Los Siguientes Datos*");
                    regitroUsuario(usuarios); //Llamado de metodo para que registre los ususarios, y los guarde en el arreglo
                    break; //Si se cumple este caso, se romepera el cliclo, y lo mandara al menu principal
                }
                case 2:{ //En caso de que opcion sea == 2, hara lo siguiente
                    System.out.println("*Ingrese:*");
                    iniciarSesion(usuarios); //Llamado de metodo para verificar el correo y password de un cliente en el arreglo
                    break; //Si se cumple este caso, se romepera el cliclo la estructura switch y lo mandara al menu principal
                }
                case 3:{ //En caso de que opcion sea == 3, hara lo siguiente
                    //En este caso solamente se terminara el programa, debido a que la opcion es de salir
                    break;  //Si se cumple este caso, se romepera el cliclo la estructura switch y lo mandara al menu principal
                }
                default:{ //En caso solamente entraran las opciones que no coresponden con ningun caso anterior
                    //Mensaje para correccion
                    System.out.println("Opcion no valida");
                    System.out.println("Por favor vuelaba a intentarlo");
                }
            }

        }while (opcion != 3); //Estructura de bucle do-while que solo se detendra cuando la sentencia logica se cumpla
                                                                             // o cuando seleccione la opcion de salir
    }

    //OPCION 1
              //Metodo pararegistra usuarios que se convertiran en clientes
    public static void regitroUsuario(Usuario[] usuarios){
        Scanner teclado = new Scanner(System.in); //Para ingresar datos por teclado
        String correo;   //variable para correo electronico

        System.out.println("<> E-Mail");
        correo = teclado.nextLine(); //correo ingresado desde teclado
        if (correo.contains("@gmail.com")||correo.contains("@hotmail.com")){ //Estructura condicional, paracomprobra si
                                                                            // el correo se ingreso de una manera corecta

            verificacion(correo, usuarios);//llamado del metodo verificacion, el cual tendra
                                           // como para metros el correo igresado y los arreglos

        }else{  //En el caso de que la estrctura condicional no se cumpla, hara lo siguiente
            System.out.println("<Correo no valido>"); //Mensaje de correccion
            regitroUsuario(usuarios); //Se vuelve a llamar asi mismo el metodo para volver a ingresar un nuevo correo que sea valido
        }
    }

    public static void verificacion(String correo, Usuario[]usuarios){  //Metodo de verificacion de datos
        Scanner teclado = new Scanner(System.in); //Para ingresar datos por teclado
        String password, passwordVerificada; //Variables para la consatrseña del usuario

        System.out.println("<> Contraseña");
        password = teclado.nextLine(); //Para que ingrese una contraseña
        System.out.println("<> Verifique la contraseña");
        passwordVerificada = teclado.nextLine(); //Para vuelva a ingresar yverificar la contraseña

        if (password.equals(passwordVerificada)){ //Verificacion de las contraseñas, para comprobar si son iguales

            for (int posicion = 0; posicion < usuarios.length; posicion++){ //Bucle for para recorer el arreglo
                if (usuarios[posicion] == null){ //Estructura condicional, para verificar si el arreglo en cierta posicion es nula o esta basia
                    usuarios[posicion] = new Usuario(correo, password); // Creacion de un nuevo objeto de Usuario, con parametros de correo y contraseña
                    System.out.println("USUARIO REGISTRADO");
                }
                break; //Cuando se cumpla esto, el ciclo se rompre
            }

        }else{ //Si las contraeñas no son Iguales
            System.out.println("<Las contraseñas no coisiden>"); //Se volvera el metodo asi mismo, con recursividad
            verificacion(correo, usuarios);
        }
    }

    //OPCION 2
    public static void iniciarSesion(Usuario[]usuarios) { //Metodo para ingresar sesion
        Scanner teclado = new Scanner(System.in); //Para ingresar datos por teclado
        String password, correo; //Variables Strings que se usaran para la verificacion de la autenticacion del Cliente

        System.out.println("<> E-Mail:");
        correo = teclado.next(); //Para ingresar el correo del CLiente
        System.out.println("<> Contraseña:");
        password = teclado.next(); //Para ingresar la contraseña asociada al correo

        for (int posicion = 0; posicion < usuarios.length; posicion++) { //Ciclo for para recorrer el arreglo
            if (usuarios[posicion] != null) { //Condicion para verificar si hay un objeto en la posicion i

                if (usuarios[posicion].getCorreo().equals(correo)) { //Verificacion del correo registrado con el ingresado
                    System.out.println();

                    if (usuarios[posicion].verificacionPassword(password)){ //Verificacion del correo registrado con el ingresado

                        System.out.println("BIENBENIDO A DIXIE"); //Aunicio de Ingreso
                        break;

                    }else {
                        System.out.println("CONTRASEÑA INCORRECTA"); //En caso de que la contraseña sea incorrecto
                        iniciarSesion(usuarios);                     //se volvera a llamar asi mismo con recursividad
                    }
                }else {
                    System.out.println("E-MAIL INCORRECTO"); //En caso de que el correo sea incorrecto
                    iniciarSesion(usuarios);                 //se volvera a llamar asi mismo con recursividad
                }
            }
        }
    }

}
