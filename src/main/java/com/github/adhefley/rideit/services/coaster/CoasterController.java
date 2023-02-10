package com.github.ajdhefley.rideit.services.coaster;

import com.github.ajdhefley.rideit.services.coaster.model.CoasterImage;
import com.github.ajdhefley.rideit.services.coaster.repository.CoasterImageRepository;
import com.github.ajdhefley.rideit.services.coaster.repository.CoasterRepository;
import com.github.ajdhefley.rideit.services.coaster.model.Coaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoasterController {

    @Autowired
    CoasterRepository coasterRepository;

    @Autowired
    CoasterImageRepository coasterImageRepository;

    @RequestMapping(path = "/coaster", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Coaster> saveCoaster(@RequestBody Coaster coaster) {
        return new ResponseEntity<>(this.coasterRepository.save(coaster), HttpStatus.OK);
    }

    @GetMapping("/coasters")
    public ResponseEntity<List<Coaster>> getCoasters() {
        return new ResponseEntity<>(this.coasterRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/coasters/search/{query}")
    public ResponseEntity<List<Coaster>> getCoastersByQuery(@PathVariable("query") String query) {
        return new ResponseEntity<>(this.coasterRepository.findLike(query), HttpStatus.OK);
    }

    @GetMapping("/coaster/url/{coasterUrl}")
    public ResponseEntity<Coaster> getCoasterByUrl(@PathVariable("coasterUrl") String coasterUrl) {
        return new ResponseEntity<>(this.coasterRepository.findByUrl(coasterUrl), HttpStatus.OK);
    }

    @GetMapping("/coaster/url/{coasterUrl}/images")
    public ResponseEntity<List<CoasterImage>> getCoasterImagesByUrl(@PathVariable("coasterUrl") String coasterUrl) {
        return new ResponseEntity<>(this.coasterImageRepository.findByCoasterUrl(coasterUrl), HttpStatus.OK);
    }

    @RequestMapping(path = "/coaster/{coasterId}/image", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<CoasterImage> saveCoasterImage(@PathVariable("coasterId") int coasterId, @RequestBody CoasterImage image) {
        image.coaster = this.coasterRepository.findById(coasterId).get();
        return new ResponseEntity<>(this.coasterImageRepository.save(image), HttpStatus.OK);
    }

    @RequestMapping(path = "coaster/{coasterId}/image", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<CoasterImage> updateCoasterImage(@PathVariable("coasterId") int coasterId, @RequestBody CoasterImage image) {
        image.coaster = this.coasterRepository.findById(coasterId).get();
        return new ResponseEntity<>(this.coasterImageRepository.save(image), HttpStatus.OK);
    }

}
