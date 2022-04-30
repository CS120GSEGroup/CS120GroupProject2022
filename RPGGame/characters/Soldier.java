package RPGGame.characters;

public class Soldier extends GameCharacter {

    public Soldier() {
        this.setHealth(40);
        this.setDamage(6);
        this.setLevel(1);
        this.setName("Soldier");
    }

    public Soldier(int health, int attackPoints, int level, int potions) {
        super(health, attackPoints, level, potions);
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



}
