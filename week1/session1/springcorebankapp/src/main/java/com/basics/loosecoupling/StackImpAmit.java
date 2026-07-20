package com.basics.loosecoupling;

import java.util.LinkedList;

class StackImpAmit implements  Stack {
    private LinkedList<Integer> list;
    private final int SIZE;

    public StackImpAmit(int size) { 
        this.SIZE = size;
        this.list = new LinkedList<>();
    }

    public void push(int element) {
        if (list.size() >= SIZE) {   
            System.out.println("Stack Overflow!");
            return;
        }
        list.addLast(element);   
    }

    public int pop() {
        if (list.isEmpty()) {        
            System.out.println("Stack Underflow!");
            return -99;
        }
        return list.removeLast();       
    }
}
