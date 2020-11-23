package com.fathi;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Graph graph = new Graph(6);
        graph.AddNode("A",3,8);
        graph.AddNode("B",2,4);
        graph.AddNode("C",6,3);
        graph.AddNode("D",3,2);
        graph.AddNode("E",7,2);
        graph.AddNode("F",1,1);



        //make connect graph nodes
        graph.ConnectNode("A","B",5,true);
        graph.ConnectNode("A","C",1,true);
        graph.ConnectNode("B","C",3,true);
        graph.ConnectNode("B","D",2,true);
        graph.ConnectNode("C","E",7,true);
        graph.ConnectNode("D","E",3,true);
        graph.ConnectNode("D","F",4,true);


        graph.Show_Test();

        A_Star a_star =new A_Star(graph,"A","F");

        a_star.doAlgorithm();


        //show Graph
//        JFrame jFrame = new JFrame();
//        jFrame.add(new JPanelGraph());
//        jFrame.setSize(500, 500);
//        jFrame.setVisible(true);
    }

}
