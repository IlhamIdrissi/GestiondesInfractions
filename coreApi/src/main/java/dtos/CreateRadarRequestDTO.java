package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateRadarRequestDTO {
    private float vMax;
    private String longi;
    private String lat;
}
