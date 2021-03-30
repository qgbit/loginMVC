package com.sankuai.Model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AccountManager {

    private JdbcTemplate jdbcTemplate;

    public AccountManager() {
        ApplicationContext apl = new AnnotationConfigApplicationContext(SystemConfiguration.class);
        DataSource dt = apl.getBean(DataSource.class);
        setJdbcTemplate(new JdbcTemplate(dt));
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean searchAccount(loginInfo userInfo){
        try{
            registerInfo info = jdbcTemplate.queryForObject("select * from account where username = ? and password = ?",
                     new registerMapper(),userInfo.getUsername(),userInfo.getPassword());
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }

    }

    public boolean isValidPara(registerInfo info){
        if(info.getUsername().equals("") ||
        info.getPassword().equals("") ||
        info.getPhonenumber().equals("")){
            return false;
        }else if(usernameExists(info.getUsername()) ||
                phonenumberExists(info.getPhonenumber())){
            return false;
        }else{
            return true;
        }
    }

    public boolean usernameExists(String username){
        try{
            registerInfo info = jdbcTemplate.queryForObject("select * from account where username = ?",
                    new registerMapper(),username);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    public boolean phonenumberExists(String phonenumber){
        try{
            registerInfo info = jdbcTemplate.queryForObject("select * from account where phonenumber = ?",
                    new registerMapper(),phonenumber);
            return true;
        }catch (IncorrectResultSizeDataAccessException e){
            return false;
        }
    }

    public void addNewAccount(registerInfo userInfo){
        jdbcTemplate.update("insert into account(username,password,phonenumber) values(?,?,?)",
                userInfo.getUsername(),userInfo.getPassword(),userInfo.getPhonenumber());
    }

}
