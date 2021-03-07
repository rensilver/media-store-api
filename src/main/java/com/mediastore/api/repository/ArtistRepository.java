package com.mediastore.api.repository;

import com.mediastore.api.model.ArtistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<ArtistModel, Integer> {

   public Iterable<ArtistModel> findByNameStartsWith(String name);
}
