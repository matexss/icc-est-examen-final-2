package controllers;

import models.Maquina;

import java.util.*;

public class MaquinaController {

    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> resultado = new Stack<>();
        for (Maquina m : maquinas) {
            if (m.getSubred() > umbral) {
                resultado.push(m);
            }
        }
        return resultado;
    }

    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        return new TreeSet<>(pila.stream()
            .sorted((a, b) -> {
                int x = Integer.compare(b.getSubred(), a.getSubred());
                if (x == 0) {
                    return a.getNombre().compareTo(b.getNombre());
                }
                return x;
            })
            .toList());
    }

    public Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        return null;
    
    }

    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {

        return null;

    }
}


