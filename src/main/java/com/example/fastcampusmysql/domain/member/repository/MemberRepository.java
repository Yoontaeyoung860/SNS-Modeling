package com.example.fastcampusmysql.domain.member.repository;

import com.example.fastcampusmysql.domain.member.entity.Member;
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static final private String TABLE = "member";

    public Optional<Member> findById(Long id) {
       /*
       select *
       from Member
       where id = : id
       */
      //  StringBuffer sb = new StringBuffer();
      //  sb.append("SELECT * ");
      //  sb.append("FROM %s ");
      //  sb.append("Where id = : id ");
        var sql =  String.format("SELECT * FROM %s WHERE id = :id", TABLE);
        var param = new MapSqlParameterSource()
                .addValue("id", id);

        RowMapper<Member> rowMapper = (ResultSet resultSet, int rowNum) -> Member
                .builder()
                .id(resultSet.getLong("id"))
                .email(resultSet.getString("email"))
                .nickname(resultSet.getString("nickname"))
                .birthday(resultSet.getObject("birthday", LocalDate.class))
                .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
                .build();
       var member = namedParameterJdbcTemplate.queryForObject(sql, param, rowMapper);
    return Optional.ofNullable(member);
    }

=======
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
>>>>>>> 4cc0908d1841e642e3036904c0f5fe2859a3e020

    public Member save(Member member) {
        /*
        member id를 보고 갱신 또는 삽입을 정함.
        반환값은 id를 담아서 반환한다.
         */
<<<<<<< HEAD
        if (member.getId() == null) {
            return insert(member);
        }
     return update(member);
    }

    private Member insert(Member member) {
        //Insert 후에 아이디를 담아 오는 것을  굉장히 쉽게 구현 가능.
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName("Member") //테이블 이름 지정 가능
                .usingGeneratedKeyColumns("id"); //키를 어떤 컬럼으로 가져올 것 인지.

        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return Member
                .builder()
                .id(id)
                .email(member.getEmail())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .createdAt(member.getCreatedAt())
                .build();

    }

    private Member update(Member member){
        // TODO: implemented
        return member;

=======
     return Member.builder().build();
>>>>>>> 4cc0908d1841e642e3036904c0f5fe2859a3e020
    }
}
