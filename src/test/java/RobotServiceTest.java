import com.mashmellow.exception.OutTheGridException;
import com.mashmellow.model.CleanerInfo;
import com.mashmellow.model.GridInformation;
import com.mashmellow.service.RobotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RobotServiceTest {

    @InjectMocks
    RobotService robotService;

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

    @Test
    public void cleanWithValidInput() throws OutTheGridException {
        GridInformation gridInformation = new GridInformation();
        gridInformation.setAreaSize(new int[]{5,5});
        gridInformation.setStartingPosition(new int[]{1, 2});
        List<int[]> oilPatches = new ArrayList<> ();
        oilPatches.add(new int[]{1, 0});
        oilPatches.add(new int[]{2, 2});
        oilPatches.add(new int[]{2, 3});
        gridInformation.setOilPatches(oilPatches);
        gridInformation.setNavigationInstructions("NNESEESWNWW".toCharArray());
        CleanerInfo output = robotService.clean(gridInformation);
        assertEquals(1, output.getFinalPosition()[0]);
        assertEquals(3, output.getFinalPosition()[1]);
        assertEquals(1, output.getOilPatchesCleaned());
    }

    @Test(expected = OutTheGridException.class)
    public void cleanWithInValidOutsideTheGridInput() throws OutTheGridException {
        GridInformation gridInformation = new GridInformation();
        gridInformation.setAreaSize(new int[]{5,5});
        gridInformation.setStartingPosition(new int[]{4, 2});
        List<int[]> oilPatches = new ArrayList<> ();
        oilPatches.add(new int[]{1, 0});
        oilPatches.add(new int[]{2, 2});
        oilPatches.add(new int[]{2, 3});
        gridInformation.setOilPatches(oilPatches);
        gridInformation.setNavigationInstructions("NNESEESWNWW".toCharArray());
        CleanerInfo output = robotService.clean(gridInformation);
    }

}