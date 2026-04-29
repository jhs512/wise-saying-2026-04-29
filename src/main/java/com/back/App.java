package com.back;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String content = scanner.nextLine().trim();

                    System.out.print("작가 : ");
                    String author = scanner.nextLine().trim();
                }
                case "종료" -> {
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
                }
            }
        }
    }
}
