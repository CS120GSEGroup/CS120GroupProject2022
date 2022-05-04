package RPGGame.characters;

public class Mage extends PlayableCharacter {


    public Mage() {
        this.setHealth(30);
        this.setDamage(5);
        this.setLevel(1);
        this.setPotions(4);
        this.setSpecialCounter(0);
    }


    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 8) + 4);
        if (criticalHitVector % 4 == 0) {
            int temp = activePlayer.getDamage();
            activePlayer.setDamage((activePlayer.getDamage() * 5) / 3);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            activePlayer.setDamage(temp);
            System.out.println("Lightning attack!");
            setSpecialCounter(getSpecialCounter() + 1);
        } else {
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Melee Hit!");
        }
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return (int) (c.getDamage() * (100 - (this.getLevel() * (Math.random() + 1)) / 100));
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if (activePlayer.getSpecialCounter() > 0) {
            opponent.setHealth(opponent.getHealth() / 3);
            System.out.println("FIREBALL!");
        } else {
            int originalDamage = activePlayer.getDamage();
            activePlayer.setDamage(activePlayer.getDamage() * activePlayer.getLevel());
            attack(opponent, activePlayer);
            System.out.println("Firey burst");
            activePlayer.setDamage(originalDamage);
        }
    }


    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }

    @Override
    public String characterToString() {
        return "Mage";
    }

    @Override
    public String specialMoveToString() {
        return "Fireball";
    }

    @Override
    public String weaponToString() {
        return "Staff and Spellbook";
    }
}
