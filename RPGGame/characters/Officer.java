package RPGGame.characters;

public class Officer extends NPC {

    public Officer() {
        this.setHealth(40);
        this.setDamage(6);
        this.setLevel(2);
        this.setName("Officer");

    }

    public Officer(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }






}
