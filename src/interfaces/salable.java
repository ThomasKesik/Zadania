package interfaces;

import excaptions.NoCarInGarageException;
import excaptions.NoCashForCarException;
import excaptions.NoSpaceInGarageException;
import main.Human;

public interface salable {
    void sell (Human seller, Human buyer, Double price) throws NoCarInGarageException, NoCashForCarException, NoSpaceInGarageException;
}
