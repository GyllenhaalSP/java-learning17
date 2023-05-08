package EV3.C_20230215;

/**.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class EjDivEntYMod1 {
    public static void main(String[] args) {

        System.out.println(" n  n/2  n%2  n/3  n%3  n/4  n%4  n/5  n%5  n/7  n%7");
        for(int i = 0; i < 31; i++){
            System.out.printf("%2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d   %2d%n",
                    i, i/2, i%2, i/3, i%3, i/4, i%4, i/5, i%5, i/7, i%7);
        }
    }
}