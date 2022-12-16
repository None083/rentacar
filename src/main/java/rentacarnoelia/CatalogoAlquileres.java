/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarnoelia;

import java.util.Arrays;

/**
 * crear metodo copiar privado, supongo que en el de los vehiculos
 *
 * @author noelia
 */
public class CatalogoAlquileres {
    
    private int numeroAlquileres;
    private Alquiler[] listaAlquileres;
    
    public CatalogoAlquileres(int tamanio) {
        
        tamanio = Math.abs(tamanio);
        this.numeroAlquileres = tamanio;
        this.listaAlquileres = new Alquiler[tamanio];
        
        for (int i = 0; i < listaAlquileres.length; i++) {
            this.listaAlquileres[i] = new Alquiler();
        }
        
    }
    
    public void mostrarCatalogo() {
        for (Alquiler a : listaAlquileres) {
            System.out.println(a);
        }
    }
    
    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < listaAlquileres.length; i++) {
            tmp += listaAlquileres[i].toString() + "\n";
        }
        return tmp;
    }
    
    public int getNumeroAlquileres() {
        return numeroAlquileres;
    }
    
    public boolean borrarAlquiler(Alquiler a) {
        int pos = buscarAlquiler(a);
        if (pos >= 0) {
            this.listaAlquileres[pos] = null;
            this.numeroAlquileres--;
            return true;
        }
        return false;
    }
    
    public Alquiler copiarAlquiler(Alquiler a) {
        Alquiler copia = new Alquiler();
        copia.setAlquilerID(a.getAlquilerID());
        copia.setCliente(a.getCliente());
        copia.setDuracionDias(a.getDuracionDias());
        copia.setFechaInicio(a.getFechaInicio());
        copia.setVehiculo(a.getVehiculo());
        return copia;
    }
    
    private int buscarAlquiler(Alquiler a) {
        if (a != null) {
            for (int i = 0; i < this.listaAlquileres.length; i++) {
                if ((this.listaAlquileres[i] != null && a.equals(this.listaAlquileres[i]))) {
                    return i;
                }
            }            
        }
        
        return -1;
    }
    
    public void anadirAlquiler(Alquiler a) {
        if (this.numeroAlquileres < this.listaAlquileres.length) {
            for (int i = 0; i < this.listaAlquileres.length; i++) {
                if (this.listaAlquileres[i] == null) {
                    this.listaAlquileres[i] = a;
                    this.numeroAlquileres++;
                    System.out.println("Guardando Alquiler en posición " + i);
                    break;
                }
            }
        } else {
            this.listaAlquileres = Arrays.copyOf(listaAlquileres, ++this.numeroAlquileres);
            this.listaAlquileres[this.numeroAlquileres - 1] = a;
        }
    }
    
    public Alquiler buscarAlquiler(int ID) {
        //crea un cliente con datos aleatorios
        Alquiler aux = new Alquiler();
        aux.setAlquilerID(ID); // fuerzo a que el cliente tenga el id que busco
        int posicion = buscarAlquiler(aux);
        return (posicion >= 0) ? this.listaAlquileres[posicion] : null;
    }
    
}
