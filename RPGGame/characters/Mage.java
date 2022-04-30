package RPGGame.characters;

public class Mage extends GameCharacter {

    private int armorPercentage;
    private int specialCounter;

    public Mage() {
        this.setHealth(30);
        this.setDamage(10);
        this.setLevel(1);
        this.setPotions(4);
        this.setSpecialCounter(0);
    }

    public Mage(int health, int damage, int level, int potions, int specialCounter) {
        super(health, damage, level, potions);
        this.armorPercentage = level * (health / 3);
        this.specialCounter = specialCounter;
    }

    @Override
    public void attack(GameCharacter opponent, GameCharacter activePlayer) {
        opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
    }

    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return (activePlayer.getDamage() * (100 - armorPercentage) / 100);
    }


    public void useSpecialAbility(GameCharacter opponent, Mage activePlayer) {
        if (activePlayer.getSpecialCounter()%6 == 0) {
            opponent.setHealth(opponent.getHealth()/3);
            System.out.println("FIREBALL!");
        }


    }


    @Override
    public String toString() {
        return this.getName() + " the Mage";
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }
}
