/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rentacarnoelia;

/**
 *
 * @author FX506
 */
public class Prueba {

    /**
     * 
     */
    public static void main(String[] args) {
        
        
        Vehiculo owo = new Vehiculo();
        CatalogoVehiculos catalogo = new CatalogoVehiculos(0);
        catalogo.anadirVehiculo(owo);
        System.out.println(owo);
        System.out.println(catalogo.buscarVehiculo("1"));
        
    }
    
}
