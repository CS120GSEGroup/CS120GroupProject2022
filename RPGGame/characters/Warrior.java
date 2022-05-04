package RPGGame.characters;

public class Warrior extends PlayableCharacter {

    private int armorPercentage;

    public Warrior() {
        this.setHealth(50);
        this.setDamage(15);
        this.setLevel(1);
        this.setPotions(2);
        this.setSpecialCounter((int)(Math.random()*5));
        this.setArmorPercentage(getLevel()*5);
    }


    public int getArmorPercentage() {
        return armorPercentage;
    }

    public void setArmorPercentage(int armorPercentage) {
        this.armorPercentage = armorPercentage;
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 6) + 4);
        if (criticalHitVector % 4 == 0) {
            int temp = activePlayer.getDamage();
            int difference = opponent.getHealth() - opponent.takeDamage(activePlayer);
            activePlayer.setDamage(activePlayer.getDamage() +5);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            activePlayer.setDamage(temp);
            System.out.println("Critical Hit! " + difference);
        } else {
            int difference = opponent.getHealth() - opponent.takeDamage(activePlayer);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Hit! " + difference);
        }
        this.setSpecialCounter(getSpecialCounter() + 1);
    }

    @Override
    public int takeDamage(GameCharacter c) {

       return (this.getDamage() * (100 - getArmorPercentage()) / 100);
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if (getSpecialCounter() != 0) {
            System.out.println("BERSERK RAGE!");
            activePlayer.setDamage(activePlayer.getDamage()*2);
            attack(opponent, activePlayer);
            attack(opponent, activePlayer);
            attack(opponent, activePlayer);
            setSpecialCounter(getSpecialCounter() - 1);
        } else {
            int realDamage = activePlayer.getDamage();
            activePlayer.setDamage(activePlayer.getDamage() / 2);
            activePlayer.attack(opponent, activePlayer);
            activePlayer.setDamage(realDamage);
            setSpecialCounter(getSpecialCounter() + 1);
        }

    }


    @Override
    public String specialMoveToString() {
        return "Berserker Rage";
    }

    @Override
    public String characterToString() {
        return "Warrior";
    }

    @Override
    public String weaponToString() {
        return "Sword and Shield";
    }
}
