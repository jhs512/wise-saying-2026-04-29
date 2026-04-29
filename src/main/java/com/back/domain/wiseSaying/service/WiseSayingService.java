package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingService() {
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying write(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }
}
