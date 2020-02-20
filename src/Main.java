import java.util.Scanner;

public class Main {


    public static void main(String args[]){
        Player tuan = new Player("Razeen");
        Bullet tuanBullet = new Bullet("bullet");

        Scanner input = new Scanner(System.in);
        Scanner bulletIn = new Scanner(System.in);
        String command = "";
        String bcommand = "";

        tuan.setPosition(0,600);
        tuanBullet.setBullet(tuan.getX() + 5, tuan.getY() - 5);
        

        System.out.println("Please enter left, right or up");
        command = input.nextLine();
        tuan.move(command);
        System.out.println(tuan);


        while (command != ""){        
            System.out.println("Please enter left, right, or up");  
            command = input.nextLine();
            tuan.move(command);
            System.out.println(tuan);
            tuanBullet.setBullet(tuan.getX() + 5, tuan.getY() - 5);
            
            System.out.println("please enter shoot to shoot");
            bcommand = input.nextLine();
            tuanBullet.shoot(bcommand, tuan.getX()+5, tuan.getY()-5);
			System.out.println("bullet position is " + tuanBullet.getBulletList() );
        }
        input.close();
        

        }
    
}


