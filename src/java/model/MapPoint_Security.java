package model;

import java.io.Serializable;

public class MapPoint implements Serializable
{
    private int mapId;
    private String title;
    private String description;
    
    
    public MapPoint() {}
    
    public MapPoint(int mapId, String title, String description)
    {
        this.mapId = mapId;
        this.title = title;
        this.description = description;
    }
    
    public int getMapPointID() { return mapId; }
    public void setMapPointID(int mapId) { this.mapId = mapId; }
    
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
