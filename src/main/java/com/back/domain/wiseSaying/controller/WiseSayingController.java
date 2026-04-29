package com.back.domain.wiseSaying.controller;

import com.back.Rq;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
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

    public void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id(숫자)를 입력해주세요.");
            return;
        }

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        WiseSaying wiseSaying = opWiseSaying.get();

        wiseSayingService.delete(wiseSaying);
    }
}
