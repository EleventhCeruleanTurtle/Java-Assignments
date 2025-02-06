package assignment6;

import java.util.Arrays;

// WerewolfPack class, an array of Werewolf and Witch objects with methods effecting it
public class WerewolfPack {
    // array of Werewolf or Witch Objects
    private Object[] pack = new Object[0];
    // string of array containing pack memebers
    public String getPack() {
        String test = Arrays.toString(pack);
        return test;
    }

    /**
     * takes given inhabitant and adds them to pack if werewolf or first witch, blocks more then one witch and anything other than witch or werewolf
     * @param inhabitant the inhabitant joining the pack
     */
    public void joinPack(Inhabitants inhabitant) {
        if (inhabitant instanceof Werewolf) {
            Object[] newPack = new Object[pack.length+1];
            for (int i = 0; i < pack.length; i++) {
                newPack[i] = pack[i];
            }
            int packLength = pack.length;
            if (packLength == 0) {
                inhabitant.setName("Alpha "+inhabitant.getName());
            }
            newPack[packLength] = inhabitant;
            pack = newPack;
            ((Werewolf) inhabitant).setPack(this.toString());
        } else if (inhabitant instanceof Witch) {
            boolean hasWitch = false;
            for (int i = 0; i < pack.length; i++) {
                if (pack[i] instanceof Witch) {
                    System.out.println("Witch already in pack.");
                    hasWitch = true;
                    break;
                }
            }
            if (hasWitch == false) {
                Object[] newPack = new Object[pack.length+1];
                for (int i = 0; i < pack.length; i++) {
                    newPack[i] = pack[i];
                }
                int packLength = pack.length;
                newPack[packLength] = inhabitant;
                pack = newPack;
                ((Witch) inhabitant).setPack(this.toString());
            }
        } else {
            System.out.println("Inhabitant can not join Werewolf pack.");
        }
    }

    /**
     * looks through pack to find witch, skips over them when recreating pack, removes pack from witch's pack variable
     * @param witch the witch in the pack
     */
    public void kickWitch(Witch witch) {
        int witchIndex = 0;
        for (int i = 0; i < pack.length; i++) {
            if (pack[i] instanceof Witch) {
                witchIndex = i;
                break;
            }
        }
        Object[] newPack = new Object[pack.length-1];
        for (int i = 0; i < pack.length; i++) {
            if (witchIndex == i) {
                continue;
            }
            newPack[i] = pack[i];
        }
        pack = newPack;
        witch.setPack("");
    }

    /**
     * returns string with each pack memeber and their toStrings
     */
    @Override
    public String toString() {
        return "WerewolfPack{" +
                "pack=" + Arrays.toString(pack) +
                '}';
    }
}
