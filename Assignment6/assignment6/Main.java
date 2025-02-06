package assignment6;

// Testing area for assignment 6
public class Main {
    public static void main(String[] args) {
//      Testing
//      Creating two werewolves and add to pack
        System.out.println("Werewolves");
        Werewolf randomWerewolf = new Werewolf();
        Werewolf werewolf = new Werewolf(7,3,8,"Jeff"); // strength will be changed to 5
        WerewolfPack werewolfPack = new WerewolfPack();
        werewolfPack.joinPack(werewolf); // "Jeff" will be alpha because they are first in pack
        System.out.println(randomWerewolf);
        System.out.println(werewolf);
        System.out.println(werewolfPack);
//      Creating two witches
        System.out.println("Witches");
        Witch randomWitch = new Witch();
        Witch witch = new Witch(4,6,2,"Emma"); // health and agility will be changed to 5
        System.out.println(randomWitch);
        System.out.println(witch);
        // Creating three humans
        System.out.println("Humans");
        Human randomHuman = new Human();
        Human humanHealer = new Human(4,2,7,"Healer","healer");
        Human humanHunter = new Human(3,1,1,"Hunter","hunter");
        System.out.println(randomHuman);
        System.out.println(humanHealer);
        System.out.println(humanHunter);
        // Witch and pack interactions
        System.out.println("Witch and pack interactions");
        werewolfPack.joinPack(witch); // add witch
        System.out.println(werewolfPack);
        werewolfPack.joinPack(randomWitch); // try to add second witch
        System.out.println(werewolfPack);
        witch.attack(werewolf); // try to attack pack member
        werewolfPack.kickWitch(witch); // remove witch
        System.out.println(werewolfPack);
        witch.attack(werewolf); // attacks werewolf now that they are not in pack
        // Human interactions
        System.out.println("Human interactions");
        witch.attack(humanHunter); // attack human hunter
        humanHealer.heal(humanHunter); // healer heals hunter
        humanHunter.attack(witch); // hunter double damage
        humanHunter.heal(humanHealer); // hunter cant heal because no magic
        witch.strengthen(humanHealer); // strengthen healer
    }
}
