package org.howard.edu.lsp.hw5;

import org.howard.edu.lsp.hw4.IntegerSet;
import org.howard.edu.lsp.hw4.IntegerSetException;

public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 is: " + set1.toString());

        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Value of Set2 is: " + set2.toString());

        try {
            int smallest = set1.smallest();
            System.out.println("Smallest value in Set1 is: " + smallest);
        } catch (IntegerSetException e) {
            System.out.println("Set1 is empty: " + e.getMessage());
        }

        try {
            int largest = set1.largest();
            System.out.println("Largest value in Set1 is: " + largest);
        } catch (IntegerSetException e) {
            System.out.println("Set1 is empty: " + e.getMessage());
        }

        System.out.println("Set1 equals Set2: " + set1.equals(set2));

        System.out.println("Union of Set1 and Set2: "+ set1.union(set2));
        IntegerSet union = set1.union(set2);
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Union is: " + union.toString());

        System.out.println("Intersection of Set1 and Set2: " + set1.intersect(set2));
        IntegerSet intersection = set1.intersect(set2);
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Intersection is: " + intersection.toString());

        System.out.println("Difference of Set1 and Set2: " + set1.diff(set2));
        IntegerSet difference = set1.diff(set2);
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Difference is: " + difference.toString());
        
        System.out.println("Length of Set1 is: " + set1.length());
        System.out.println("Length of Set2 is: " + set2.length());

        set1.clear();
        System.out.println("Cleared Set1. New length of Set1 is: " + set1.length());

        System.out.println("Set2 contains 3: " + set2.contains(3));
        System.out.println("Set2 contains 5: " + set2.contains(5));
    }
}
