public class KISS {
    //task 3
    public void ProcessNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        for (var number : numbers) {
            if (number > 0) {
                System.out.println(number);
            }
        }
    }

    //task 4
    public void PrintPositiveNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number > 0) {
                System.out.println(number);
            }
        }
    }

    //task 5
    public int divide(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
