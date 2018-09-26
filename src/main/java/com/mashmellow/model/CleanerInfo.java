package com.mashmellow.model;

public class CleanerInfo {

    int[] finalPosition = new int[2];
    int oilPatchesCleaned = 0;

    public int[] getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(int[] finalPosition) {
        this.finalPosition = finalPosition;
    }

    public int getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }

    public void setOilPatchesCleaned(int oilPatchesCleaned) {
        this.oilPatchesCleaned = oilPatchesCleaned;
    }

    public void incrementOilPatchesCleaned() {
        this.oilPatchesCleaned++;
    }
}
