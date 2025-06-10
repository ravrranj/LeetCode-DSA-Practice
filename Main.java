
//This program implements a mathematical series expansion, where each term follows the pattern: [ S(i) = S(i-1) + 2^{(i-1)} \times b ].This resembles an arithmetic progression with an exponential factor.

import java.util.Scanner;

public class Main{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int queries = sc.nextInt();

        for (int q = 0; q < queries; q++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();

            int curr = a;

            for (int i = 0; i < n; i++) {
                curr += (1 << i) * b;

                System.out.print(curr + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}