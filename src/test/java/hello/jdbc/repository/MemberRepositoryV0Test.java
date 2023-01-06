package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repo = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        // save
        Member member = new Member("memberV0", 10000);
        repo.save(member);

        // findById
        Member foundMember = repo.findById(member.getMemberId());
        log.info("foundMember={}", foundMember);
        Assertions.assertThat(foundMember).isEqualTo(member);
    }
}