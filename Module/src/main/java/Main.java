//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean lessThanHundred(int[] a){
        for (int i = 0; i < a.length; i++){
            if (a[i] >= 100) {
                return false;
            }
        }
        return true;
    }

    static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1};
        int[] c = new int[4];
        /*
        Some differences that are present from the ArrayList class and my class:
        1) There are extra functions in ArrayList that are not implemented in mine, such as getStart getLast or lookup
        functions like indexOf.
        2) The method in which it reallocated and resizes the internal array is not specified, whereas in my
        implementation, we specify it to double the array size every time it fills up.
        3) There is no way to get the internal size of the array that is being used. In our IntList class we can simply
        read the length of the array variable. However, in ArrayList, you use a function called ensureCapacity in order
        to resize the array to a size that you need it to be.
         */
        System.out.println(lessThanHundred(a));
    }
}
