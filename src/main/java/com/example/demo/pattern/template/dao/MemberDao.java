package com.example.demo.pattern.template.dao;

import com.example.demo.pattern.template.JdbcTemplate;
import com.example.demo.pattern.template.RowMapper;
import com.example.demo.pattern.template.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);


    public List<?> query(){
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>(){
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member m = new Member();
                m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password"));
                m.setAddr(rs.getString("addr"));
                m.setAge(rs.getInt("age"));
                return m;
            }
        },null);
    }

//    @Override
//    public Object processResult(ResultSet rs,int rowNum) throws SQLException {
//            Member m = new Member();
//            m.setUsername(rs.getString("username"));
//            m.setPassword(rs.getString("password"));
//            m.setAddr(rs.getString("addr"));
//            m.setAge(rs.getInt("age"));
//        return null;
//    }
}
