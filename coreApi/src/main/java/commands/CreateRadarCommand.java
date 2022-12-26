package commands;


import lombok.Getter;



public class CreateRadarCommand extends BaseCommand<String>{
    @Getter
    private float vMax;
    @Getter
    private String longi;
    @Getter
    private String lat;

    public CreateRadarCommand(String id, float vMax, String longi, String lat) {
        super(id);
        this.vMax = vMax;
        this.longi = longi;
        this.lat = lat;
    }


}
