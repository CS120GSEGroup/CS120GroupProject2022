package RPGGame.characters;


public class Archer extends PlayableCharacter {
    public Archer() {
        this.setHealth(40);
        this.setDamage(10);
        this.setLevel(1);
        this.setPotions(3);
        this.setSpecialCounter(0);

    }

    public Archer(PlayableCharacter p) {
        super(p);
    }

    @Override
    public void attack(NPC opponent, PlayableCharacter activePlayer) {
        int criticalHitVector = (int) ((Math.random() * 3) + 5);
        if (criticalHitVector % 5 == 0) {
            int temp = activePlayer.getDamage();

            activePlayer.setDamage(activePlayer.getDamage() * 2);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            activePlayer.setDamage(temp);
            System.out.println("Crippling shot!");
            setSpecialCounter(getSpecialCounter() + 1);
        } else {
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            System.out.println("Melee Hit!");
        }
        setSpecialCounter(getSpecialCounter() + 1);
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.getDamage();
    }


    @Override
    public void useSpecialAbility(NPC opponent, PlayableCharacter activePlayer) {
        if (getSpecialCounter() > 0) {
            opponent.setHealth(0);
            System.out.println("Headshot!");
            setSpecialCounter(getSpecialCounter() - 1);

        } else {
            System.out.println("Headshot failed");
            setSpecialCounter(getSpecialCounter() + 1);
        }
    }

    @Override
    public String specialMoveToString() {
        return "Headshot";
    }

    @Override
    public String characterToString() {
        return "Archer";
    }

    @Override
    public String weaponToString() {
        return "Bow and Arrows";
    }
}
