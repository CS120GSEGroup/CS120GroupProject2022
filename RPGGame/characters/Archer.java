package RPGGame.characters;

public class Archer extends PlayableCharacter {
    public Archer() {
        this.setHealth(40);
        this.setDamage(6);
        this.setLevel(1);
        this.setSpecialCounter(0);
        this.setWeaponsName("bow and arrows");

    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
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


    @Override
    public void useSpecialAbility(GameCharacter opponent, GameCharacter activePlayer) {
        int specialAbilityVector = (int) ((Math.random() * 9) + 6);
        if (specialAbilityVector % 3 == 0) {
            opponent.setHealth(0);
            System.out.println("Headshot!");
        }else{
            System.out.println("Headshot failed");
        }
    }

    @Override
    public String toString() {
        return this.getName() + " the Archer";
    }
}
