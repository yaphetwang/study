package com.example.study.someknowledges.importbeandefinitionregistrar;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;

/**
 * @author wb-wyf372433
 * @date 2019/7/4 10:23
 * @description 实现 ImportBeanDefinitionRegistrar接口, 可以让我们手动注册bean到容器
 * 这里 我们使用这个接口完成一个假的MapperScan注解的 自定义
 */
public class ConfigMapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        try {
            AnnotationAttributes annoAttrs =
                    AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ConfigMapperScanner.class.getName()));
            //获取需要扫描的包路径名
            String packageValue = annoAttrs.getString("value");
            String pathValue = packageValue.replace(".", "/");
            File[] files = resourceLoader.getResource(pathValue).getFile().listFiles();
            for (File file : files) {
                String name = file.getName().replace(".class", "");
                //使用类的全类名加载类
                Class<?> aClass = Class.forName(packageValue + "." + name);
                if (aClass.isInterface() && !aClass.isAnnotation()) {
                    //此处使用BeanDefinitionBuilder,动态去注册Bean
                    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
                    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
                    beanDefinition.setBeanClass(ConfigFactoryBean.class);
                    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(packageValue + "." + name);
                    registry.registerBeanDefinition(name, beanDefinition);
                }
            }

        } catch (Exception ex) {
        }
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
