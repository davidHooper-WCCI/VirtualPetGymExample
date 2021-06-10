public class VirtualPet {
    private String name;
    private int age;
    private int hunger;
    private int thirst;
    private int boredom;
    private int bathroom;
    private boolean alive;
    private int changeVal;
    private int lifeSpan;

    public VirtualPet(String name, int age, int lifeSpan) {
        this.name = name;
        this.age = age;
        this.hunger = 50;
        this.thirst = 50;
        this.boredom = 50;
        this.bathroom = 50;
        this.alive = true;
        this.changeVal = 10;
        this.lifeSpan = lifeSpan;
    }

    public void feed(){
        hunger = Math.max(hunger - changeVal,0);
        bathroom = Math.min(bathroom+changeVal,100);
    }
    public void drink(){
        thirst = Math.max(thirst - changeVal, 0 );
        bathroom = Math.min(bathroom+changeVal,100);
    }
    public void play(){
        boredom = Math.max(boredom -changeVal, 0);
        bathroom = 0;
    }
    public void tick(){
        hunger = Math.min(hunger + changeVal, 100);
        thirst = Math.min(thirst + changeVal, 100);
        boredom = Math.min(boredom + changeVal, 100);
        if(hunger == 100 || thirst == 100 || boredom == 100){
            alive = false;
        }
        if(age < lifeSpan){
            age++;
        }
        else{
            alive = false;
        }

    }
    public String status(){
        String status = "";
        status += "Name: " + name;
        status += " Age: " + age;
        status += " Hunger Level: " + hunger;
        status += " Thirst Level: " + thirst;
        status += " Boredom Level: " + boredom;
        return status;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public boolean isAlive() {
        return alive;
    }
}
