package com.mashmellow.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GridInformation {

    /**
     * {
     *   "areaSize" : [5, 5],
     *   "startingPosition" : [1, 2],
     *   "oilPatches" : [
     *     [1, 0],
     *     [2, 2],
     *     [2, 3]
     *   ],
     *   "navigationInstructions" : "NNESEESWNWW"
     * }
     *
     */

    private int[] areaSize = new int[2];
    private int[] startingPosition = new int[2];
    private int[] currentPosition = startingPosition;
    private List<int[]> oilPatches = new ArrayList<>();
    private char[] navigationInstructions;

    public int[] getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int[] areaSize) {
        this.areaSize = areaSize;
    }

    public int[] getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int[] startingPosition) {
        this.startingPosition = startingPosition;
    }

    public List<int[]> getOilPatches() {
        return oilPatches;
    }

    public void setOilPatches(List<int[]> oilPatches) {
        this.oilPatches = oilPatches;
    }

    public int[] inOilZone(int[] position) {
        Optional<int[]> contains = this.oilPatches.stream().filter(pair
                -> pair[0] == position[0] && pair[1] == position[1]).findAny();
        if(contains.isPresent()) {
            return contains.get();
        } else {
            return null;
        }
    }

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public char[] getNavigationInstructions() {
        return navigationInstructions;
    }

    public void setNavigationInstructions(char[] navigationInstructions) {
        this.navigationInstructions = navigationInstructions;
    }
}
