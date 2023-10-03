import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;
import java.util.Iterator;

public class PerformanceTest {

    private static final int SIZE = 2000000; /* Determine based on preliminary test */;
    private static final long DESIRED_DURATION = 10000;  // 10 seconds in milliseconds

    public static void main(String[] args) {

        //PART A
        System.out.println("Starting: Not use iterators to sum the elements");




        long loopEndTime, elapsed;
        long loopStartTime = System.currentTimeMillis();

        do {


            // Constructing and Populating the ArrayList
            ArrayList<Integer> arrayList = new ArrayList<>();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                arrayList.add(new Random().nextInt(10));
            }
            long endTime = System.currentTimeMillis();
            System.out.println("ArrayList Construction: " + (endTime - startTime));

            // Constructing and Populating the Vector
            Vector<Integer> vector = new Vector<>();
            startTime = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                vector.add(new Random().nextInt(10));
            }
            endTime = System.currentTimeMillis();
            System.out.println("Vector Construction: " + (endTime - startTime));

            // Constructing and Populating the Array
            int[] arr = new int[SIZE];
            startTime = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                arr[i] = new Random().nextInt(10);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Array Construction: " + (endTime - startTime));

            // Iterating and Summing the ArrayList
            Iterator<Integer> arrayListIterator = arrayList.iterator();
            int sum = 0;
            startTime = System.currentTimeMillis();
            while (arrayListIterator.hasNext()) {
                sum += arrayListIterator.next();
            }
            endTime = System.currentTimeMillis();
            System.out.println("ArrayList Iteration: " + (endTime - startTime));

            // Iterating and Summing the Vector
            Iterator<Integer> vectorIterator = vector.iterator();
            sum = 0;
            startTime = System.currentTimeMillis();
            while (vectorIterator.hasNext()) {
                sum += vectorIterator.next();
            }
            endTime = System.currentTimeMillis();
            System.out.println("Vector Iteration: " + (endTime - startTime));

            // Iterating and Summing the Array
            sum = 0;
            startTime = System.currentTimeMillis();
            for (int value : arr) {
                sum += value;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Array Iteration: " + (endTime - startTime));

            loopEndTime = System.currentTimeMillis();
            elapsed = loopEndTime - loopStartTime;
        } while (elapsed < DESIRED_DURATION);

        System.out.println("Total elapsed time for all operations: " + elapsed + " ms");

        System.out.println("Ending: Not use iterators to sum the elements");





        //-------------------------------------------------------------------------



        //PART B



        // Single Random instance for the whole run
        Random random = new Random();

        long arrayListConstructionTime = 0;
        long vectorConstructionTime = 0;
        long arrayConstructionTime = 0;

        long arrayListIterationTime = 0;
        long vectorIterationTime = 0;
        long arrayIterationTime = 0;

        loopStartTime = System.currentTimeMillis();

        do {



            // Constructing and Populating the ArrayList
            ArrayList<Integer> arrayList = new ArrayList<>();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                arrayList.add(random.nextInt(10));
            }
            long endTime = System.currentTimeMillis();
            arrayListConstructionTime = endTime - startTime;
            System.out.println("ArrayList Construction: " + (arrayListConstructionTime));

            // Constructing and Populating the Vector
            Vector<Integer> vector = new Vector<>();
            startTime = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                vector.add(random.nextInt(10));
            }
            endTime = System.currentTimeMillis();
            vectorConstructionTime = endTime - startTime;
            System.out.println("Vector Construction: " + (vectorConstructionTime));


            // Constructing and Populating the Array
            int[] arr = new int[SIZE];
            startTime = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                arr[i] = random.nextInt(10);
            }
            endTime = System.currentTimeMillis();
            arrayConstructionTime = endTime - startTime;
            System.out.println("ArrayList Construction: " + (arrayListConstructionTime));


            // Iterating and Summing the ArrayList
            Iterator<Integer> arrayListIterator = arrayList.iterator();
            int sum = 0;
            startTime = System.currentTimeMillis();
            while (arrayListIterator.hasNext()) {
                sum += arrayListIterator.next();
            }
            endTime = System.currentTimeMillis();
            arrayListIterationTime = endTime - startTime;
            System.out.println("ArrayList Iteration: " + (arrayListIterationTime));


            // Iterating and Summing the Vector
            Iterator<Integer> vectorIterator = vector.iterator();
            sum = 0;
            startTime = System.currentTimeMillis();
            while (vectorIterator.hasNext()) {
                sum += vectorIterator.next();
            }
            endTime = System.currentTimeMillis();
            vectorIterationTime = endTime - startTime;
            System.out.println("Vector Iteration: " + (vectorIterationTime));


            // Iterating and Summing the Array
            sum = 0;
            startTime = System.currentTimeMillis();
            for (int value : arr) {
                sum += value;
            }
            endTime = System.currentTimeMillis();
            arrayIterationTime = endTime - startTime;
            System.out.println("Array Iteration: " + (arrayIterationTime));


            elapsed = System.currentTimeMillis() - loopStartTime;
            System.out.println("elapse: "+elapsed+", DESIRED_DURATION: "+DESIRED_DURATION);
        } while (elapsed < DESIRED_DURATION);

        // Print the results
        System.out.println("Starting: use iterators to sum the elements");
        System.out.println("ArrayList Construction: " + arrayListConstructionTime);
        System.out.println("ArrayList Iteration (excluding construction): " + (arrayListIterationTime - arrayListConstructionTime));

        System.out.println("Vector Construction: " + vectorConstructionTime);
        System.out.println("Vector Iteration (excluding construction): " + (vectorIterationTime - vectorConstructionTime));

        System.out.println("Array Construction: " + arrayConstructionTime);
        System.out.println("Array Iteration (excluding construction): " + (arrayIterationTime - arrayConstructionTime));

        System.out.println("Total elapsed time for all operations: " + elapsed + " ms");

        System.out.println("Ending: use iterators to sum the elements");
    }
}