package com.back.domain.wiseSaying.controller;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private int lastId;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        lastId = 0;
    }

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        int id = ++lastId;

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }
}
