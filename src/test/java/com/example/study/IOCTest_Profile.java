package com.example.study;

import com.example.study.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;

public class IOCTest_Profile {

    //1��ʹ�������ж�̬����: �����������λ�ü��� -Dspring.profiles.active=test
    //2������ķ�ʽ����ĳ�ֻ�����
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //1������һ��applicationContext
        //2��������Ҫ����Ļ���
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3��ע����������
        applicationContext.register(MainConfigOfProfile.class);
        //4������ˢ������
        applicationContext.refresh();


        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }
        applicationContext.close();
    }

    @Test
    public void test02() {
        BigDecimal decimal1 = new BigDecimal(String.valueOf(0.1));
        BigDecimal decimal2 = new BigDecimal(String.valueOf(0.2));
        System.out.println(decimal1.add(decimal2));
    }
}