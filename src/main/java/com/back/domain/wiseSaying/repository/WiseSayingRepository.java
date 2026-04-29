package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        lastId = 0;
    }

    public void save(WiseSaying wiseSaying) {
        boolean isNew = wiseSaying.getId() == 0;

        if (isNew) {
            wiseSaying.setId(++lastId);

            wiseSayings.add(wiseSaying);
        }
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }
}
