package com.example.study.someknowledges;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wb-wyf372433
 * @date 2019/7/3 11:19
 * @description
 * 此方式在SpringBoot大量使用
 *
 */
public class AspectSelector implements ImportSelector {

    /**
     * 返回需要注册的bean 的全类名数组, 容器即会创建这些bean
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.example.study.someknowledges.ServiceImpl"};
    }
}
