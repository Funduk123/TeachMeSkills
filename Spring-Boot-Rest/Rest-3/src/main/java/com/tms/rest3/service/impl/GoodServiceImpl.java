package com.tms.rest3.service.impl;

import com.tms.rest3.exc.GoodNotFoundException;
import com.tms.rest3.model.GoodEntity;
import com.tms.rest3.repositories.GoodRepository;
import com.tms.rest3.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {

    private final GoodRepository repository;

    @PostConstruct
    public void init() {
        var good1 = GoodEntity.builder()
                .id(UUID.randomUUID())
                .name("book")
                .build();

        var good2 = GoodEntity.builder()
                .id(UUID.randomUUID())
                .name("pen")
                .build();

        repository.save(good1);
        repository.save(good2);
    }

    @Override
    public GoodEntity getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new GoodNotFoundException("Good with name " + name + " not found!"));
    }

}
