package assignment6;

// Inhabitant class, stats, and methods to effect those stats
public class Inhabitants {
    // health, strength and agility values of an Inhabitant
    private int health, strength, agility;
    // inhabitant name
    private String name;
    // whether inhabitant is alive or not
    private boolean status;

    /**
     * gets health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * gets strength
     * @return strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * gets agility
     * @return agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * gets name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets status
     * @return status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *  sets health
     * @param health the health of the inhabitant
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *  sets strength
     * @param health the strength of the inhabitant
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     *  sets agility
     * @param health the agility of the inhabitant
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     *  sets name
     * @param health the name of the inhabitant
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  sets status
     * @param health the status of the inhabitant
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * inhabitants constructor, randomly assigns health, strength, and agility within range 1-10, name is set to "Random", and status to true
     */
    public Inhabitants() {
        this.health = (int)Math.round((Math.random()*9)+1);
        this.strength = (int)Math.round((Math.random()*9)+1);
        this.agility = (int)Math.round((Math.random()*9)+1);
        this.name = "Random";
        this.status = true;
    }

    /**
     * constructor for inhabitants, takes given values and sets them, sets status to true
     * @param health health of inhabitant
     * @param strength strength of inhabitant
     * @param agility agility of inhabitant
     * @param name name of inhabitant
     */
    public Inhabitants(int health, int strength, int agility, String name) {
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.name = name;
        this.status = true;
    }

    /**
     * increases health by 1, assignment specifically mentions creating this
     */
    public void incrementHealthUp() {
        if (this.health < 10) {
            this.health = health++;
        }
    }

    /**
     * decreases health by 1, assignment specifically mentions creating this
     */
    public void incrementHealthDown() {
        if (this.health > 0) {
            this.health = health--;
        }
    }

    /**
     * increases strength by 1, assignment specifically mentions creating this
     */
    public void incrementStrengthUp() {
        if (this.strength < 10) {
            this.strength = strength++;
        }
    }

    /**
     * decreases strength by 1, assignment specifically mentions creating this
     */
    public void incrementStrengthDown() {
        if (this.strength > 0) {
            this.strength = strength--;
        }
    }

    /**
     * increases agility by 1, assignment specifically mentions creating this
     */
    public void incrementAgilityUp() {
        if (this.agility < 10) {
            this.agility = agility++;
        }
    }

    /**
     * decreases agility by 1, assignment specifically mentions creating this
     */
    public void incrementAgilityDown() {
        if (this.agility > 0) {
            this.agility = agility--;
        }
    }

    /**
     * if inhabitant is alive, calculate defense (random number, 1-10), calculate attack (average of stats),
     * calculates damage (def/att), if damage is less than 1 it is set to 1, set target health to targets health - damage
     * if target health drops below 0, set staus to false
     * @param inhabitant the target of the attack
     */
    public void attack(Inhabitants inhabitant) {
        if (status) {
            int defense = (int)Math.round((Math.random()*9)+1);
            int attack = Math.round((this.getStrength() + this.getHealth() + this.getAgility()) / 3);
            int damage = attack/defense;
            if (damage <= 0) {
                damage = 1;
            }
            int newHealth = inhabitant.getHealth() - damage;
            if (newHealth <= 0) {
                inhabitant.setStatus(false);
                inhabitant.setHealth(0);
            } else {
                inhabitant.setHealth(newHealth);
            }
            System.out.println(this.getName() + " dealt " + damage + " damage and " + inhabitant.getName() + " has " + inhabitant.getHealth() + " health");
        } else {
            System.out.println("This inhabitant is dead.");
        }
    }

    /**
     * returns string containing stats
     */
    @Override
    public String toString() {
        return "Inhabitants [health=" + health + ", strength=" + strength + ", agility=" + agility + ", name=" + name
                + ", status=" + status + "]";
    }

}
