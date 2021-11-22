package com.study;

import com.study.domain.Inventor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fjding
 * @date 2021/10/29
 */
public class SimpleTest {
    public static void main(String[] args) {

        //simpleTest();
        //context();
        //config();
        compilation();;

        // SPEL配置
        //SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        //parser = new SpelExpressionParser(config);
        //Demo demo = new Demo();
        //System.out.println(parser.parseExpression("list[2]").getValue(demo));
    }

    /**
     * 简单示例
     */
    public static void simpleTest() {
        ExpressionParser parser = new SpelExpressionParser();
        // 表达字符串，注意"'"号
        Expression expression = parser.parseExpression("'hello world'");
        System.out.println(expression.getValue());
        // 调用方法
        expression = parser.parseExpression("'abc'.concat('ef')");
        System.out.println(expression.getValue());
        // 调用属性
        expression = parser.parseExpression("'abc'.bytes");
        System.out.println(Arrays.toString(expression.getValue(Byte[].class)));
        // 嵌套属性
        expression = parser.parseExpression("'abc'.bytes.length");
        System.out.println(expression.getValue());
        // 构造方法
        expression = parser.parseExpression("new com.study.domain.Inventor()");
        System.out.println(expression.getValue());

        // 针对根对象
        Inventor inventor = new Inventor();
        inventor.setName("make");
        expression = parser.parseExpression("name");
        System.out.println(expression.getValue(inventor));
        expression = parser.parseExpression("name == 'make'");
        System.out.println(expression.getValue(inventor, Boolean.class));
    }

    /**
     * 上下文和类型转换
     * SimpleEvaluationContext 一个子集的实现，对很多功功能有限制，基本的使用够用
     * StandardEvaluationContext 完整功能实现，允许设置一个默认Root对象，前者的默认构造是没有Root对象的
     */
    public static void context() {
        // 不支持默认根对象，有构造器可以使用
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Simple simple = new Simple();
        simple.list.add(true);

        ExpressionParser parser = new SpelExpressionParser();
        // 这里是字符串，但是转换器会帮助转换为Boolean类型
        Expression expression = parser.parseExpression("list[0]");
        // todo 没搞明白这里上下文有啥用。。。
        expression.setValue(context, simple, "false");

        System.out.println(simple.list.get(0));
    }

    /**
     * 解析时的配置
     */
    public static void config(){
        Demo demo = new Demo();
        // collection活array允许空引用和自动增长
        SpelParserConfiguration configuration = new SpelParserConfiguration(true,true);
        ExpressionParser parser = new SpelExpressionParser(configuration);
        Expression expression = parser.parseExpression("list[2]");
        Object value = expression.getValue(demo);
        System.out.println(value);
        System.out.println(demo.list);
    }

    /**
     * 编译模式
     */
    public static void compilation(){
        SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,SimpleTest.class.getClassLoader());
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        Expression expression = parser.parseExpression("name");
        Simple simple = new Simple();
        Object value = expression.getValue(simple);
        System.out.println(value);
    }

    static class Simple {
        public List<Boolean> list = new ArrayList<>();
        public String name;
    }

    static class Demo {
        public List<String> list;
        public String name;
    }
}
