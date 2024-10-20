import java.util.*;

public class FCFS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
 		System.out.print("Enter the number of processes: "); 
		int n = sc.nextInt();
		int pid[] = new int[n];
		int at[] = new int[n];
		int bt[] = new int[n];
		int ct[] = new int [n];
		int tat[] = new int [n];
		int wt[] = new int [n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter the process Id: ");
			pid[i] = sc.nextInt();
			System.out.println("Enter the arrival time: ");
			at[i] = sc.nextInt();
			System.out.println("Enter the burst time: ");
			bt[i] = sc.nextInt();
		}
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				int temp = pid[j];
				pid[j] = pid[j + 1];
				pid[j + 1] = temp;
				temp = at[j];
				at[j] = at[j + 1];
				at[j + 1] = temp;
				temp = bt[j];
				bt[j] = bt[j + 1];
				bt[j + 1] = temp;
			}
		}
		ct[0] = at[0] + bt[0];
		for(int i = 1; i < n; i++) {
			if(at[i] > ct[i - 1]) { 
                		ct[i] = at[i] + bt[i]; 
            		} else { 
                		ct[i] = ct[i - 1] + bt[i]; 
            		} 
		}
		float atat = 0;
		float awt = 0;
		for(int i = 0; i < n; i++) {
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt[i];
			atat += tat[i];
			awt += wt[i];
		}
		System.out.println("pid\tat\tbt\tct\ttat\twt");
		for(int i = 0; i < n; i++) {
			 System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]); 
        	} 
        	atat = atat / n; 
        	awt = awt / n; 
        	System.out.println("Average turnaround time: " + atat); 
        	System.out.println("Average waiting time: " + awt); 
 
        	sc.close();
	}
}