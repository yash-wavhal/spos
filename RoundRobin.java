import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Scanner; 
public class RoundRobin { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the number of processes: "); 
        int n = sc.nextInt(); 
        int[] at = new int[n]; 
        int[] bt = new int[n]; 
        int[] pid = new int[n]; 
        int[] ct = new int[n]; 
        int[] tat = new int[n]; 
        int[] wt = new int[n]; 
        int[] remainingTime=new int[n]; 
        for (int i = 0; i < n; i++) { 
            System.out.println("Enter process id:"); 
            pid[i] = sc.nextInt(); 
            System.out.println("Enter arrival time:"); 
            at[i] = sc.nextInt(); 
            System.out.println("Enter burst time:"); 
            bt[i] = sc.nextInt(); 
            remainingTime[i] = bt[i]; 
        } 
        System.out.print("Enter time quantum: "); 
        int quantum = sc.nextInt(); 
        int min; 
        int ft[]=new int[n]; 
        int total=0; 
        int st=0; 
        while(true){ 
            if(total==n)break;
            for(int i=0;i<n;i++){ 
                if(at[i]<=st && ft[i]==0){ 
                    if(bt[i]>quantum) { 
                        bt[i] = bt[i] - quantum; 
                        st = st + quantum;
                        if(bt[i]==0){ 
                            ct[i]+=st; 
                            ft[i]=1;
                            total++; 
                        } 
                    }
                    else if(bt[i]<=quantum){ 
                        ct[i]=st+bt[i];
                        st=ct[i];
                        bt[i]=0;
                        ft[i]=1;
                        total++; 
                    } 
                } 
            } 
        } 
        float atat = 0, awt = 0;
        for(int i = 0; i < n; i++) { 
            tat[i]=ct[i]-at[i];
            wt[i]=tat[i]-remainingTime[i];
            atat += tat[i];
            awt += wt[i]; 
        } 
        System.out.println("pid\tat\tbt\tct\ttat\twt");
        for (int i = 0; i < n; i++) { 
            System.out.println(pid[i] + "\t" + at[i] + "\t" + remainingTime[i] + "\t" + 
            ct[i] + "\t" + tat[i] + "\t" + wt[i]); 
        } 
        System.out.println("Average turnaround time: " + (atat / n));
        System.out.println("Average waiting time: " + (awt / n)); 
        sc.close(); 
    }
}