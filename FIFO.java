import java.util.Scanner; 
public class FIFO { 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
 
        System.out.println("Enter Reference string Length : "); 
        int n=sc.nextInt(); 
 
        System.out.println("Enter number of frames :"); 
        int frames=sc.nextInt(); 
 
        int[] rs=new int[n]; 
        int[] buffer=new int[frames]; 
        int[][] memory_layout=new int[n][frames]; 
 
        int pointer=0; 
        int hit=0; 
        int fault=0; 
        int search; 
 
 
        System.out.println("Enter the reference String: "); 
 
        for(int i=0;i<n;i++) { 
            System.out.println("Enter for "+i+"th position :"); 
            rs[i]=sc.nextInt(); 
        } 
        for(int i=0;i<frames;i++) { 
            buffer[i]=-1; 
        } 
 
        for(int i=0;i<n;i++) { 
            search=-1; 
            for(int j=0;j<frames;j++) { 
                if(buffer[j]==rs[i]) { 
                    search=j; 
                    hit++; 
                    break; 
                } 
            } 
            if(search==-1) { 
                buffer[pointer]=rs[i]; 
                fault++; 
                pointer++; 
                if(pointer==frames) { 
                    pointer=0; 
                } 
 
            } 
            for(int j=0;j<frames;j++) { 
                memory_layout[i][j]=buffer[j]; 
            } 
        } 
 
        System.out.println("\nMemory Layout:"); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < frames; j++) { 
                System.out.print(memory_layout[i][j] + " "); 
            } 
            System.out.println(); 
        } 
 
        System.out.println("\nTotal Hits: " + hit); 
        System.out.println("Total Faults: " + fault); 
 
        sc.close(); 
 
 
 
    } 
 
}
