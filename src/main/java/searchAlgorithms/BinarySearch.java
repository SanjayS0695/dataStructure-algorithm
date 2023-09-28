package searchAlgorithms;

public class BinarySearch {
    public static void main(String [] args) {
        var input = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result = search(input, 3);

        if (result != null) {
            System.out.println("Value found at position: " + result);
        } else {
            System.out.println("Value not found in the array");
        }
    }

    public static Integer search(Integer[] array, int target) {
        var first = 0;
        var last = array.length-1;
        while (first <= last) {
            var midpoint = (int)Math.floor((first + last)/2);
            if (array[midpoint] == target) {
                return midpoint;
            } else if (array[midpoint] > target) {
                last = midpoint;
            } else {
                first = midpoint + 1;
            }
        }
        return null;
    }
}
