import java.util.ArrayList;
import java.util.Collection;

public class VirtualPetShelter {
    private String shelterName;

    public VirtualPetShelter(String shelterName) {
        this.shelterName = shelterName;
    }

    ArrayList<VirtualPet> pets = new ArrayList<VirtualPet>();


    public void addPet(VirtualPet pet){
        pets.add(pet);
    }
    public void adoptPet(VirtualPet pet){
        removePet(pet);
    }
    private void removePet(VirtualPet pet){
        pets.remove(pet);
    }
    public VirtualPet getPetByName(String name){
        for (VirtualPet pet:pets) {
            if(pet.getName().equalsIgnoreCase(name)){
                return pet;
            }
        }
        return null;
    }
    public boolean petIsInShelter(String name){
        for (VirtualPet pet:pets) {
            if(pet.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    public String listOfPets(){

        String petList = "";
        for(int i = 0;i<20;i++){
            petList += "\n";
        }

        petList = petList + "***************************************************** \n"
               +shelterName+ " pets available: \n";
        for (VirtualPet pet:pets) {
            petList += pet.status() + "\n";
        }

       return petList;
    }
}
