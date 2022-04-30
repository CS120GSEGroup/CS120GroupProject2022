package RPGGame.characters;

public class Officer extends GameCharacter {

    public Officer() {
        this.setHealth(40);
        this.setDamage(6);
        this.setLevel(1);
        this.setName("Officer");

    }

    public Officer(int health, int attackPoints, int level, int potions) {
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
