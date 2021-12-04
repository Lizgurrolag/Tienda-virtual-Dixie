public class Usuario { //Clase Usuario (Super clase)

    //Atrbutos de la clase usuario
    private String correo;
    private String password;

    //Constructor, que nos servira para inicializar los valores de los atributos
    public Usuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() { //Metodo get de correo que se utilizara
        return correo;          //para la verificacion de los datos encapsulados con los ingresados en la clase principal
    }

    public String getPassword() { //Metodo get de password (Contraseña) que se utilizara
        return password;          //para la verificacion de los datos encapsulados con los ingresados en la clase principal
    }

    public boolean verificacionPassword(String passwordIngresada){ //Metodo que se utilizara en clase principal para verificar
                                                                      //la comprobacion de las password
        if (password.equals(passwordIngresada)) {   //Comprabacion de la password regitrada con la ingresada
            return true;  // Si esta condicion se cumple, arrojara un valor true
        }else {
            return false; // Si esta condicion no se cumple, arrojara un valor false
        }
    }
}
