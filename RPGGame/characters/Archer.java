package RPGGame.characters;

public class Archer extends GameCharacter {

    int specialCounter;

    public Archer() {
        this.setHealth(40);
        this.setDamage(6);
        this.setLevel(1);
        this.setSpecialCounter(0);

    }

    public Archer(int health, int attackPoints, int level, int potions) {
        super(health, attackPoints, level, potions);
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    @Override
    public void attack(GameCharacter opponent, GameCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 10) + 15);
        if (criticalHitVector % 5 == 0) {
            int temp = activePlayer.getDamage();

            activePlayer.setDamage(activePlayer.getDamage() * 2);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            activePlayer.setDamage(temp);
            System.out.println("Critical Hit!");
        } else {
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Hit!");
        }

    }

    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return activePlayer.getDamage();
    }


    @Override
    public void useSpecialAbility(GameCharacter opponent, GameCharacter activePlayer) {
        int specialAbilityVector = (int) ((Math.random() * 9) + 6);
        if (specialAbilityVector % 3 == 0) {
            opponent.setHealth(0);
            System.out.println("Headshot!");
        }else{
            System.out.println("Headshot failed");
        }
    }

    @Override
    public String toString() {
        return this.getName() + " the Archer";
    }
}
