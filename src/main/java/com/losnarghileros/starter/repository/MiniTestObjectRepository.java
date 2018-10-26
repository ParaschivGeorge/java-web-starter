package com.losnarghileros.starter.repository;

import com.losnarghileros.starter.entities.MiniTestObject;
import com.losnarghileros.starter.entities.TestObject;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api(tags = "MiniTestObject Entity")
@RepositoryRestResource(collectionResourceRel = "miniTestObject", path = "mini-test-object")
public interface MiniTestObjectRepository extends CrudRepository<MiniTestObject, Long> {
    List<TestObject> findByName(@Param("name") String name);
    List<TestObject> findByTestObjectId(@Param("test-object-id") Long id);
    List<TestObject> findByTestObjectName(@Param("test-object-name") String name);
}
