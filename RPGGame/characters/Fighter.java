package RPGGame.characters;

public class Fighter extends PlayableCharacter {

    public Fighter() {
        this.setHealth(50);
        this.setDamage(15);
        this.setLevel(1);
        this.setPotions(2);
        this.setSpecialCounter(0);
    }


    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 6) + 12);
        if (criticalHitVector % 4 == 0) {
            int temp = activePlayer.getDamage();

            activePlayer.setDamage(activePlayer.getDamage() * 2);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            activePlayer.setDamage(temp);
            System.out.println("Critical Hit!");
        } else {
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Hit!");
        }
        this.setSpecialCounter(getSpecialCounter() + 1);
    }

    @Override
    public int takeDamage(GameCharacter c) {

        return (int) (c.getDamage() * (100 - (this.getLevel() * (Math.random() + 2)) / 100));
    }

    @Override
    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if (getSpecialCounter() != 0) {
            attack(opponent, activePlayer);
            attack(opponent, activePlayer);
            attack(opponent, activePlayer);
            System.out.println("BERSERK RAGE!");
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
