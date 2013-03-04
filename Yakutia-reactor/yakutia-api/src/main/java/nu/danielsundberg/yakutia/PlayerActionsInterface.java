package nu.danielsundberg.yakutia;

import nu.danielsundberg.yakutia.exceptions.LandIsNotNeighbourException;
import nu.danielsundberg.yakutia.exceptions.TurnCannotBeEndedException;
import nu.danielsundberg.yakutia.landAreas.LandArea;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PlayerActionsInterface {

	public boolean attackLandArea(LandArea from, LandArea to) throws LandIsNotNeighbourException;

    public List<LandArea> getPlayersLandAreas(long playerId, long gameId);

    public void moveUnits(long playerId, long gameId);

    public void placeUnits(long playerId, long gameId, LandArea landArea, int extraUnits);

    public boolean endTurn(long playerId, long gameId);

}
