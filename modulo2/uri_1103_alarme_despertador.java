import java.util.Scanner;

public class Main {
    public static void main(String[] args){
         
        Scanner scanner = new Scanner(System.in);
        while(true){
        
            int h1 = scanner.nextInt();
            int m1 = scanner.nextInt();
            int h2 = scanner.nextInt();
            int m2 = scanner.nextInt();
            
            if((m1 == 0 && h1 == 0 && m2 == 0 && h2 == 0)|| !scanner.hasNextLine()){
                break;
            }
            
            /* Com a API de datas 
                int d2 = (h2 < h1 || (h2 == h1 && m1 > m2))? 2:1;
                LocalDateTime time1 = LocalDateTime.of(2020,1,1,h1, m1);
                LocalDateTime time2 = LocalDateTime.of(2020,1,d2,h2, m2);
                ChronoUnit.MINUTES.between(time2, time1);
            */
            
            int totalHoras = 0; 
            if(h2 < h1 || (h2 == h1 && m1 > m2)) {
                totalHoras += h2 + 24 - h1; 
            } else {
                totalHoras += h2 - h1;
            }
            int totalMinutos = (m2 - m1) + totalHoras * 60;
            System.out.println(totalMinutos);
        }
    }
}
