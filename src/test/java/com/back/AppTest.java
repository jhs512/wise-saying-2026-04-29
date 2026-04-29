package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("`== 명언 앱 ==` 출력")
    void t1() {
        final String out = AppTestRunner.run("");

        assertThat(out)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("`명령) ` 출력")
    void t2() {
        final String out = AppTestRunner.run("");

        assertThat(out)
                .contains("명령) ");
    }

    @Test
    @DisplayName("종료")
    void t3() {
        final String out = AppTestRunner.run("");

        assertThat(out)
                .contains("프로그램이 종료되었습니다.");
    }
}
