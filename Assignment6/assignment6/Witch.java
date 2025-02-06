package assignment6;

// Witch inhabitant class
public class Witch extends Inhabitants{
    // string of pack array
    private String pack;

    // set pack as string of werewolf pack
    public void setPack(String pack) {
        this.pack = pack;
    }

    /**
     * constructor for witch, calls Inhabitants constructor, checks if health and agility are under 5, if so sets to 5
     */
    public Witch() {
        super();
        if (this.getHealth() < 5) {
            this.setHealth(5);
        }
        if (this.getAgility() < 5) {
            this.setAgility(5);
        }
    }

    /**
     * constructor for witch, calls Inhabitants constructor, checks if health and agility are under 5, if so sets to 5
     * @param health witch health
     * @param strength witch strength
     * @param agility witch agility
     * @param name withc name
     */
    public Witch(int health, int strength, int agility, String name) {
        super(health, strength, agility, name);
        if (this.getHealth() < 5) {
            this.setHealth(5);
        }
        if (this.getAgility() < 5) {
            this.setAgility(5);
        }
    }

    /**
     * checks if witch is in pack with target, if not calls Inhabitants attack
     */
    public void attack(Inhabitants inhabitant) {
        if (this.pack.contains(this.toString())) {
            System.out.println("Can not attack target in the same pack.");
        } else {
            super.attack(inhabitant);
        }
    }

    /**
     * adds magic power to healer based on strength
     * @param human the target
     */
    public void strengthen(Human human) {
        if (this.isStatus()) {
            if (human.getType().contains("healer")) {
                int increase = Math.round(this.getStrength()/3);
                if (increase <= 0) {
                    increase = 1;
                }
                human.setMagicRating(human.getMagicRating()+increase);
                System.out.println(this.getName() + " has increased " + human.getName() + "'s magic by " + increase );
            } else {
                System.out.println("This human is not a healer.");
            }
        }
    }

    /**
     * returns strings with witch's stats by calling Inhabitants toString
     */
    @Override
    public String toString() {
        return "Witch{" + super.toString() + "}";
    }
}
