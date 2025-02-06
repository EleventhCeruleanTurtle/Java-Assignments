package assignment6;

// Human inhabitant class
public class Human extends Inhabitants{
    // type of human (hunter/healer)
    private String type;
    // magic rating of human
    private int magicRating;

    /**
     * getter for type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * getter for magic rating
     * @return magicRating
     */
    public int getMagicRating() {
        return magicRating;
    }

    /**
     * setter for magic rating
     * @param magicRating the healers magic rating
     */
    public void setMagicRating(int magicRating) {
        this.magicRating = magicRating;
    }

    /**
     * constructor for human, calls inhabitants constructor, randomizes which type, if hunter magicRating is set to 0, if healer magic rating is random between 1-10
     */
    public Human() {
        super();
        int typeRandomizer = (int)Math.round((Math.random()*1)+1);
        if (typeRandomizer == 1) {
            this.type = "hunter";
            this.magicRating = 0;
        } else if (typeRandomizer == 2) {
            this.type = "healer";
            this.magicRating = (int)Math.round((Math.random()*9)+1);
        }
    }

    /**
     * constructor for human, calls inhabitants constructor, checks what type was given, if hunter magicRating is set to 0, if healer magic rating is random between 1-10
     * @param health
     * @param strength
     * @param agility
     * @param name
     * @param type
     */
    public Human(int health, int strength, int agility, String name, String type) {
        super(health, strength, agility, name);
        type = type.toLowerCase();
        if (type.contains("hunter")) {
            this.type = "hunter";
            this.magicRating = 0;
        } else if (type.contains("healer")) {
            this.type = "healer";
            this.magicRating = (int)Math.round((Math.random()*9)+1);
        }
    }

    /**
     * attacks target, calls inhabitants attack, if hunter stats doubled for attack
     */
    public void attack(Inhabitants inhabitant) {
        if (this.type.contains("hunter")) {
            this.setHealth(this.getHealth()*2);
            this.setAgility(this.getAgility()*2);
            this.setStrength(this.getStrength()*2);
            super.attack(inhabitant);
            this.setHealth(this.getHealth()/2);
            this.setAgility(this.getAgility()/2);
            this.setStrength(this.getStrength()/2);
        } else {
            super.attack(inhabitant);
        }
    }

    /**
     * heal target, checks magic rating, checks if alive, increases health by magic rating / 2.5
     * @param inhabitant
     */
    public void heal(Inhabitants inhabitant) {
        if (this.magicRating > 0) {
            if (isStatus()) {
                int healValue = (int)Math.round(this.magicRating/2.5);
                if (healValue <= 0) {
                    healValue = 1;
                }
                this.setMagicRating(this.getMagicRating()-1);
                inhabitant.setHealth(inhabitant.getHealth()+healValue);
                System.out.println(inhabitant.getName() + " was healed " + healValue + " and has " + inhabitant.getHealth() + " health left. " + this.getName() + " has " + this.getMagicRating() + " magic left.");
            } else {
                System.out.println("This inhabitant is dead.");
            }
        } else {
            System.out.println("This inhabitant has no magic.");
        }
    }

    /**
     * return string with type, magic rating and stats from inhabitants toString
     */
    @Override
    public String toString() {
        return "Human [type=" + type + ", magicRating=" + magicRating + ", " + super.toString() + "]";
    }

    
}
