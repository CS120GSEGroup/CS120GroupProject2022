package RPGGame.characters;

public class Soldier extends NPC {

    public Soldier() {
        this.setHealth((int) (Math.random()*10)+5);
        this.setDamage(6);
        this.setLevel(1);
        this.setName("Soldier");
    }

    public Soldier(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }





}
