package com.company;

public interface NodeList {
    ListItem getRoot();// is the actualy ListItem itself.
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);//going through the list. Any Data Structure that we create must have a starting node.
    //traverse starts at the root(head of the list) and print in the values of each item in the structure
}