package com.basics.loosecoupling;

class StackImpRaj {
    private int[] x;
    private final int SIZE;
    private int top;

    public StackImpRaj(int size) {
        this.SIZE = size;
        this.x = new int[SIZE];  
        this.top = -1;
    }

    public void pushRaj(int element) {
        if (top >= SIZE - 1) {   
            System.out.println("Stack Overflow!");
            return;
        }
        x[++top] = element;   
    }

    public int popRaj() {
        if (top == -1) {        
            System.out.println("Stack Underflow!");
            return -99;
        }
        return x[top--];       
    }

}