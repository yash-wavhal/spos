import java.util.Scanner; 
import java.util.Vector; 
public class Deadlock { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter number of processes"); 
        int n = sc.nextInt(); 
        System.out.println("Enter number of instances"); 
        int k = sc.nextInt(); 
        int[][] maxmatrix = new int[n][k]; 
        int[][] allocation = new int[n][k]; 
        int[][] need = new int[n][k]; 
        int[] available = new int[k]; 
        boolean[] finish = new boolean[n]; 
        Vector<Integer> safeSequence = new Vector<>(); 
        for (int i = 0; i < n; i++) { 
            finish[i] = false; 
        } 
        System.out.println("Enter max matrix:"); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < k; j++) { 
                maxmatrix[i][j] = sc.nextInt(); 
            }  
        } 
        System.out.println("Enter alloca on matrix:"); 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < k; j++) { 
                allocation[i][j] = sc.nextInt();
            }  
        } 
        System.out.println("Enter available matrix:"); 
        for (int j = 0; j < k; j++) { 
            available[j] = sc.nextInt();
        } 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < k; j++) { 
                need[i][j] = maxmatrix[i][j] - allocation[i][j];
            } 
        } 
        System.out.println("Max Matrix:"); 
        printMatrix(maxmatrix, n, k); 
        System.out.println("Alloca on Matrix:"); 
        printMatrix(allocation, n, k); 
        System.out.println("Need Matrix:"); 
        printMatrix(need, n, k); int total = 0; 
        while (total < n ) { 
            for (int i = 0; i < n; i++) { 
                if (!finish[i]) { 
                    boolean canProceed = true; 
                    for (int j = 0; j < k; j++) { 
                        if (need[i][j] > available[j]) { 
                            canProceed = false; 
                            break; 
                        }  
                    } 
                    if (canProceed) { 
                        for (int j = 0; j < k; j++) { 
                            available[j] += allocation[i][j];      
                        } 
                        finish[i] = true; 
                        total++; 
                        safeSequence.add(i);
                    }
                }
            }
        } 
        for (Integer process : safeSequence) { 
            System.out.print("P" + process + " ");
        }
    } 
    public static void printMatrix(int[][] matrix, int rows, int cols) { 
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) { 
                System.out.print(matrix[i][j] + " ");
            } 
            System.out.println();
        }
    }
}