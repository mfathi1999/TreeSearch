package com.fathi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_Star {
    Graph map;
    int startNode;
    int endNode;
    Node goal;
    PriorityQueue<QueueNodeModel> openSet;
//    String startNode;
//    String endNode;

    A_Star(Graph map, int startNode, int endNode) {
        this.map = map;
        this.startNode = startNode;
        this.endNode = endNode;
        goal = map.GetNode(this.endNode);
//        openSet = new PriorityQueue<Node>(new NodeComparator());
    }

    A_Star(Graph map, String startNode, String endNode) {
        this.map = map;
        this.startNode = map.SearchByname(startNode);
        this.endNode = map.SearchByname(endNode);
        goal = map.GetNode(this.endNode);



        System.out.println("Start from '"+this.startNode+"' to '"+this.endNode+"'");
//        map.Show_Test();

    }

    String doAlgorithm() {

        openSet = new PriorityQueue<QueueNodeModel>(new NodeComparator());

        openSet.add(new QueueNodeModel(
                map.GetNode(startNode),
                map.GetNode(startNode).Heuristic(map.GetNode(endNode)) //+g(n)
        ));


        QueueNodeModel current;
        while (!openSet.isEmpty()) {
            System.out.println("queue : " + openSet.peek().node.name);
            System.out.println("goal : " + goal.name);
            current = openSet.poll();
            System.out.println("current : " + current.node.name);
            if (current.node == goal) {
                return "I foud it!!";
            }
            int[] neighbors = map.getNeighbors(map.SearchByname(current.node.name));
            System.out.println("num of neighbor = "+neighbors.length);

            for (int p : neighbors) {
                System.out.print(p+",");

                Node nodeTemp = map.GetNode(p);
                QueueNodeModel q = new QueueNodeModel(nodeTemp, nodeTemp.Heuristic(goal) + map.NodeDistance(map.SearchByname(current.node.name), p) + current.pathCost);
                q.SetPathCost(q.prior - nodeTemp.Heuristic(goal));
                q.SetParent(p);

                openSet.add(q);

            }
            System.out.println();


        }


        return "not founded !!";

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
    double prior; // => f(n)
    int parent;
    double pathCost;// => g(n)

    QueueNodeModel(Node node , double prior){
        this.node=node;
        this.prior=prior;
        this.parent=-1;
        this.pathCost=0;
    }

    void SetParent(int parent){
        this.parent=parent;
    }
    void SetPathCost(double cost){
        this.pathCost=cost;

    }
}