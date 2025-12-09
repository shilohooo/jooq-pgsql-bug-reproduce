// package com.github.shiloh.jooq.codegen;
//
// import com.github.shiloh.base.dao.impl.BaseDaoImpl;
// import lombok.extern.slf4j.Slf4j;
// import org.jooq.codegen.DefaultGeneratorStrategy;
// import org.jooq.meta.Definition;
// import org.jooq.meta.TableDefinition;
//
// /**
//  * 自定义 JOOQ 代码生成策略
//  *
//  * @author shiloh
//  */
// @Slf4j
// public class CustomJooqCodeGeneratorStrategy extends DefaultGeneratorStrategy {
//     @Override
//     public String getJavaClassExtends(Definition definition, Mode mode) {
//         log.info("com.github.shiloh.jooq.codegen.CustomJooqGenerator.getJavaClassExtends: {}, {}", definition, mode);
//         if (definition instanceof TableDefinition && Mode.DAO.equals(mode)) {
//             return BaseDaoImpl.class.getName();
//         }
//
//         return super.getJavaClassExtends(definition, mode);
//     }
//
//     @Override
//     public String getJavaClassName(Definition definition, Mode mode) {
//         final String javaClassName = super.getJavaClassName(definition, mode);
//         log.info("com.github.shiloh.jooq.codegen.CustomJooqGenerator.getJavaClassName: {}, {}, {}", definition.getClass().getName(), mode, javaClassName);
//         final String javaClassNameWithoutPrefix = javaClassName.replace("T", "");
//         return switch (mode) {
//             case DEFAULT -> String.format("%sTable", javaClassNameWithoutPrefix);
//             case POJO -> String.format("%sPojo", javaClassNameWithoutPrefix);
//             default -> javaClassNameWithoutPrefix;
//         };
//     }
// }
