import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public int[] of(int[] array, int length){
        int[] intArray = new int[length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = array[i];
        }
        return intArray;
    }

    @Test
    void equalsDifferentArrayLength(){
        IntList intList1 = new IntList(of(new int[]{1,2,3}, 5), 3);
        IntList intList2 = new IntList(of(new int[]{1,2,3}, 4), 3);
        assertFalse(intList1.equals(intList2));
    }
    @Test
    void equalEltsDifferentArrayLength(){
        IntList intList1 = new IntList(of(new int[]{1,2,3}, 5), 3);
        IntList intList2 = new IntList(of(new int[]{1,2,3}, 4), 3);
        assertTrue(intList1.equalElts(intList2));
    }
    @Test
    void equalsDifferentArrayContents(){
        IntList intList1 = new IntList(of(new int[]{1,2,4}, 5), 3);
        IntList intList2 = new IntList(of(new int[]{1,2,3}, 5), 3);
        assertFalse(intList1.equals(intList2));
    }
    @Test
    void equalsSuccess(){
        IntList intList1 = new IntList(of(new int[]{1,2,3}, 5), 3);
        IntList intList2 = new IntList(of(new int[]{1,2,3}, 5), 3);
        assertTrue(intList1.equals(intList2));
    }
    @Test
    void empty(){
        IntList iL = IntList.empty();
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if (iL.intArray[i] != 0) flag = false;
        }
        assertTrue(flag);
    }
    @Test
    void getOutOfBounds(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        assertThrows(NoSuchElementException.class, () -> intList.get(3));
    }
    @Test
    void getSuccess(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        assertEquals(2, intList.get(1));
    }
    @Test
    void setOutOfBounds(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.set(4, 3));
    }
    @Test
    void setSuccess(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        intList.set(4, 1);
        assertEquals(4, intList.get(1));
    }
    @Test
    void insertOutOfBounds(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.insert(4, 4));
    }
    @Test
    void insertAtFullCapacity(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        intList.insert(4, 1);
        assertArrayEquals(new int[]{1,4,2,3,0,0}, intList.intArray);
        assertEquals(4, intList.length());
    }
    @Test
    void insertAtStart(){
        IntList intList = new IntList(of(new int[]{1,2,3}, 5), 3);
        intList.insert(4, 0);
        assertArrayEquals(new int[]{4,1,2,3,0}, intList.intArray);
        assertEquals(4, intList.length());
    }
    @Test
    void insertAtEnd(){
        IntList intList = new IntList(of(new int[]{1,2,3}, 5), 3);
        intList.insert(4, 3);
        assertArrayEquals(new int[]{1,2,3,4,0}, intList.intArray);
        assertEquals(4, intList.length());
    }
    @Test
    void insertInMiddle(){
        IntList intList = new IntList(of(new int[]{1,2,3}, 5), 3);
        intList.insert(4, 1);
        assertArrayEquals(new int[]{1,4,2,3,0}, intList.intArray);
        assertEquals(4, intList.length());
    }
    @Test
    void addToEnd(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        intList.addToEnd(4);
        assertArrayEquals(new int[]{1,2,3,4,0,0}, intList.intArray);
        assertEquals(4, intList.length());
    }
    @Test
    void addToStart(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        intList.addToStart(4);
        assertArrayEquals(new int[]{4,1,2,3,0,0}, intList.intArray);
        assertEquals(4, intList.length());
    }
    @Test
    void removeOutOfBounds(){
        IntList intList = new IntList(new int[]{1,2,3}, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.remove(3));
    }
    @Test
    void removeOutOfBoundsOne(){
        IntList intList = new IntList(new int[]{1,2,3}, 8);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.remove(3));
    }
    @Test
    void removeSuccess(){
        IntList intList = new IntList(of(new int[]{1,2,3}, 5), 3);
        intList.remove(1);
        assertTrue(intList.equalElts(new IntList(new int[]{1,3},2)));
        assertEquals(2, intList.length());

    }
}
