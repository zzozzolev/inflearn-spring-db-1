package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repo = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        // save
        Member member = new Member("memberV5", 10000);
        repo.save(member);

        // findById
        Member foundMember = repo.findById(member.getMemberId());
        log.info("foundMember={}", foundMember);
        assertThat(foundMember).isEqualTo(member);

        // update: money: 10000 -> 20000
        repo.update(member.getMemberId(), 20000);
        Member updatedMember = repo.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        // delete
        repo.delete(member.getMemberId());
        assertThatThrownBy(() -> repo.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}