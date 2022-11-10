package java38team3.ecommerce.controller;


package com.funtastic4.buymystuff.controller;


import java38team3.ecommerce.dto.ProducerDto;
import java38team3.ecommerce.services.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/producers")
public class ProducerController {


        private final ProducerService producerService;

        public ProducerController(ProducerService producerService) {
            this.producerService = producerService;
        }

        //    @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("")
        public ResponseEntity<ProducerDto> addProducer(@RequestBody ProducerDto producerDto) {
            ProducerDto newProducerDto = producerService.createProducer(producerDto);
            return new ResponseEntity<>(newProducerDto, HttpStatus.CREATED);
        }

        @GetMapping(value = "", produces = "application/json")
        public ResponseEntity<List<ProducerDto>> getAllProducers() {
            List<ProducerDto> producerDtoList = producerService.findAllProducers();
//        return new ResponseEntity<>(producerDtoList, HttpStatus.OK);
            return ResponseEntity.ok(producerDtoList);
        }

        @GetMapping("/{producerID}")
        public ProducerDto getAllProducers(@PathVariable("producerID") Long producerId) {
            return producerService.findProducerById(producerId);
        }

        @PutMapping("/{producerID}")
        public ProducerDto getAllProducers(@PathVariable("producerID") Long producerId, @RequestBody ProducerDto producerDto) {
            return producerService.updateProducer(producerId, producerDto);
        }

        @DeleteMapping("/{producerID}")
        public void deleteProducer(@PathVariable("producerID") Long producerId) {
            producerService.deleteProducer(producerId);
        }

        @ExceptionHandler(value = EntityNotFoundException.class)
        public String handleExceptions(EntityNotFoundException exception) {
            log.error(exception.getMessage(), exception);
            return exception.getMessage();
        }
    }

}
