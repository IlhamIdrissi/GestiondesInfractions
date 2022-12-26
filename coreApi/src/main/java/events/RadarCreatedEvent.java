package events;

import lombok.Getter;

import java.util.Date;

public class RadarCreatedEvent extends BaseEvent<String>{
    @Getter
    private float vMax;
    @Getter
    private String longi;
    @Getter
    private String lat;


    public RadarCreatedEvent(String id, float vMax, String longi, String lat) {
        super(id);
        this.vMax = vMax;
        this.longi = longi;
        this.lat = lat;

    }
}
