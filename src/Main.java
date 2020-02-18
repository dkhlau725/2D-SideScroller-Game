import java.util.Scanner;

public class Main {


    public static void main(String args[]){
        Player tuan = new Player("Tuan");

        Scanner input = new Scanner(System.in);
        String command = "";

        tuan.setPosition(0,600);
        

        System.out.println("Please enter left, right, or up");
        

        command = input.nextLine();


        tuan.move(command);

        System.out.println(tuan);


        while (command != ""){
        
            System.out.println("Please enter left, right, or up");
        

            command = input.nextLine();


            tuan.move(command);

            System.out.println(tuan);

        }
        input.close();
    }


}