package RPGGame.characters;

public class Boss extends NPC {

    private int specialCounter;

    public Boss() {
        this.setHealth(70);
        this.setDamage(10);
        this.setLevel(10);
        this.setSpecialCounter(0);
        this.setName("Phil Oxlong");
    }

    public Boss(int health, int attackPoints, int level, int specialCounter, String name) {
        super(health, attackPoints, level);
        this.setSpecialCounter(specialCounter);
        this.setName(name);
    }

    public Boss(Boss boss) {
        super(boss.getHealth(), boss.getDamage(), boss.getLevel());
        setSpecialCounter(getSpecialCounter());
        setName(boss.getName());
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
            System.out.println("Dragon's Breath!");
        } else
            super.attack(opponent, activePlayer);
        System.out.println("You will never defeat me!");
    }

    public final void heal() {
        if ((int) ((Math.random() * 10) + 1) % 6 == 0) {
            System.out.println(this.getName() + "healed successfully");
            System.out.println(this.getHealth() + " +10");
            this.setHealth(this.getHealth() + 10);
        }
    }

    @Override
    public String toString() {
        return this.getName() + "the Dragon King";
    }
}

