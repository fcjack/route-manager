package br.edu.fa7.domain;

import javax.persistence.Embeddable;

/**
 * Created by jackson on 3/23/16.
 */
@Embeddable
public class Position {

    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
