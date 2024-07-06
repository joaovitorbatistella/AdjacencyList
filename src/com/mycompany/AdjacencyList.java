package com.mycompany;

import java.util.*;

class AdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;
    private int n_vertices;

    public AdjacencyList(int n_vertices) {
        this.n_vertices = n_vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < n_vertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public void insertEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }


    public void removeEdge(int u, int v) {
        adjacencyList.get(u).remove(Integer.valueOf(v));
        adjacencyList.get(v).remove(Integer.valueOf(u));
    }


    public List<Integer> listNeighbors(int v) {
        return adjacencyList.get(v);
    }

    public boolean areAdjacent(int u, int v) {
        return adjacencyList.get(u).contains(v);
    }

    public void printAdjacencyList() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n_vertices = 5;
        AdjacencyList listGraph = new AdjacencyList(n_vertices);

        listGraph.insertEdge(1, 2);
        listGraph.insertEdge(1, 3);
        listGraph.insertEdge(2, 4);

        System.out.println("Lista de Adjacência:");
        listGraph.printAdjacencyList();

        System.out.println("\nVizinhos do vértice 1: " + listGraph.listNeighbors(1));
        System.out.println("Vizinhos do vértice 4: " + listGraph.listNeighbors(4));

        System.out.println("\nVerificando se os vértices 1 e 2 são adjacentes: " + listGraph.areAdjacent(1, 2));

        listGraph.removeEdge(1, 2);
        System.out.println("\nApós remover a aresta entre os vértices 1 e 2:");
        listGraph.printAdjacencyList();
    }
}