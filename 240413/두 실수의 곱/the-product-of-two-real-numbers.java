public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        double a = 5.26;
        double b=8.27;
    double c = Math.round(a*b*1000)/1000.0;
    
    System.out.println(String.format("%.3f",c));
    }
}