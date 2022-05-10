package RPGGame.characters;

public class Officer extends NPC {

    public Officer() {
        this.setLevel((int) (Math.random() * 3) + 10);
        this.setHealth((this.getLevel() + 10));
        this.setDamage((this.getLevel() + 3));
        this.setName("Officer");

    }

    public String toString() {
        return "Officer";
    }
}
