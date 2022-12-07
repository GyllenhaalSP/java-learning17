package ProgramasPruebas;
import java.util.Scanner;

public class codigoDeBarras {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String code, newCompleteCode;

        do{
            System.out.print("Introduce el código de barras: ");
            code = sc.nextLine();
            newCompleteCode = normalize(code);
            if(!code.equalsIgnoreCase("0")){
                if(code.length() <= 8 ){
                    System.out.println(newCompleteCode);
                    System.out.println("Es EAN-8");
                    if(isCorrectDC(newCompleteCode)){
                        System.out.println("SI");
                    }else{
                        System.out.println("NO");
                    }
                }else if(code.length() <= 13) {
                    System.out.println(newCompleteCode);
                    System.out.println("Es EAN-13");
                    if (isCorrectDC(newCompleteCode)) {
                        System.out.println("SI");
                    } else {
                        System.out.println("NO");
                    }
                }else{
                    System.out.println("El código de barras no es válido.");
                }
            }
        }while(!code.equalsIgnoreCase("0"));
    }

    public static String normalize(String code){
        if(code.length() <= 8) {
            while(!(code.length() == 8)){
                code = "0".concat(code);
            }
        }else{
            while(!(code.length() == 13)){
                code = "0".concat(code);
            }
        }
        return code;
    }

    public static boolean isCorrectDC(String newCompleteCode){
        int suma8 = 0, suma13 = 0;
        for (int i = 0; i < newCompleteCode.length()-1; i++){
            int parseInt = Integer.parseInt(Character.toString(newCompleteCode.charAt(i)));
            if(i % 2 == 0 && newCompleteCode.length() == 8) suma8 += parseInt *3;
            else if(i % 2 != 0 && newCompleteCode.length() == 13) suma13 += parseInt *3;
            else{
                suma8 += parseInt;
                suma13 += parseInt;
            }
        }
        String toString = Character.toString(newCompleteCode.charAt(newCompleteCode.length() - 1));
        return ((Integer.parseInt(toString) + suma8) % 10 == 0) || ((Integer.parseInt(toString) + suma13) % 10 == 0);
    }
}