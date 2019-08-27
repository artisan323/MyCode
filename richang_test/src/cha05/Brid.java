package cha05;

public class Brid extends Animal{

    public Brid() {
    }

    public Brid(String b){
        super(b);
    }

    public void call(){
        System.out.println(super.getName() + "积极渣");
    }

    public void action(){
        System.out.println(super.getName() + "fly~");
    }
}
