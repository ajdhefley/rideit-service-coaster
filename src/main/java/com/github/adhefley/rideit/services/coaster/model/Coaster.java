package com.github.ajdhefley.rideit.services.coaster.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="coasters")
public class Coaster {

    @Id
    @Column(name="coasterid", nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer coasterId;

    @Column(name="name")
    private String name;

    @Column(name="park")
    private String park;

    @Column(name="location")
    private String location;

    @Column(name="type")
    private String type;

    @Column(name="model")
    private String model;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="lengthinft")
    private Float lengthInFt;

    @Column(name="heightinft")
    private Float heightInFt;

    @Column(name="dropinft")
    private Float dropInFt;

    @Column(name="speedinmph")
    private Float speedInMph;

    @Column(name="inversions")
    private Integer inversions;

    @Column(name="colorprimary")
    private String colorPrimary;

    @Column(name="colorsecondary")
    private String colorSecondary;

    @Column(name="openingdate")
    private String openingDate;

    @Column(name="closedate")
    private String closeDate;

    @Column(name="url")
    private String url;

    @Column(name="carspertrain")
    private Integer carsPerTrain;

    @Column(name="rowspercar")
    private Integer rowsPerCar;

    @Column(name="insideseatsperrow")
    private Integer insideSeatsPerRow;

    @Column(name="outsideseatsperrow")
    private Integer outsideSeatsPerRow;

    public Integer getCoasterId() { return this.coasterId; }

    public String getName() { return this.name; }

    public String getPark() { return this.park; }

    public String getLocation() { return this.location; }

    public String getType() { return this.type; }

    public String getModel() { return this.model; }

    public String getManufacturer() { return this.manufacturer; }

    public Float getLengthInFt() { return this.lengthInFt; }

    public Float getHeightInFt() { return this.heightInFt; }

    public Float getDropInFt() { return this.dropInFt; }

    public Float getSpeedInMph() { return this.speedInMph; }

    public Integer getInversions() { return this.inversions; }

    public String getColorPrimary() { return this.colorPrimary; }

    public String getColorSecondary() { return this.colorSecondary; }

    public String getOpeningDate() { return this.openingDate; }

    public String getCloseDate() { return this.closeDate; }

    public String getUrl() { return this.url; }

    public Integer getCarsPerTrain() { return this.carsPerTrain; }

    public Integer getRowsPerCar() { return this.rowsPerCar; }

    public Integer getInsideSeatsPerRow() { return this.insideSeatsPerRow; }

    public Integer getOutsideSeatsPerRow() { return this.outsideSeatsPerRow; }

}
