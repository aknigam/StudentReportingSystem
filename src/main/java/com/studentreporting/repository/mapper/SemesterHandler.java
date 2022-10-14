package com.studentreporting.repository.mapper;

import java.lang.Integer;

import com.studentreporting.entities.Semester;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SemesterHandler implements TypeHandler<Semester> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Semester parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setInt(i, parameter.getId());
  }

  @Override
  public Semester getResult(ResultSet rs, String columnName) throws SQLException {
    return Semester.fromId(rs.getInt(columnName));
  }

  @Override
  public Semester getResult(ResultSet rs, int columnIndex) throws SQLException {
    return Semester.fromId(rs.getInt(columnIndex));
  }

  @Override
  public Semester getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}
