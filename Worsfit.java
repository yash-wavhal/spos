import java.util.Collections; 
import java.util.Scanner; 
import java.util.Arrays; 
public class Worsfit { 
    public static void main(String[] args) { 
        Scanner sc=new Scanner(System.in); 
 
        System.out.println("Enter number of jobs :"); 
        int n=sc.nextInt(); 
        System.out.println("Enter number of blocks :"); 
        int b=sc.nextInt(); 
 
        int[] jobs=new int[n]; 
        Integer[] block=new Integer[b]; 
        int[] allocation=new int[n]; 
        int[] flag=new int[b]; 
 
        System.out.println("Enter jobs :"); 
        for(int i=0;i<n;i++) { 
            jobs[i]=sc.nextInt();
        } 
        System.out.println("Enter blocks :"); 
        for(int i=0;i<b;i++) { 
            block[i]=sc.nextInt(); 
            flag[i]=0; 
        } 
        for(int i=0;i<n;i++) { 
            allocation[i]=-1; 
        } 
 
        Arrays.sort(block, Collections.reverseOrder()); 
        int memoryutilized=0; 
 
        for(int i=0;i<n;i++) 
        { 
            for(int j=0;j<b;j++) 
            { 
                if(jobs[i]<=block[j] && flag[j]==0 ) 
                { 
                    System.out.println(jobs[i]+" job fi ed in "+block[j]+" block"); 
                    flag[j]=1; 
                    memoryutilized= memoryutilized+jobs[i]; 
                    allocation[i]=j; 
                    break; 
                } 
            } 
        } 
        System.out.println("Total Memory U liza on : "+ memoryutilized); 
 
        for(int i=0;i<n;i++) { 
            if(allocation[i]==-1) { 
                System.out.println("Memory is not allocated for "+i+"th job"); 
            } 
        } 
 
    } 
 
}
