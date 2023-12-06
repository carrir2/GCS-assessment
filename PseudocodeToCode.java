import java.util.Random;

public class PseudocodeToCode{
    public static void main(String[] args){

        //Test Case A: 3 Unsorted numbers.
        //Expected Median: 2.0
        double[] numbersA = {3.0, 1.0, 2.0};
        printArr(numbersA);
        System.out.printf("\nMedian: %f",sortAndFindMedian(numbersA));

        //Test Case B: Even Length of unsorted numbers.
        //Expected Median: 2.5
        double[] numbersB = {3.0, 1.0, 2.0, 20.0};
        printArr(numbersB);
        System.out.printf("\nMedian: %f",sortAndFindMedian(numbersB));

        //Test Case C: Single number in array.
        //Expected Median: 3.0
        double[] numbersC = {3.0};
        printArr(numbersC);
        System.out.printf("\nMedian: %f",sortAndFindMedian(numbersC));

        //Test Case D: Random assortment of numbers.
        Random rand = new Random();
        double[] numbersD = {rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100)};
        printArr(numbersD);
        System.out.printf("\nMedian: %f",sortAndFindMedian(numbersD));

    }

    /**
     * Sorts array of numbers and then finds median.
     * @param numbers
     * @return median of numbers
     */
    public static double sortAndFindMedian(double[] numbers){
        if (numbers.length==0){                                         //Checks if numbers array is empty. Throws Exception if so.
            throw new IllegalArgumentException("Cannot be empty");
        }
        sort(numbers);                                                  //Calls bubble sort function for numbers array.
        int n = numbers.length;
        
        if (n % 2 == 0){                                                //Handler if array numbers length is even or odd.
            return (numbers[n/2 - 1] + numbers[n/2]) / 2;               //Returns average of middle two numbers
        } else{
            return numbers[n/2];                                        //Returns middle number.
        }
    }

    /**
     * Sorts array of numbers using Bubble sort algorithm.
     * @param numbers
     */
    public static void sort(double[] numbers){
        double temp;                    
        boolean swapped;
        for (int i = 0; i < numbers.length-1; i++){                     //Iterates through numbers array
            swapped = false;
            for (int j = 0; j < numbers.length - i - 1; j++){           //Iterates through numbers array in range of i
                if (numbers[j] > numbers[j+1]){                         //Handler if number lower index is greather than number above
                    //Swaps places of numbers[j] and numbers[j+1]
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swapped = true;
                }
            }
        
            if (swapped == false)                                       //If no swaps occurred, then break.
                break;
        }
    }

    /**
     * Displays all numbers in array.
     * @param numbers
     */
    public static void printArr(double[] numbers){
        System.out.println("\n\nArray: ");
        for (double num : numbers){
            System.out.print(num+" ");
        }
    }
}