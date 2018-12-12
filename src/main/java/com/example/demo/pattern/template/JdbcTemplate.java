package com.example.demo.pattern.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement pstmt, Object[] values) throws SQLException {
        for(int i = 0; i < values.length; i ++){
            pstmt.setObject(i, values[i]);
        }
        return pstmt.executeQuery();
    }

    private void closeStatement(Statement stmt) throws SQLException {
        stmt.close();
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private  void closeConnection(Connection conn){
        //通常把它放到连接池回收
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper rowMapper) throws Exception {

        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while(rs.next()){
            result.add(rowMapper.mapRow(rs, rowNum ++));
        }
        return result;

    }

    public List<?> executeQuery(String  sql, RowMapper<?> rowMapper,Object[] values){
        //1, 获取连接
        try {
            Connection conn = this.getConnection();
            //2，创建语句集
            PreparedStatement pstmt = this.createPrepareStatement(conn,sql);
            //3，执行语句集，并且获得结果
            ResultSet rs = this.executeQuery(pstmt, values);

            //4，解析语句集
            List<?> result = this.parseResultSet(rs, rowMapper);
            //5，关闭结果集
            this.closeResultSet(rs);
            //6，关闭语句集
            this.closeStatement(pstmt);
            //7，关闭连接
            this.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

//    public abstract Object processResult(ResultSet rs, int rowNum) throws SQLException;
}
