import java.util.Scanner;
import java.util.Arrays;
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        System.out.println("Satır sayısını giriniz : ");
        int row = input.nextInt();
        System.out.println("Kolon sayısını girinz : ");
        int col = input.nextInt();

        MineSweeper mine = new MineSweeper(row,col);
        mine.run();

    }

}
