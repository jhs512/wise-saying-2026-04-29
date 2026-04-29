package com.back.domain.wiseSaying.controller;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();
    }
}
