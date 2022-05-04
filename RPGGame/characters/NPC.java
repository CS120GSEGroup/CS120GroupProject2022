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
            activePlayer.setHealth(activePlayer.getHealth() - activePlayer.takeDamage(opponent));
            opponent.setDamage(temp);
            System.out.println("Critical Hit! " + difference);
        } else {
            int difference = activePlayer.getHealth() - activePlayer.takeDamage(opponent);
            activePlayer.setHealth(activePlayer.getHealth() - activePlayer.takeDamage(opponent));
            System.out.println("Hit! "+ difference);
        }
    }

    public void printPlayerStats() {
        System.out.println("Enemy stats:");
        System.out.println(this.getName());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Health: " + this.getHealth());
        System.out.println("Damage: " + this.getDamage());

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
