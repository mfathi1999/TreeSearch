package com.fathi;

import java.lang.reflect.Array;

public class Node {
    String name;
    double[] position; // [0] => for X and [1] => for y
    double heuristic; // Estimation for distance

    Node(String name, double X_pos, double Y_pos) {
        this.name = name;
        position = new double[2];
        position[0] = X_pos;
        position[1] = Y_pos;

    }

    public double Heuristic(Node des) {
        double destination;
        destination = Math.sqrt(Math.pow(this.position[0] - des.position[1], 2) + Math.pow(this.position[1] - des.position[1], 2));
        return destination;
    }

    void Set_info(String name, double X_pos, double Y_pos) {

    }


}
