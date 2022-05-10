package RPGGame.characters;

public class Officer extends NPC {

    public Officer() {
        this.setLevel((int) (Math.random() * 10) + 2);
        this.setHealth((this.getLevel() * 2) + 1);
        this.setDamage((this.getLevel() * 2) + 6);
        this.setName("Officer");

    }

    public String toString(){
        return "Officer";
    }
}
