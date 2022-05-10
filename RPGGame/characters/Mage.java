package RPGGame.characters;

public class Mage extends PlayableCharacter {


    public Mage() {
        this.setHealth(30);
        this.setDamage(5);
        this.setLevel(1);
        this.setPotions(4);
        this.setSpecialCounter(0);
    }

    public int getSpecialCounter() {
        return specialCounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialCounter = specialCounter;
    }


    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 8) + 4);
        if (criticalHitVector % 4 == 0) {
            int temp = activePlayer.getDamage();
            int difference = opponent.getHealth() - opponent.takeDamage(activePlayer);
            activePlayer.setDamage((activePlayer.getDamage() * 5) / 3);
            opponent.setHealth(difference);
            activePlayer.setDamage(temp);
            System.out.println("Lightning attack!" + opponent.takeDamage(activePlayer));
            setSpecialCounter(getSpecialCounter() + 1);
        } else {
            int difference= opponent.getHealth() - opponent.takeDamage(activePlayer);
            opponent.setHealth(difference);
            System.out.println("Melee Hit!" + opponent.takeDamage(activePlayer));
        }
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
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
