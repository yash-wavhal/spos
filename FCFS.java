import java.util.Scanner;

public class FCFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();

        int Pid[] = new int[n];
        int AT[] = new int[n];
        int BT[] = new int[n];
        int CT[] = new int[n];
        int TAT[] = new int[n];
        int WAT[] = new int[n];
        int temp;
        float avgwat = 0, avgtat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the process ID:");
            Pid[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " arrival time:");
            AT[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time:");
            BT[i] = sc.nextInt();
        }

        // Sorting according to arrival time
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (AT[j] > AT[j + 1]) {
                    // Swap arrival times
                    temp = AT[j];
                    AT[j] = AT[j + 1];
                    AT[j + 1] = temp;

                    // Swap burst times
                    temp = BT[j];
                    BT[j] = BT[j + 1];
                    BT[j + 1] = temp;

                    // Swap process IDs
                    temp = Pid[j];
                    Pid[j] = Pid[j + 1];
                    Pid[j + 1] = temp;
                }
            }
        }

        // Calculating completion, TAT, and WAT times
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                CT[i] = BT[i] + AT[i];
            } else {
                if (AT[i] > CT[i - 1]) {
                    CT[i] = BT[i] + AT[i];
                } else {
                    CT[i] = CT[i - 1] + BT[i];
                }
            }
            TAT[i] = CT[i] - AT[i];
            WAT[i] = TAT[i] - BT[i];
            avgwat = avgwat + WAT[i];
            avgtat = avgtat + TAT[i];
        }

        // Displaying the results
        System.out.println("Pid  Arrival  Burst  Completion  TAT  WAT");
        for (int i = 0; i < n; i++) {
            System.out.println(Pid[i] + "\t" + AT[i] + "\t" + BT[i] + "\t" + CT[i] + "\t\t" + TAT[i] + "\t" + WAT[i]);
        }
        sc.close();

        System.out.println("Average Waiting Time: " + (avgwat / n));
        System.out.println("Average Turn Around Time: " + (avgtat / n));
    }
}
