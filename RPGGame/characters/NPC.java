package RPGGame.characters;


public class NPC extends GameCharacter {

    public NPC() {
    }

    public NPC(int health, int attackPoints, int level) {
        super(health, attackPoints, level);
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 1) + opponent.getLevel());
        if (criticalHitVector % 6 == 0) {
            int temp = opponent.getDamage();
            int difference = activePlayer.getHealth() - activePlayer.takeDamage(opponent);
            opponent.setDamage(opponent.getDamage() * 2);
            activePlayer.setHealth(difference);
            opponent.setDamage(temp);
            System.out.println("Critical Hit! " + activePlayer.takeDamage(opponent));
        } else {
            int difference = activePlayer.getHealth() - activePlayer.takeDamage(opponent);
            activePlayer.setHealth(difference);
            System.out.println("Hit! "+ activePlayer.takeDamage(opponent));
        }
    }

    public void printPlayerStats() {
        System.out.println("Enemy stats:");
        System.out.println(getName());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Damage: " + getDamage());

    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }

    @Override
    public void block(GameCharacter c) {
        c.setDamage(c.getDamage()/2);
        System.out.println("Blocked the hit");

    }
}
