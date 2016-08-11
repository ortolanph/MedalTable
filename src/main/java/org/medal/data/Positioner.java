package org.medal.data;

import org.medal.entity.MedalShelf;

public class Positioner {
    private int currentPosition;
    private int goldenMedalAmount;
    private int silverMedalAmount;
    private int bronzeMedalAmount;
    private int skipCounter;

    public Positioner() {
        currentPosition = 0;
        goldenMedalAmount = 0;
        silverMedalAmount = 0;
        bronzeMedalAmount = 0;
        skipCounter = 0;
    }

    public int positionFor(MedalShelf medalShelf) {
        boolean changed = medalCountHasChanged(medalShelf);

        if (changed) {
            currentPosition++;
            goldenMedalAmount = medalShelf.getGold();
            silverMedalAmount = medalShelf.getSilver();
            bronzeMedalAmount = medalShelf.getBronze();
        } else {
            skipCounter++;
        }

        currentPosition = (changed) ? currentPosition + skipCounter : currentPosition;

        if(changed) {
            skipCounter = 0;
        }

        return currentPosition;
    }

    private boolean medalCountHasChanged(MedalShelf medalShelf) {
        boolean goldenMedalHasChanged = goldenMedalAmount != medalShelf.getGold();
        boolean silverMedalHasChanged = silverMedalAmount != medalShelf.getSilver();
        boolean bronzeMedalHasChanged = bronzeMedalAmount != medalShelf.getBronze();

        if (goldenMedalHasChanged || silverMedalHasChanged || bronzeMedalHasChanged) {
            return true;
        } else {
            return false;
        }
    }
}
