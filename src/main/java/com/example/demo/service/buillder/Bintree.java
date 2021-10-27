package com.example.demo.service.buillder;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranran.mao
 * @date 2021/10/14 0:54
 */
public class Bintree<T> {

    class Node<T>{
        private T data;
        private int parent;
        public Node(){}
        public Node(T data){
            this.data=data;
        }
        public Node(T data,int parent){
            this.data=data;
            this.parent=parent;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }
    }

    private final int DEFAULT_SIZE=2;
    private int size;
    private int count;
    private Object[] node;
    public Bintree(){
        this.size=this.DEFAULT_SIZE;
        this.node=new Object[this.size];
        this.count=0;
    }
    public Bintree(Node<T> root){
        this();
        this.count=1;
        this.node[0]=root;
        Runtime runtime = Runtime.getRuntime();

    }
}
