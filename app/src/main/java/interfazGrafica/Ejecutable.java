package interfazGrafica;


import consultorio.consultorio.Consultorio;

public class Ejecutable {

    public static void main(String[] args) {

    
        MenuPrincipal menu = new MenuPrincipal(Consultorio.getInstancia()); //Instanciamos un Menu con una Instancia unica de consultorio
        menu.setVisible(true);

    }

}
