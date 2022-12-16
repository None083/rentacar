/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarnoelia;

import java.util.Arrays;

/**
 *
 * @author noelia
 */
public class CatalogoVehiculos {

    private int numeroVehiculos;
    private Vehiculo[] listaVehiculos;

    //el constructor recibe el tamaño del catalogo e
    //inicializa la estructura de datos con vehiculos aleatorios
    public CatalogoVehiculos(int tamanio) {
        tamanio = Math.abs(tamanio);
        this.numeroVehiculos = tamanio;
        this.listaVehiculos = new Vehiculo[tamanio];
        //una vez creada la estructura de datos le doy
        //valor a cada elemento
        for (int i = 0; i < listaVehiculos.length; i++) {
            this.listaVehiculos[i] = new Vehiculo();
        }
    }

    public void mostrarCatalogo() {
        for (Vehiculo v : listaVehiculos) {
            System.out.println(v);
        }
    }

    public String toString() {
        String tmp = "";
        for (Vehiculo v : listaVehiculos) {
            tmp += v.toString() + "\n";
        }
        return tmp;
    }

    //nº de vehiculos que hay en el catalogo, no el tamaño del array
    public int getNumeroVehiculos() {
        return numeroVehiculos;
    }

    public boolean borrarVehiculo(Vehiculo v) {
        int pos = buscarVehiculo(v);
        if (pos >= 0) {
            this.listaVehiculos[pos] = null;
            this.numeroVehiculos--;
            return true;
        }
        return false;
    }

    public Vehiculo copiarVehiculo(Vehiculo v) {
        Vehiculo copia = new Vehiculo();
        copia.setBastidor(v.getBastidor());
        copia.setColor(v.getColor());
        copia.setMatricula(v.getMatricula());
        copia.setModelo(v.getModelo());
        copia.setTarifa(v.getTarifa());
        return copia;
    }

    //busqueda secuencial
    public int buscarVehiculo(Vehiculo v) {
        for (int i = 0; i < this.listaVehiculos.length; i++) {
            if ((this.listaVehiculos[i] != null && v.equals(this.listaVehiculos[i]))) {
                return i;
            }
        }
        return -1;
    }

    public void anadirVehiculo(Vehiculo v) {
        //si hay hueco se inserta en elhueco
        if (this.numeroVehiculos < this.listaVehiculos.length) {
            for (int i = 0; i < this.listaVehiculos.length; i++) {
                if (this.listaVehiculos[i] == null) {
                    this.listaVehiculos[i] = v;
                    this.numeroVehiculos++;
                    System.out.println("guardando vehiculo en posicion " + i);
                    break;
                }
            }
        } else {//el array está lleno
            //Vehiculo[] nuevo = Arrays.copyOf(listaVehiculos, ++this.numeroVehiculos);
            this.listaVehiculos = Arrays.copyOf(listaVehiculos, ++this.numeroVehiculos);
            this.listaVehiculos[this.numeroVehiculos - 1] = v;
        }

    }

    public Vehiculo buscarVehiculo(String bastidor) {
        //crea un cliente con datos aleatorios
        Vehiculo aux = new Vehiculo();
        aux.setBastidor(bastidor);
        int posicion = buscarVehiculo(aux);
        return (posicion >= 0) ? this.listaVehiculos[posicion] : null;
    }

//    public Vehiculo[] getListaVehiculos() {
//        return listaVehiculos;
//    }
}
