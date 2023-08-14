import java.util.Scanner;

public class Stopwatch {
    private long startTime;
    private long stopTime;
    private long elapsedTime;
    private boolean running;

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
            System.out.println("Stopwatch started.");
        } else {
            System.out.println("Stopwatch is already running.");
        }
    }

    public void stop() {
        if (running) {
            stopTime = System.currentTimeMillis();
            elapsedTime += stopTime - startTime;
            running = false;
            System.out.println("Stopwatch stopped.");
        } else {
            System.out.println("Stopwatch is not running.");
        }
    }

    public void hold() {
        if (running) {
            stop();
            System.out.println("Stopwatch held.");
        } else {
            System.out.println("Stopwatch is not running.");
        }
    }

    public long getElapsedTime() {
        if (running) {
            return elapsedTime + (System.currentTimeMillis() - startTime);
        } else {
            return elapsedTime;
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Start");
            System.out.println("2. Stop");
            System.out.println("3. Hold");
           

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stopwatch.start();
                    break;
                case 2:
                    stopwatch.stop();
                    break;
                case 3:
                    stopwatch.hold();
                    break;
            
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Elapsed Time: " + stopwatch.getElapsedTime() + " milliseconds\n");
        }
    }
}