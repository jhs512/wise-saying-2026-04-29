package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        wiseSayingService = new WiseSayingService();
    }

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    public void actionList() {
        System.out.print("""
                번호 / 작가 / 명언
                ----------------------
                """);

        List<WiseSaying> wiseSayingForPrint = wiseSayingService.findForList();

        for (WiseSaying w : wiseSayingForPrint) {
            System.out.printf("%d / %s / %s\n", w.getId(), w.getAuthor(), w.getContent());
        }
    }
}
