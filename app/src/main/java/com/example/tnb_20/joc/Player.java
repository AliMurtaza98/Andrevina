package com.example.tnb_20.joc;

import java.util.ArrayList;

public class Player  {

        private String nombre;
        private int intentos;

        static ArrayList<Player> players = new ArrayList<Player>();

        public Player (String nombre, int intentos) {
            this.nombre = nombre;
            this.intentos = intentos;
        }

        public Player (){

        }

        public int getIntentos() {
            return intentos;

        }
        public String getNombre() {
            return nombre;
        }

        public void setIntentos(int intentos) {
            this.intentos = intentos;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }