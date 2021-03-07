package com.mediastore.api.controller;

import com.mediastore.api.model.ArtistModel;
import com.mediastore.api.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/all-artists")
    public Iterable<ArtistModel> allArtists() {
        return artistRepository.findAll();
    }

    @PostMapping("/save-artists")
    public void saveArtist(ArtistModel artist) {
        artistRepository.save(artist);
    }

    @GetMapping("/find-artist/{id}")
    public ArtistModel findArtistById(@PathVariable Integer id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist id not found"));
    }

    @GetMapping("/find-artist-by-name/{name}")
    public Iterable<ArtistModel> findArtistsByNameStartingWith(@PathVariable String name) {
        return artistRepository.findByNameStartsWith(name);
    }


}
