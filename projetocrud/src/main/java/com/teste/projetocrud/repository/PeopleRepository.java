package com.teste.projetocrud.repository;

import com.teste.projetocrud.model.PeopleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeopleRepository extends JpaRepository<PeopleModel, Long> {

    List<PeopleModel> findByName(String name);

    List<PeopleModel> findByAge(String age);

    List<PeopleModel> findByCep(String cep);
}
