import java.util.*;

// Class ArrayIntList can be used to store a list of integers.
public class ArrayIntList {
    private int[] elementData;  // list of integers
    private int size = 0;       // current number of elements in the list

    public void stretch(int n) {
        ensureCapacity(size * n);
        ArrayIntList initialArray = new ArrayIntList();
        addAll(initialArray);
        if (n != 0){
            for (int i = 0; i < initialArray.size(); i++){
                for (int j = 0; j < n - 1; j++){
                    add(i + j, get(i));
                }
            }
        }
        else{
            clear();
        }

    }

    public static final int DEFAULT_CAPACITY = 10;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    private ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }

    // for creating test cases more easily
    public ArrayIntList(int... elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            add(n);
        }
    }

    // for creating test cases more easily
    public ArrayIntList(int element, boolean notCapacity) {
        this();
        add(element);
    }

    // pre : size() < capacity (elementData.length)
    // post: appends the given value to the end of the list
    public void add(int value) {
        add(size, value);
    }

    // pre: size() < capacity (elementData.length) && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting subsequent
    //     values right
    public void add(int index, int value) {
        checkIndex(index, 0, size);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: removes all elements from this list
    public void clear() {
        size = 0;
    }

    // post: returns true if the given value is contained in the list, false otherwise
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // post: ensures that the underlying array has the given capacity; if not,
    // the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            int[] newList = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newList[i] = elementData[i];
            }
            elementData = newList;
        }
    }

    // returns true if o is an ArrayIntList with the same size and elements as this one
    public boolean equals(Object o) {
        if (!(o instanceof ArrayIntList)) {
            return false;
        }

        ArrayIntList other = (ArrayIntList) o;
        if (this.size != other.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (elementData[i] != other.elementData[i]) {
                return false;
            }
        }

        return true;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: returns capacity of this list's underlying array
    public int getCapacity() {
        return elementData.length;
    }

    // post : returns the position of the first occurence of the given
    //      value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // post: removes all occurrences of the values in the given list from this list
    public void removeAll(ArrayIntList other) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!other.contains(elementData[i])) {
                elementData[newSize] = elementData[i];
                newSize++;
            }
            size = newSize;
        }
    }

    // pre : 0 <= index < size()
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // post: returns a comma-separated, bracketed version of the list
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            if (i < elementData.length) {
                result += elementData[i];
            } else {
                // student's code is bogus; OOB
                result += "OOB!";
            }
        }
        result += "]";
        return result;
    }

    // helpers to make sure indexes do not fall out of bounds
    private void checkIndex(int index) {
        checkIndex(index, 0, size - 1);
    }

    private void checkIndex(int index, int min, int max) {
        if (!(min <= index && index <= max)) {
            throw new ArrayIndexOutOfBoundsException("Illegal index " + index +
                    "; must be between " + min + " and " + max + "\n"
                    + "list : " + toString() + " (size=" + size + ")\n"
                    + "array: " + Arrays.toString(elementData) + " (capacity=" + elementData.length + ")");
        }
    }

}