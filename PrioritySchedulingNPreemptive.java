import java.util.Scanner; 
public class PrioritySchedulingNPreemptive { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number of processes: "); 
		int n = sc.nextInt(); 
		int at[] = new int[n]; 
		int pid[] = new int[n]; 
		int p[] = new int[n];
		int bt[] = new int[n]; 
		int ct[] = new int[n]; 
		int tat[] = new int[n]; 
		int wt[] = new int[n]; 
		for(int i = 0; i < n; i++) { 
			System.out.println("Enter process id:"); 
			pid[i] = sc.nextInt(); 
			System.out.println("Enter arrival time:"); 
			at[i] = sc.nextInt(); 
			System.out.println("Enter burst time:"); 
			bt[i] = sc.nextInt(); 
			System.out.println("Enter priority (lower number indicates higher priority):"); 
			p[i] = sc.nextInt();
		} 
		int min; 
		int ft[]=new int[n]; 
		int total=0; 
		int st=0; 
		int c; 
		while(true){ 
			min=99; 
			c=n; 
			if(total==n)break; 
			for(int i=0;i<n;i++){ 
              			if(at[i]<=st && ft[i]==0 && min>p[i]){ 
                  			min=bt[i]; 
                  			c=i; 
              			} 
          		} 
          		if(c==n){ 
              			st++; 
          		} 
          		else{ 
              			ct[c]=st+bt[c]; 
              			ft[c]=1; 
              			st=ct[c]; 
              			total++; 
          		} 
      		} 
 
        	float atat = 0, awt = 0; 
        	for(int i = 0; i < n; i++) { 
            		tat[i]=ct[i]-at[i]; 
            		wt[i]=tat[i]-bt[i]; 
            		atat += tat[i]; 
            		awt += wt[i]; 
        	} 
 
 
        	System.out.println("pid\tat\tbt\tp\tct\ttat\twt"); 
        	for(int i = 0; i < n; i++) { 
            		System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + p[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]); 
        	} 
 
        	atat = atat / n; 
        	awt = awt / n; 
        	System.out.println("Average turnaround time: " + atat); 
        	System.out.println("Average waiting time: " + awt); 
 
        	sc.close(); 
    	} 
} 