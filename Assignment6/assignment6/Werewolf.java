package assignment6;

// Werewolf inhabitant class
public class Werewolf extends Inhabitants{
    // string of pack array
    private String pack;

    // set pack as string of werewolf pack
    public void setPack(String pack) {
        this.pack = pack;
    }

    /**
     * constructor for werewolf, calls inhabitant constructor, if any stats below 5, set to 5
     */
    public Werewolf() {
        super();
        if (this.getHealth() < 5) {
            this.setHealth(5);
        }
        if (this.getStrength() < 5) {
            this.setStrength(5);
        }
        if (this.getAgility() < 5) {
            this.setAgility(5);
        }
    }

    /**
     * constructor for werewolf, calls inhabitant constructor, if any stats below 5, set to 5
     * @param health health of werewolf
     * @param strength strength of werewolf
     * @param agility agility of werewolf
     * @param name name of werewolf
     */
    public Werewolf(int health, int strength, int agility, String name) {
        super(health, strength, agility, name);
        if (this.getHealth() < 5) {
            this.setHealth(5);
        }
        if (this.getStrength() < 5) {
            this.setStrength(5);
        }
        if (this.getAgility() < 5) {
            this.setAgility(5);
        }
    }

    /**
     * attack inhabitant, checks if target is in pack, if not calls inhabitant attack
     */
    public void attack(Inhabitants inhabitant) {
        if (this.pack.contains(this.toString())) {
            System.out.println("Can not attack target in the same pack.");
        } else {
            super.attack(inhabitant);
        }
    }


    /**
     * return string with inhabitant stats
     */
    @Override
    public String toString() {
        return "Werewolf{"+super.toString()+"}";
    }
}
