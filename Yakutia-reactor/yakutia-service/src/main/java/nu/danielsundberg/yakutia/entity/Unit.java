package nu.danielsundberg.yakutia.entity;

import nu.danielsundberg.yakutia.application.service.landAreas.LandArea;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="Unit.getUnitsByLandArea",
                query = "SELECT u FROM Unit u where landArea = :laName"),
        @NamedQuery(name="Unit.getUnitsByLandAreaAndGamePlayer",
                query = "SELECT u FROM Unit u where landArea =:laName and gamePlayer=:gp")
})
public class Unit implements Serializable {

	private int id;
    private int strength;
    private LandArea landArea;
    private UnitType typeOfUnit;
    private GamePlayer gamePlayer;

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public LandArea getLandArea() {
        return landArea;
    }

    public void setLandArea(LandArea landArea) {
        this.landArea = landArea;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Enumerated(EnumType.STRING)
    public UnitType getTypeOfUnit() {
        return typeOfUnit;
    }

    public void setTypeOfUnit(UnitType typeOfUnit) {
        this.typeOfUnit = typeOfUnit;
    }

    @ManyToOne
    @JoinColumn(name = "gamePlayerId")
    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public boolean isSameGameId(long gameId) {
        return this.gamePlayer.getGameId() == gameId;
    }
}
