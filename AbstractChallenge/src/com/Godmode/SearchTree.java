package com.Godmode;

import java.util.List;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) { //the tree is empty
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) { //start comparing, move right if possible
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else { //there is no node to the right, add here
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) { //new item is less, move left if possible
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else { //there is no node to the left, add here
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else { //equal, so don't add
                System.out.println(newItem.getValue() + " is already presented");
                return  false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else { //item was found
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) { //13. Abstract Class Challenge Part 3 16:00
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                this.root = item.next();
            }
        } else {
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while (current.previous() != null) {
                leftMostParent = current;
                current = current.previous();
            }
            item.setValue((current.getValue()));
            if (leftMostParent == item) {
                item.setNext(current.next());
            } else {
                leftMostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        //recursive method
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
