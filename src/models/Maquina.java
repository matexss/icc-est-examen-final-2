package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.subred = calcularSubred();
        this.riesgo = calcularRiesgo();
    }

    private int calcularSubred() {
        String[] partes = ip.split("\\.");
        return Integer.parseInt(partes[2]);
    }

    private int calcularRiesgo() {
        int suma = 0;
        for (int c : codigos) {
            if (c % 5 == 0) {
                suma += c;
            }
        }
        Set<Character> unicos = new HashSet<>();
        for (char ch : nombre.replace(" ", "").toCharArray()) {
            unicos.add(ch);
        }
        return suma * unicos.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public int getSubred() {
        return subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    @Override
    public String toString() {
        return nombre + " (" + ip + ") - Subred: " + subred + " - Riesgo: " + riesgo;
    }
}
