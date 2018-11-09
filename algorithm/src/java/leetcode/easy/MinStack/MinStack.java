package leetcode.easy.MinStack;

import java.util.LinkedList;

public class MinStack {
    /** initialize your data structure here. */
    LinkedList<Integer> linkedList=new LinkedList<>();
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        linkedList.add(x);
        if(x<min)
            min=x;
    }

    public void pop() {
        if(min<linkedList.getLast()) //min不变
            linkedList.removeLast();
        else{
            linkedList.removeLast();
            min=Integer.MAX_VALUE;
            for(int i=0;i<linkedList.size();i++){
                if(linkedList.get(i)<min)
                    min=linkedList.get(i);
            }
        }

    }

    public int top() {
        return linkedList.getLast();
    }

    public int getMin() {
        return min;
    }
}