package RPGGame.characters;

public class Mage extends Character{

    private int armorPercentage;

    public Mage() {
    }

    public Mage(String name, int health, int damage, int armorPercentage) {
        super(name, health, damage, armorPercentage);
        this.armorPercentage = armorPercentage;
    }
    @Override
    public void attack(Character opponent, Character activePlayer) {
        opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
    }

    @Override
    public int takeDamage(Character activePlayer) {
        return (activePlayer.getDamage() * (100 - armorPercentage) / 100);
    }

    @Override
    public int heal() {
        return 0;
    }

    @Override
    public void block() {

    }

    @Override
    public void criticalAttack() {

    }

    @Override
    public void useSpecialAbility() {

    }
}
