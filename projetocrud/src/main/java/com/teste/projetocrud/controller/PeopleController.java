package com.teste.projetocrud.controller;

import com.teste.projetocrud.dto.PeopleDTO;
import com.teste.projetocrud.model.PeopleModel;
import com.teste.projetocrud.service.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/peoples")
@Tag(name = "Produtos", description = "API Peoples")
public class PeopleController {

    @Autowired
    PeopleService peopleService;


    @Operation(summary = "Cadastrar peoples", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping
    public ResponseEntity<Object> savePeople(@RequestBody @Valid PeopleDTO peopleDTO) {

        var peopleModel = new PeopleModel();
        BeanUtils.copyProperties(peopleDTO, peopleModel );


        return ResponseEntity.status(HttpStatus.CREATED).body(peopleService.save(peopleModel));

    }


    @GetMapping
    @Operation(summary = "Listar peoples", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Page<PeopleModel>> getAllPeople(@PageableDefault(page = 0, size = 10, sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(peopleService.findAll(pageable));
    }


    @Operation(summary = "Delete peoples ", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deletePeople(@PathVariable(value="id")Long id){

        Optional<PeopleModel> peopleModelOptional = peopleService.findByIdPeople(id);

        if (!peopleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O nome da pessoa deste id nao foi encontrado");

        }
        peopleService.delete(peopleModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("O nome da pessoa deste id foi deletado com sucesso");
    }


    @Operation(summary = "Update peoples ", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{id}")
    public ResponseEntity<Object>updatePeople(@PathVariable( value="id" ) Long id,
                                              @RequestBody @Valid PeopleDTO peopleDto){

        Optional<PeopleModel> peopleModelOptional = peopleService.findByIdPeople(id);

        if (!peopleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O nome da pessoa deste id nao foi encontrado");

        }

        var peopleModel = peopleModelOptional.get();

        peopleModel.setName(peopleDto.getName());
        peopleModel.setAge(peopleDto.getAge());
        peopleModel.setCep(peopleDto.getCep());
        peopleModel.setNeighborhood(peopleDto.getNeighborhood());
        peopleModel.setCity(peopleDto.getCity());
        peopleModel.setState(peopleDto.getState());
        peopleModel.setAddress(peopleDto.getAddress());
        peopleModel.setPhone(peopleDto.getPhone());
        peopleModel.setScore(peopleDto.getScore());

        return ResponseEntity.status(HttpStatus.OK).body(peopleService.save(peopleModel));
    }

    @Operation(summary = "Find people name Get", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/find-people-name")
    public ResponseEntity<List<PeopleDTO>> findByName(
            @RequestParam(name = "name", defaultValue = "") String name){
        List<PeopleDTO> result = peopleService.findByName(name);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Find people age Get", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/find-people-age")
    public ResponseEntity<List<PeopleDTO>> findByAge(
            @RequestParam(name = "age", defaultValue = "") String age){
        List<PeopleDTO> result = peopleService.findByAge(age);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Find people cep Get", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/find-people-cep")
    public ResponseEntity<List<PeopleDTO>> findBCep(
            @RequestParam(name = "cep", defaultValue = "") String cep){
        List<PeopleDTO> result = peopleService.findByCep(cep);
        return ResponseEntity.ok(result);
    }



    @Operation(summary = "Find people score ", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/people/{id}")
    public ResponseEntity<Object>existsByScorePeople(@PathVariable( value="id" ) Long id,
                                              @RequestParam int valorScore) {

        String result = peopleService.verifyScorePeople(id, valorScore);
        return ResponseEntity.ok(result);

    }



}
