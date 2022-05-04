package RPGGame.characters;

public class Officer extends NPC {

    public Officer() {
        this.setLevel((int) (Math.random() * 10) + 2);
        this.setHealth((this.getLevel() * 2) + 1);
        this.setDamage((this.getLevel() * 2) + 6);
        this.setName("Officer");

    }

    public Officer(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }


}
