package com.fathi;

import java.util.PriorityQueue;

public class A_Star {
    Graph map;
    int startNode;
    int endNode;
    PriorityQueue<Node> openSet;
//    String startNode;
//    String endNode;

    A_Star(Graph map, int startNode, int endNode) {
        this.map = map;
//        openSet = new PriorityQueue<Node>(new NodeComparator());
    }

    A_Star(Graph map, String startNode, String endNode) {
        this.map = map;
    }

    String doAlgorithm() {


        return "";
    }
}
//
//    class NodeComparator implements Comparable<Node>{
//
//        @Override
//        public int compareTo(Node node1,Node node2) {
//            if(node1.Heuristic()< node2.Heuristic()) {
//                return 1;
//            }
//            else if(node1.Heuristic()> node2.Heuristic()){
//                return -1;
//            }
//            return 0;
//
//        }
//
//
//    }


