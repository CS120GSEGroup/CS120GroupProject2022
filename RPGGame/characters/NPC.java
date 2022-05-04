package RPGGame.characters;


public class NPC extends GameCharacter {

    public NPC() {
    }

    public NPC(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 10) + opponent.getLevel());
        if (criticalHitVector % 6 == 0) {
            int temp = opponent.getDamage();
            opponent.setDamage(opponent.getDamage() * 2);
            activePlayer.setHealth(activePlayer.getHealth() - activePlayer.takeDamage(opponent));
            opponent.setDamage(temp);
            System.out.println("Critical Hit!");
        } else {
            activePlayer.setHealth(activePlayer.getHealth() - activePlayer.takeDamage(opponent));
            System.out.println("Hit!");
        }
    }

    public void printPlayerStats() {
        System.out.println(this.getName());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Health: " + this.getHealth());
        System.out.println("Damage: " + this.getDamage());

    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }
}
