package com.fathi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_Star {
    Graph map;
    int startNode;
    int endNode;
    PriorityQueue<QueueNodeModel> openSet;
//    String startNode;
//    String endNode;

    A_Star(Graph map, int startNode, int endNode) {
        this.map = map;
        this.startNode = startNode;
        this.endNode = endNode;
//        openSet = new PriorityQueue<Node>(new NodeComparator());
    }

    A_Star(Graph map, String startNode, String endNode) {
        this.map = map;
        this.startNode = map.SearchByname(startNode);
        this.endNode = map.SearchByname(endNode);


        System.out.println("Start from '"+this.startNode+"' to '"+this.endNode+"'");
        map.Show_Test();

    }

    String doAlgorithm() {

        openSet = new PriorityQueue<QueueNodeModel>(new NodeComparator());

        openSet.add(new QueueNodeModel(
                map.GetNode(startNode) ,
                map.GetNode(startNode).Heuristic(map.GetNode(endNode)) //+g(n)
        ));

        while (!openSet.isEmpty()){
            openSet.peek(); //not removed
        }

        return "";
    }
}

    class NodeComparator implements Comparator<QueueNodeModel> {


        @Override
        public int compare(QueueNodeModel nodeModel1, QueueNodeModel nodeModel2) {
            if(nodeModel1.prior > nodeModel2.prior){
                return 1;
            }
            else if(nodeModel1.prior < nodeModel2.prior){
                return -1;
            }
            return 0;
        }
    }


class QueueNodeModel{
    Node node;
    double prior;

    QueueNodeModel(Node node , double prior){
        this.node=node;
        this.prior=prior;
    }
}