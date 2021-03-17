package cn.edu.xmut.personnelmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.xmut.personnelmanage.dao")
public class PersonnelManageStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelManageStarterApplication.class, args);
    }

}
