package DLL;

import java.util.Scanner;

class B1 {
    static {
        System.loadLibrary("B1"); // Load the native library
    }

    // Native method declarations
    private native int add(int a, int b);
    private native int sub(int a, int b);
    private native int mult(int a, int b);
    private native int div(int a, int b);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, ch;

        System.out.println("\nEnter value of a: ");
        a = sc.nextInt();

        System.out.println("\nEnter value of b: ");
        b = sc.nextInt();

        do {
            System.out.println("\nENTER YOUR CHOICE:");
            System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Result: " + new B1().add(a, b));
                    break;
                case 2:
                    System.out.println("Result: " + new B1().sub(a, b));
                    break;
                case 3:
                    System.out.println("Result: " + new B1().mult(a, b));
                    break;
                case 4:
                    System.out.println("Result: " + new B1().div(a, b));
                    break;
                default:
                    if (ch != 5) {
                        System.out.println("Your choice is incorrect");
                    }
            }
        } while (ch != 5);

        sc.close();
    }
}


// cd Documents/
// ls
// javac B1.java
// ls
// javac -h . -classpath . B1.java
// ls
// gcc -shared -FPIC -I/usr/lib/jvm/java-11-openjdk-amd64/include -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux B1.c -o libB1.so
// java -Djava.library.path=. B1
