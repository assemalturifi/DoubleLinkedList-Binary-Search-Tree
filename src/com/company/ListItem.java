package com.company;

public abstract class ListItem {
    protected ListItem leftLink=null;
    protected ListItem rightLink=null;
    // I created instances of this very small class within a class.,
    // this two variables holds references to object of type listItem
    //thus each list item object can hold a link to the previous and next items in the list that we
    //actually gonna be ultimately be saving.
    //the reason that i have actually declared the fields to be protected rather than private is becase we need to be
    // able to access them from our concrete subclass. we could have made them private and the subclasses in the same
    // package would be able to access them, but not subclasses in the other packages, as thats why i made it protected

    private Object value;

    public ListItem(Object value) {//constructor
        this.value = value;
    }

    abstract ListItem next();//returns a reference to the next ListItem in the list.
    abstract ListItem setNext(ListItem item);//we're passing the parameter list itmes sets the reference to the next item to refer to in the parameter
    abstract ListItem previous ();//sets the reference to the previous item in the list
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo (ListItem item);
    // campares an object to the item whatever has been passed
    // through the parameter and return zero with or equal, and also returns a number
    // if the item parameter should sort before the object which would be negative,
    // otherwise it is gonna return a positive number

    public Object getValue() {// we defined this an Object, we can use any, but we used String
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

//in this class we have two variables, and they hold references to object type of
// ListItem, riightLink and leftLink
