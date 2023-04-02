package com.example.sns.domain.member.repository;

import com.example.sns.domain.member.entity.Member;
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

//DAO객체라고 봐도 무방
@RequiredArgsConstructor
@Repository
public class MemberRepository {
    final private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //Member의 아이디를 보고 갱신 또는 삽입을 정할 것

    static final private String TABLE = "member";

    public Optional<Member> findById(Long id){

      var sql = String.format("SELECT * FROM %s WHERE id = :id", TABLE);
      var param = new MapSqlParameterSource()
              .addValue("id",id);

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




     public  Member save(Member member) {
      /*


       */
     if(member.getId() == null) {
         return insert(member);
     }
         return  update(member);
     }
     //두 가지의 private 함수가 필요
     private  Member insert(Member member) {
     //JDBCTemplate을 이용하자.
         //
         // JPA는 아이디값이 없는 member를 받아, insert를 하면 id값을 담아서 반환 해준다.
         //근데 SimpleJdbcInsert는 아주 쉽게 insert 시, id값을 담아서 준다.
         SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
         .withTableName("Member") //테이블 넣는 곳
         .usingGeneratedKeyColumns("id"); //키를 어떤 컬럼으로 가져올 것인가
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

     private Member update(Member member) {
         // TODO: implemented
    return member;
     }
}


