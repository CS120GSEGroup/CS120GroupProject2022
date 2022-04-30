package RPGGame.characters;

public class Fighter extends GameCharacter {

    public Fighter() {
        this.setHealth(40);
        this.setDamage(20);
        this.setLevel(1);
    }

    public Fighter(int health, int attackPoints, int level, int potions) {
        super(health, attackPoints, level, potions);
    }

    @Override
    public void attack(GameCharacter opponent, GameCharacter activePlayer) {

    }

    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return 0;
    }

    @Override
    public void useSpecialAbility(GameCharacter opponent, GameCharacter activePlayer) {

    }




    @Override
    public String toString() {
        return this.getName() + " the Warrior";
    }
}
