package vod.web.rest.dto;

import lombok.Data;

@Data
public class DishDTO {
    private String name;
    private String poster;
    private float rating;
    private int chefId;
}
