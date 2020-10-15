import java.util.Scanner;

public class Main{
    
    private static int numeroDeChamadas = -1; 
    
    public static void main(String []args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        while(n > 0){
            int x = scanner.nextInt();
            int resultado = fib(x);
            System.out.printf("fib(%d) = %d calls = %d%n",x, numeroDeChamadas, resultado);
            numeroDeChamadas = -1;
            n--;
        }
    }
    
    private static int fib(int n){
        numeroDeChamadas++;
        if(n == 0 || n == 1){
            return n; 
        }
        return fib(n-1) + fib(n-2);
    }
}
