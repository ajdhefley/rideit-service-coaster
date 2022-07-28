package com.github.ajdhefley.rideit.services.coaster.model;

import javax.persistence.*;

@Entity
@Table(name="coasterimages")
public class CoasterImage {

    @Id
    @Column(name="coasterimageid", nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer coasterImageId;

    @Column(name="imageurl")
    private String imageUrl;

    @Column(name="base64")
    private String base64;

    @ManyToOne
    @JoinColumn(name="coasterid")
    public Coaster coaster;

    public Integer getCoasterImageId() {
        return this.coasterImageId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getBase64() {
        return this.base64;
    }

}
