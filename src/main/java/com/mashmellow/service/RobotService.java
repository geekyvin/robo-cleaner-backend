package com.mashmellow.service;

import com.mashmellow.exception.OutTheGridException;
import com.mashmellow.model.CleanerInfo;
import com.mashmellow.model.GridInformation;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    public CleanerInfo clean(GridInformation gridInformation) throws OutTheGridException {

        int[] currentPosition = gridInformation.getStartingPosition();
        int[] nextPosition;
        CleanerInfo cleanerInfo = new CleanerInfo();
        int i = 0;

        //Read all the navigational instruction
        while(i < gridInformation.getNavigationInstructions().length) {

            //based on the direction increment/decrement x/y
            switch(gridInformation.getNavigationInstructions()[i]) {
                case 'E':
                    nextPosition = new int[]{currentPosition[0] + 1, currentPosition[1]};
                    //check if the future position is inside the grid
                    if (withInArea(nextPosition, gridInformation.getAreaSize()))
                        currentPosition = nextPosition;
                    break;
                case 'W':
                    nextPosition = new int[]{currentPosition[0] - 1, currentPosition[1]};
                    if (withInArea(nextPosition, gridInformation.getAreaSize()))
                        currentPosition = nextPosition;
                    break;
                case 'N':
                    nextPosition = new int[]{currentPosition[0], currentPosition[1] + 1};
                    if (withInArea(nextPosition, gridInformation.getAreaSize()))
                        currentPosition = nextPosition;
                    break;
                case 'S':
                    nextPosition = new int[]{currentPosition[0], currentPosition[1] - 1};
                    if (withInArea(nextPosition, gridInformation.getAreaSize()))
                        currentPosition = nextPosition;
                    break;
            }

            // If the current position is found in the oilZone - remove the position from the oil patches list
            // and increment the count of cleaned cell
            int[] foundInOilZone = gridInformation.inOilZone(currentPosition);

            if(foundInOilZone != null) {
                cleanerInfo.incrementOilPatchesCleaned();
                gridInformation.getOilPatches().remove(foundInOilZone);
            }
            
            i++;
        }

        cleanerInfo.setFinalPosition(currentPosition);

        return cleanerInfo;
    }

    private boolean withInArea(int[] nextPosition, int[] areaSize) throws OutTheGridException {
        if(nextPosition[0] >= 0 && nextPosition[0] < areaSize[0]
                && nextPosition[1] >= 0 && nextPosition[1] < areaSize[1]) {
            return true;
        }
        throw new OutTheGridException("Invalid Direction!");
    }

}
