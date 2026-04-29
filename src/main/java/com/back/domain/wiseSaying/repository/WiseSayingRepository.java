package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        lastId = 0;
    }

    public void save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);

            wiseSayings.add(wiseSaying);
        }
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings
                .stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }
}
