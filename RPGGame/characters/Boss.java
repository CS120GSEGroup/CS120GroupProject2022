package RPGGame.characters;

public class Boss extends GameCharacter {

    public Boss() {
    }

    public Boss(int health, int attackPoints, int level, int potions) {
        super(health, attackPoints, level, potions);
    }

    @Override
    public void attack(GameCharacter opponent, GameCharacter activePlayer) {

    }

    @Override
    public int takeDamage(GameCharacter activePlayer) {
        return 0;
    }


}
