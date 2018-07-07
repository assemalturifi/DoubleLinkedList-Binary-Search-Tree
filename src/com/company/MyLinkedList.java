package com.company;


public class MyLinkedList implements NodeList {
    private ListItem root =null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root==null){//the list is empty, so this item becomes the head
            //we are checking for the empty listitem first, then add a new item as the head of the list if it is empty.
            this.root=newItem;
            return true;
        }
        // if the list is not empty, then what we do is comparing each item in the list with the new item to work out where
        // the new item should be inserted
        ListItem currentItem=this.root;// we are comparing from the head of the list
        while(currentItem!=null){
            int compareItem=(currentItem.compareTo(newItem));
            //if comparision, is less than 0, newItem is greater, move right if possible
            if(compareItem<0){
                if(currentItem.next()!=null){
                    currentItem=currentItem.next();
                }
                else{
                    // //there is no next,so insert at end list

                    //we change this later to bellow code
//                    currentItem.setNext(newItem);
//                    newItem.setPrevious(currentItem);
                    //                       return true;
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }

            }
            else if(compareItem>0){
                //newItem is less, insert before
                if(currentItem.previous()!=null){
                    //we changed this code later

//                    currentItem.previous().setNext(newItem);
//                    newItem.setPrevious(currentItem.previous());
//                    newItem.setNext(currentItem);
//                    currentItem.setPrevious(newItem);

                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }
                else{
                    //the node with a previous is the root, so there is no previous

                    //                we changed this code later
//                    newItem.setNext(this.root);
//                    this.root.setPrevious(newItem);
//                    this.root = newItem;

                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;

            }
            else {
                //equl
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }

        }

        return false;
    }

    @Override
    //to remove items, we traverse the list until we find the item to be removed,
    // then we set the previous link to point to  where our item to be deleted point.
    //so we'are basically just sort of filling in the gaps and making sure that we still got
    //we are not actullay off the creating any off in records in the link list.
    //so agin, we set the previous link, to point where our item to be deleted pints.
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Delating item: " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int compareItem = currentItem.compareTo(item);
            if (compareItem == 0) {
                //found the item to delete.
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                //we found the record and we did change it
                return true;

            } else if (compareItem < 0) {
                //we want to continue navigating through the ListItem if we can find the record
                currentItem = currentItem.next();
            } else { //comparison >0
                //we are at an item greater than the one to be deleted
                //so the item is not in the list
                return false;
            }
            //we have reached the end of the list without finding the item to detele.
        }
            return false;


    }

    @Override
    public void traverse(ListItem root) {
        if(root==null){
            System.out.println("The list is empty");

        }
        else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
