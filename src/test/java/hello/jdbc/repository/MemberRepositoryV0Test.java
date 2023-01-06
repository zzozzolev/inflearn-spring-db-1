package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class MemberRepositoryV0Test {

    MemberRepositoryV0 repo = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberV0", 10000);
        repo.save(member);
    }
}