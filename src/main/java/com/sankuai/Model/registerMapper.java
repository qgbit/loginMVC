package com.sankuai.Model;

import com.sankuai.Model.registerInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class registerMapper implements RowMapper<registerInfo> {
    public registerInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        registerInfo info = new registerInfo();
        info.setUsername(rs.getString("username"));
        info.setPassword(rs.getString("password"));
        info.setPhonenumber(rs.getString("phonenumber"));
        return info;
    }
}
