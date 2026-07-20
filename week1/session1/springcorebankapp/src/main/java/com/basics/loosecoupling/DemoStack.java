package com.basics.loosecoupling;

public class DemoStack {
    public static void main(String[] args) {
        //i want to use raj imp
        Stack stack = new StackImpAmit(5);
        stack.push(3);
        stack.pop();

    }
}
