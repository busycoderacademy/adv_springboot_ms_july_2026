package com.basics.loosecoupling;

import java.util.LinkedList;

class StackImpAmit { 
    private LinkedList<Integer> list;
    private final int SIZE;

    public StackImpAmit(int size) { 
        this.SIZE = size;
        this.list = new LinkedList<>();
    }

    public void pushAmit(int element) { 
        if (list.size() >= SIZE) {   
            System.out.println("Stack Overflow!");
            return;
        }
        list.addLast(element);   
    }

    public int popAmit() { 
        if (list.isEmpty()) {        
            System.out.println("Stack Underflow!");
            return -99;
        }
        return list.removeLast();       
    }
}
