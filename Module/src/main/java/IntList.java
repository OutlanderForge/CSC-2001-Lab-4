import java.util.NoSuchElementException;

public class IntList {
    int[] intArray;
    int usedLength;

    // public constructor
    public IntList(int[] intArray, int numElements){
        this.intArray = intArray;
        this.usedLength = numElements;
    }

    // equals function for all variables of IntList
    public boolean equals(IntList intList){
        if (intList.usedLength != this.usedLength) return false;
        if (intList.intArray.length != this.intArray.length) return false;
        for (int i = 0; i < usedLength; i++) {
            if (this.intArray[i] != intList.intArray[i]) return false;
        }
        return true;
    }

    // equals without check for array length (purely elements in the list)
    public boolean equalElts(IntList other){
        if (other.usedLength != this.usedLength) return false;
        for (int i = 0; i < usedLength; i++) {
            if (this.intArray[i] != other.intArray[i]) return false;
        }
        return true;
    }

    // private helper method to increase array capacity
    private void doubleArray(){
        int[] temp = new int[this.intArray.length * 2];
        for (int j = 0; j < this.intArray.length; j++) {
            temp[j] = this.intArray[j];
        }
        this.intArray = temp;
    }

    // Develop the empty method, that constructs a new object representing the empty list of integers.
    // return new empty IntList
    public static IntList empty(){
        return new IntList(new int[10], 0);
    }

    /*
    Develop the length method, that returns the number of elements in the list represented by the object.
    (This is not the same as the length of the underlying array...)
     */
    // returns number of elements in the list
    public int length(){
        return usedLength;
    }

    /*
    Develop the get method, that accepts an index and returns the element at that index. If the index
    does not refer to a legal element number in the sequence, you should throw NoSuchElementException.
    */
    // gets element in the list at index i
    public int get(int i){
        if (i >= usedLength) throw new NoSuchElementException();
        return this.intArray[i];
    }

    // set index of array to integer i
    public void set(int i, int index){
        // bounds check
        if (index >= this.usedLength || i < 0) throw new IndexOutOfBoundsException();
        this.intArray[index] = i;
    }

    // insert integer at index inside of the list, moving array as necessary
    public void insert(int i, int index){
        // bounds check
        if (index > this.usedLength || index < 0) throw new IndexOutOfBoundsException();
        // if the index is beyond size of the array
        if (this.intArray.length < usedLength + 1){
            this.doubleArray();
        }
        // if index is at end
        if (index == usedLength) {
            this.intArray[usedLength] = i;
            usedLength++;
            return;
        }
        // if index is in start/middle
        // move down elements past index by 1
        for (int j = this.intArray.length - 1; j > index; j--) {
            this.intArray[j] = this.intArray[j-1];
        }
        this.intArray[index] = i;
        usedLength++;
    }

    // add element to the end of list
    public void addToEnd(int i){
        insert(i, usedLength);
    }
    // add element to the beginning of list
    public void addToStart(int i){
//        if (this.intArray.length < usedLength + 1) this.doubleArray();
//        // move down elements by 1
//        for (int j = this.intArray.length; j > 1; j--) {
//            this.intArray[j] = this.intArray[j-1];
//        }
//        this.intArray[0] = i;
//        usedLength++;
        insert(i, 0);
    }
    //remove element at given index
    public void remove(int index){
        if (index > this.usedLength - 1 || index < 0) throw new IndexOutOfBoundsException();
        for (int i = index; i < this.usedLength - 1; i++) {
            this.intArray[i] = this.intArray[i+1];
        }
        usedLength--;
    }

}
