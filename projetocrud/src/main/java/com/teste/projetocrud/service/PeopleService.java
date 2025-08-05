package com.teste.projetocrud.service;


import com.teste.projetocrud.dto.PeopleDTO;
import com.teste.projetocrud.model.PeopleModel;
import com.teste.projetocrud.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    @Transactional
    public PeopleModel save(PeopleModel peopleModel) {



        return peopleRepository.save(peopleModel);

    }

    public Page<PeopleModel> findAll(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    public Optional<PeopleModel> findByIdPeople(Long id) {
        return peopleRepository.findById(id);
    }

    @Transactional
    public void delete(PeopleModel peopleModel) {
        peopleRepository.delete(peopleModel);
    }


    @Transactional(readOnly = true)
    public List<PeopleDTO> findByName(String name) {
        List<PeopleModel> result = peopleRepository.findByName(name);
        return result.stream().map(x-> new PeopleDTO(x)).toList();
    }

    public List<PeopleDTO> findByAge(String age) {
        List<PeopleModel> result = peopleRepository.findByAge(age);
        return result.stream().map(x-> new PeopleDTO(x)).toList();
    }

    public List<PeopleDTO> findByCep(String cep) {
        List<PeopleModel> result = peopleRepository.findByCep(cep);
        return result.stream().map(x-> new PeopleDTO(x)).toList();
    }

    public String verifyScorePeople(Long id, int valorScore) {

        PeopleModel peopleModel = peopleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O user people not found"));

        if (valorScore == 0) {
            return "O score inicial é insuficiente valor final seria 200";
        } else if (valorScore == 201)
            return "O score inicial é inaceitavel valor final seria 500";
        else if (valorScore == 501)
            return "O score inicial é aceitavel valor final seria 700";

        else if (valorScore >= 701)
            return "O score inicial é recomendavel valor final seria 1000";
        return "O score informado nao esta cadastrado correto por gentileza verificar novamente";
    }


}
