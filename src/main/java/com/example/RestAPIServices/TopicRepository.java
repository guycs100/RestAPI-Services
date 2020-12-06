package com.example.RestAPIServices;

import org.springframework.data.repository.CrudRepository;
import com.example.RestAPIServices.Topic;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}