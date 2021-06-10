import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game{
    public static void main(String[] args) {
        //VirtualPet pru = new VirtualPet("Pru",5,20);
        //VirtualPet mochi = new VirtualPet("Mochi",8,15);
        Game myGame = new Game();
        myGame.play();
    }
    public void play(){
        boolean continueGame = true;
        Scanner input = new Scanner(System.in);
        String userSelection;
        VirtualPetShelter cyberPound = new VirtualPetShelter("CyberPound");
        System.out.println("Welcome to Virtual pet exercise");
        while(continueGame){
            System.out.flush();
            String Output = cyberPound.listOfPets();
            System.out.println(Output);
            System.out.println("Press N to add new pet");
            System.out.println("Press A to adopt pet");
            userSelection = input.nextLine();
            if(userSelection.equalsIgnoreCase("n")){
                String name;
                int age;
                int lifeSpan;
                System.out.print("Enter pet name: ");
                name = input.nextLine();
                System.out.println("Enter pet age (must be younger than 20): ");
                age = input.nextInt();
//                System.out.println("Enter pet lifespan");
//                lifeSpan = input.nextInt();
                lifeSpan = ThreadLocalRandom.current().nextInt(10, 21);
                input.nextLine();
                VirtualPet userPet = new VirtualPet(name, age, lifeSpan);
                cyberPound.addPet(userPet);
            }
            if(userSelection.equalsIgnoreCase("a")){
                String petName;
                while (true) {
                    System.out.println("Enter name of pet to adopt");
                    petName = input.nextLine();
                    if (cyberPound.petIsInShelter(petName)) {
                        cyberPound.adoptPet(cyberPound.getPetByName(petName));
                        break;
                    } else {
                        System.out.println("A pet of that name does not currently reside in our shelter");
                        System.out.println("Would you like to keep looking?  Y or N");
                        if(input.nextLine().equalsIgnoreCase("n")){
                            break;
                        }
                    }
                }
            }

        }
    }
}