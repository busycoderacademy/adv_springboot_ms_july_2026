package com.basics.loosecoupling;

class StackImpRaj implements  Stack {
    private int[] x;
    private final int SIZE;
    private int top;

    public StackImpRaj(int size) {
        this.SIZE = size;
        this.x = new int[SIZE];  
        this.top = -1;
    }

    public void push(int element) {
        if (top >= SIZE - 1) {   
            System.out.println("Stack Overflow!");
            return;
        }
        x[++top] = element;   
    }

    public int pop() {
        if (top == -1) {        
            System.out.println("Stack Underflow!");
            return -99;
        }
        return x[top--];       
    }

}