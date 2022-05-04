package RPGGame.characters;

public class Boss extends NPC {

    private int specialCounter;

    public Boss() {
        this.setHealth(40);
        this.setDamage(6);
        this.setLevel(1);
        this.setSpecialCounter(0);
        this.setName("Phil Oxlong");
    }

    public Boss(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        super.attack(opponent, activePlayer);
        this.setSpecialCounter(this.getSpecialCounter() + 1);
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return 0;
    }

    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if ((getSpecialCounter() + 1) * (Math.random() * 9) % 3 == 0) {
            activePlayer.setHealth(activePlayer.getHealth() - activePlayer.getHealth() / 4);
            setSpecialCounter(0);
        } else
            opponent.attack(opponent, activePlayer);
    }

    public final void heal() {
        if ((int) ((Math.random() * 10) + 1) % 6 == 0) {
            System.out.println(this.getName()+ "healed successfully");
            System.out.println(this.getHealth() + " +10");
            this.setHealth(this.getHealth() + 10);
        }
    }

    @Override
    public String toString() {
        return this.getName() + "the Villain";

    }

    public void victorySpeech(){
        System.out.println("You never stood a chance");
    }
}
