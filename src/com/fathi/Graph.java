package com.fathi;

public class Graph {
    private double [][] matrix; // Adjacency matrix
    private Node []nodeList; // assign number to certain node
    private int numberOfNodes;
    private int capacity;


    Graph (int size){
        capacity = size;
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
        if (!direct){//undirected path

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

    int NumberOfNeighbors(int numOfList){
        int num=0;
        for (int col=0;col<numberOfNodes;col++){
            if(matrix[numOfList][col]>0){
                num++;

            }
        }
        return num;
    }

    int[] getNeighbors(int numOfList){
        int [] neighborList = new int[NumberOfNeighbors(numOfList)];
        System.out.println(NumberOfNeighbors(numOfList));
        int place=0;
        for(int col=0;col<numberOfNodes;col++){
            if(matrix[numOfList][col]>0){
                neighborList[place++]=col;
            }
        }
        return neighborList;

    }


    void Show_Test(){
        for(int row=0 ; row<numberOfNodes;row++ ){
            System.out.print( nodeList[row].name +" ==> ");
            for(int col=0;col<numberOfNodes;col++){
                System.out.print(matrix[row][col] + ", ");
            }
            System.out.println();

        }

    }



    double NodeDistance(int node1,int node2){

        return matrix[node1][node2];
    }

    Node GetNode(int numOfList){
        return nodeList[numOfList];
    }
//
//    String [] ChildsOf (Node node){
//
//    }
//
    }
