package com.github.ajdhefley.rideit.services.coaster.model;

import javax.persistence.*;
import com.github.ajdhefley.rideit.services.coaster.model.Coaster;

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

    @Column(name="width")
    private Integer width;

    @Column(name="height")
    private Integer height;

    @Column(name="verified")
    private Boolean verified;

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

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Boolean getVerified() {
        return this.verified;
    }
    
}
