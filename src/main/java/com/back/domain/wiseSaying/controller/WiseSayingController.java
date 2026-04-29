package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        int id = ++lastId;

        wiseSayings.add(new WiseSaying(id, content, author));

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void actionList() {
        System.out.print("""
                번호 / 작가 / 명언
                ----------------------
                """);

        List<WiseSaying> wiseSayingForPrint = findForList();

        for (WiseSaying w : wiseSayingForPrint) {
            System.out.printf("%d / %s / %s\n", w.getId(), w.getAuthor(), w.getContent());
        }
    }

    // 내부 함수
    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }
}
