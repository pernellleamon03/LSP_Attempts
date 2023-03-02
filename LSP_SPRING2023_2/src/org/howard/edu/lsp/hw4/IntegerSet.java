//Pernell Leamon
package org.howard.edu.lsp.hw4;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    private List<Integer> set;

    public IntegerSet() {
        set = new ArrayList<Integer>();
    }
    
    public void clear() {
        set.clear();
    }
    public int length() {
        return set.size();
    }

    public void add(int item) {
        set.add(item);
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public boolean contains(int item) {
        return set.contains(Integer.valueOf(item));
    }

    public int size() {
        return set.size();
    }

    public int smallest() throws IntegerSetException {
        if (set.size() == 0) {
            throw new IntegerSetException("Set is empty");
        }

        int smallest = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            int current = set.get(i);
            if (current < smallest) {
                smallest = current;
            }
        }
        return smallest;
    }

    public int largest() throws IntegerSetException {
        if (set.size() == 0) {
            throw new IntegerSetException("Set is empty");
        }

        int largest = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            int current = set.get(i);
            if (current > largest) {
                largest = current;
            }
        }
        return largest;
    }

    public boolean equals(IntegerSet b) {
        if (set.size() != b.size()) {
            return false;
        }

        for (int i = 0; i < set.size(); i++) {
            int item = set.get(i);
            if (!b.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int i = 0; i < set.size(); i++) {
            int item = set.get(i);
            result.add(item);
        }

        for (int i = 0; i < b.size(); i++) {
            int item = b.set.get(i);
            if (!set.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int i = 0; i < set.size(); i++) {
            int item = set.get(i);
            if (b.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int i = 0; i < set.size(); i++) {
            int item = set.get(i);
            if (!b.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
  
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size(); i++) {

            sb.append(set.get(i));
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
