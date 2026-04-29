package com.back.domain.wiseSaying.controller;

import com.back.AppTestRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("등록")
    void t1() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                """);

        assertThat(out)
                .contains("명언 : ")
                .contains("작가 : ");
    }

    @Test
    @DisplayName("등록이 완료되면 `명언이 등록되었습니다.` 라는 메세지가 출력된다.")
    void t2() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                """);

        assertThat(out)
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록할때 마다 생성되는 명언번호가 증가")
    void t3() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                너 자신을 알라.
                소크라테스
                """);

        assertThat(out)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    void t4() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                너 자신을 알라.
                소크라테스
                목록
                """);

        assertThat(out)
                .contains("""
                        번호 / 작가 / 명언
                        ----------------------
                        2 / 소크라테스 / 너 자신을 알라.
                        1 / 이순신 / 나의 죽음을 적들에게 알리지 말라.
                        """);
    }

    @Test
    @DisplayName("삭제")
    void t5() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                너 자신을 알라.
                소크라테스
                삭제?id=2
                목록
                """);

        assertThat(out)
                .contains("""
                        번호 / 작가 / 명언
                        ----------------------
                        1 / 이순신 / 나의 죽음을 적들에게 알리지 말라.
                        """);
    }

    @Test
    @DisplayName("삭제, 존재하지 않는 명언 삭제요청에 대한 처리")
    void t6() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                너 자신을 알라.
                소크라테스
                삭제?id=5
                """);

        assertThat(out)
                .contains("5번 명언은 존재하지 않습니다.");
    }

    @Test
    @DisplayName("수정")
    void t7() {
        final String out = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라.
                이순신
                등록
                너 자신을 알라.
                소크라테스
                수정?id=1
                나의 죽음을 적들이 모르게 해라.
                충무공
                목록
                """);

        assertThat(out)
                .doesNotContain("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라.")
                .contains("1 / 충무공 / 나의 죽음을 적들이 모르게 해라.");
    }
}
