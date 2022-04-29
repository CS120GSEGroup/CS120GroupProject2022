package RPGGame.characters;

public abstract class Character implements Fightable {

    private int health;
    private int armorHealth;
    private int damage;
    private String name;

    public Character() {
    }

    public Character(String name, int health, int attackPoints, int armorHealth) {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorHealth() {
        return armorHealth;
    }

    public void setArmorHealth(int armorHealth) {
        this.armorHealth = armorHealth;
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
}
