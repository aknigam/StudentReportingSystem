package com.studentreporting.repository.mapper;

import java.lang.Integer;

import com.studentreporting.entities.Subject;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectHandler implements TypeHandler<Subject> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Subject parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setInt(i, parameter.getId());
  }

  @Override
  public Subject getResult(ResultSet rs, String columnName) throws SQLException {
    return Subject.fromId(rs.getInt(columnName));
  }

  @Override
  public Subject getResult(ResultSet rs, int columnIndex) throws SQLException {
    return Subject.fromId(rs.getInt(columnIndex));
  }

  @Override
  public Subject getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}
