package cn.edu.xmut.personnelmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages={"cn.edu.xmut.personnelmanage"})
@MapperScan("cn.edu.xmut.personnelmanage.dao")
@ServletComponentScan(value = "cn.edu.xmut.personnelmanage.controller")
public class PersonnelManageStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelManageStarterApplication.class, args);
    }

}
