package org.choongang.mycard.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyCardDetail {
    private long seq;
    private long rowNum;
    private String name;
    private int weight;
    private int height;
    private int baseExperience;
    private String frontImage;
    private String backImage;
    private String rawData;


}