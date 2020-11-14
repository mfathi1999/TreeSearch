package com.fathi;

public class Graph {
    private double [][] matrix; // Adjacency matrix
    private Node []nodeList; // assign number to certain node
    private int numberOfNodes;
    private int capacity;


    Graph (int size){
        matrix = new double[size][size];
        nodeList = new Node[size];
        numberOfNodes = 0;
//        for (int row=0;row<nodeList.length;row++){
//            nodeList[row].name = Integer.toString(row);
//        }
    }

    boolean AddNode(String name,int Xpos , int Ypos){
        if (numberOfNodes< capacity) {
            nodeList[numberOfNodes] = new Node(name, Xpos, Ypos);
            numberOfNodes++;
            return true;
        }
        else {
            return false;
        }



    }

    // if weght not send defult=1
    // if direct not send defualt= undirect
    // direct = true :directed path
    // direct = false :undirected path
    void ConnectNode(String from , String to , double weight  , boolean direct  ){
        if (!direct){//undirect path

            matrix[SearchByname(from)][SearchByname(to)] = weight;
            matrix[SearchByname(to)][SearchByname(from)] = weight;

        }
        else {
            matrix[SearchByname(from)][SearchByname(to)] = weight;
        }
    }
    void ConnectNode(String from , String to , double weight    ){
        ConnectNode(from,to,weight,true);
    }
    void ConnectNode(String from , String to  ){
        ConnectNode(from,to,1,true);
    }

    int SearchByname(String name){
        for(int row=0;row<numberOfNodes;row++){
            if(nodeList[row].name == name ){
                return row;
            }
        }
        return -1;
    }








    }
