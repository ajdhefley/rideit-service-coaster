package com.github.ajdhefley.rideit.services.coaster;

import com.github.ajdhefley.rideit.services.coaster.model.CoasterImage;
import com.github.ajdhefley.rideit.services.coaster.repository.CoasterImageRepository;
import com.github.ajdhefley.rideit.services.coaster.repository.CoasterRepository;
import com.github.ajdhefley.rideit.services.coaster.model.Coaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoasterController {

    @Autowired
    CoasterRepository coasterRepository;

    @Autowired
    CoasterImageRepository coasterImageRepository;

    @GetMapping("/coasters")
    public ResponseEntity<List<Coaster>> getCoasters() {
        return new ResponseEntity<>(this.coasterRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/coasters/search/{query}")
    public ResponseEntity<List<Coaster>> getCoastersByQuery(@PathVariable("query") String query) {
        return new ResponseEntity<>(this.coasterRepository.findLike(query), HttpStatus.OK);
    }

    @GetMapping("/coaster/{coasterUrl}")
    public ResponseEntity<Coaster> getCoasterByUrl(@PathVariable("coasterUrl") String coasterUrl) {
        return new ResponseEntity<>(this.coasterRepository.findByUrl(coasterUrl), HttpStatus.OK);
    }

    @GetMapping("/coaster/{coasterUrl}/images")
    public ResponseEntity<List<CoasterImage>> getCoasterImagesByUrl(@PathVariable("coasterUrl") String coasterUrl) {
        return new ResponseEntity<>(this.coasterImageRepository.findByCoasterUrl(coasterUrl), HttpStatus.OK);
    }

}