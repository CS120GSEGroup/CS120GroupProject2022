package RPGGame.characters;

public interface Fightable {
    void attack(GameCharacter opponent, GameCharacter activePlayer);

    int takeDamage(GameCharacter activePlayer);

    int heal();

    void block();

    void criticalAttack();

    void useSpecialAbility();
}
