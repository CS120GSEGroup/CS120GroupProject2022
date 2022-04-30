package RPGGame.characters;

public abstract class GameCharacter implements Fightable {

    private int health;
    private int damage;
    private String name;
    private int level;
    private int potions;


    public GameCharacter() {
    }

    public GameCharacter(int health, int attackPoints, int level, int potions) {
        this.health = health;
        this.damage = attackPoints;
        this.level = level;
        this.potions = potions;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public void useSpecialAbility(GameCharacter opponent, GameCharacter activePlayer) {

    }


    public final boolean heal() {
        if (this.getPotions() > 0) {
            this.setHealth(this.getHealth() + 10);
            this.setPotions(this.getPotions() - 1);
            return true;
        }
        System.out.println("No potions left");
        return false;
    }
}
