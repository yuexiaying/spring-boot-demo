package com.study;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.study.domain.Inventor;
import com.study.domain.PlaceOfBirth;
import com.study.domain.Society;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * SpEL参考
 */
public class Reference {

    static ExpressionParser parser = new SpelExpressionParser();

    public static void main(String[] args) throws NoSuchMethodException {
        //literal();
        //multiple();
        //inLineListAndMap();
        //constructionArray();
        //methods();
        //operators();
        //types();
        //constructors();
        //variables();
        //functions();
        //beanReferences();
        //ternaryOperator();
        //safeOperator();
        //collectionSelection();
        //collectionProjection();
        expressionTemplate();
    }

    /**
     * 字面量
     */
    public static void literal() {
        ExpressionParser parser = new SpelExpressionParser();
        // 注意单引号的使用
        String str = parser.parseExpression("'my name is ''make'''").getValue(String.class);
        System.out.println(str);

        Double dou = parser.parseExpression("6.012").getValue(Double.class);
        System.out.println(dou);

        // 支持十六进制
        Integer i = parser.parseExpression("0x1A").getValue(Integer.class);
        System.out.println(i);

        Boolean b = parser.parseExpression("true").getValue(Boolean.class);
        System.out.println(b);

        Object obj = parser.parseExpression("null").getValue();
        System.out.println(obj);

    }

    /**
     * 各种类型
     */
    public static void multiple() {
        Inventor inventor = new Inventor();
        PlaceOfBirth placeOfBirth = new PlaceOfBirth();
        placeOfBirth.setCity("Beijing");
        Society society = new Society();

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(society).build();
        context.setVariable("placeOfBirth", placeOfBirth);
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(config);

        Integer year = parser.parseExpression("birthdate.year + 1900").getValue(inventor, Integer.class);
        System.out.println(year);

        // #placeOfBirth 表示引用上下文中的对象，如果是Root对象，可以省略 ‘#’
        String city = parser.parseExpression("#placeOfBirth.city").getValue(context, String.class);
        System.out.println(city);
        // Society是root对象，因此该对象中的属性不需要指定Bean名
        String advisors = parser.parseExpression("Advisors").getValue(context, String.class);
        System.out.println(advisors);

        String[] names = {"make", "jen"};
        // 解析 array
        String name = parser.parseExpression("[0]").getValue(names, String.class);
        System.out.println(name);

        School school = new School("shanghai", names);
        List<School> schools = Lists.newArrayList(school);
        // 解析List中对象的属性
        String address = parser.parseExpression("[0].address").getValue(schools, String.class);
        System.out.println(address);
        // 解析List中的Array
        name = parser.parseExpression("[0].names[1]").getValue(schools, String.class);
        System.out.println(name);

        // map的处理
        Map<String,PlaceOfBirth> map = new HashMap<>();
        map.put("key",placeOfBirth);
        parser.parseExpression("['key'].city").setValue(map,"guangzhou");
        city = parser.parseExpression("['key'].city").getValue(map,String.class);
        System.out.println(city);
    }

    /**
     * 内联List和Map
     */
    public static void inLineListAndMap(){
        ExpressionParser parser = new SpelExpressionParser();
        List list = parser.parseExpression("{1,2,3}").getValue(List.class);
        System.out.println(list);
        List listOfList = parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(List.class);
        System.out.println(listOfList);

        Map map = parser.parseExpression("{name:'make',age:18}").getValue(Map.class);
        System.out.println(map);
    }

    /**
     * 构造数组
     */
    public static void constructionArray(){
        ExpressionParser parser = new SpelExpressionParser();
        int[] ints = parser.parseExpression("new int[5]").getValue(int[].class);
        System.out.println(Arrays.toString(ints));
        ints = parser.parseExpression("new int[]{1,2,3}").getValue(ints.getClass());
        System.out.println(Arrays.toString(ints));
        int[][] intOfInt = parser.parseExpression("new int[5][5]").getValue(int[][].class);
        System.out.println(Arrays.toString(intOfInt));
    }

    /**
     * 方法
     */
    public static void methods(){
        ExpressionParser parser = new SpelExpressionParser();
        String value = parser.parseExpression("'abc'.substring(0,1)").getValue(String.class);
        System.out.println(value);

        ArrayList<String> list = Lists.newArrayList("a", "b");
        Boolean contains = parser.parseExpression("contains('a')").getValue(list,Boolean.class);
        System.out.println(contains);
    }

    /**
     * 运算符
     * 关系
     * 逻辑
     * 数学
     * 赋值
     */
    public static void operators(){
        ExpressionParser parser = new SpelExpressionParser();

        // 关系
        System.out.println(parser.parseExpression("2 < -5.0").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'a' < 'b'").getValue(Boolean.class));
        // 任何值都大于null
        System.out.println(parser.parseExpression("3 < null").getValue(Boolean.class));
        // 支持 instanceof ，注意格式
        System.out.println(parser.parseExpression("'x' instanceof T(Integer)").getValue(Boolean.class));
        // 支持正则
        System.out.println(parser.parseExpression("5 matches '^\\d$'").getValue(Boolean.class));
        // 支持纯字符运算
        System.out.println(parser.parseExpression("2 lt 5").getValue(Boolean.class));

        // 逻辑
        System.out.println(parser.parseExpression("true and false").getValue(Boolean.class));
        System.out.println(parser.parseExpression("true || false").getValue(Boolean.class));
        System.out.println(parser.parseExpression("not true").getValue(Boolean.class));

        // 数学
        System.out.println(parser.parseExpression("1 +2 ").getValue(Integer.class));
        System.out.println(parser.parseExpression("1 % 3").getValue(Integer.class));
        System.out.println(parser.parseExpression("1 - -2").getValue(Integer.class));
        System.out.println(parser.parseExpression("1 + 2 *3").getValue(Integer.class));

        // 赋值
        School school = new School();
        parser.parseExpression("address = 'beijing'").getValue(school,String.class);
        System.out.println(school.getAddress());

    }

    /**
     * Class
     */
    public static void types(){
        ExpressionParser parser = new SpelExpressionParser();
        Class aClass = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(aClass);
        aClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        System.out.println(aClass);

        //List<String> strings = Lists.newArrayList("a");
        //List<Integer> integers = Lists.newArrayList(1);
        //String str = parser.parseExpression("(T(String))[0]").getValue(strings, String.class);
        //System.out.println(str);
    }

    /**
     * 构造器
     */
    public static void constructors(){
        ExpressionParser parser = new SpelExpressionParser();
        School school = parser.parseExpression("new com.study.Reference.School('beijing')").getValue(School.class);
        System.out.println(school);
    }

    /**
     * 变量
     */
    public static void variables(){
        List<Integer> list = Lists.newArrayList(1, 3, 10, 17);
        Demo demo = new Demo();
        demo.setList(list);
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().withRootObject(demo).build();
        context.setVariable("newAddress","nanjing");
        ExpressionParser parser = new SpelExpressionParser();

        School school = new School("beijing");
        parser.parseExpression("address = #newAddress").getValue(context,school);
        System.out.println(school.getAddress());

        // #this 指向计算对象，#root指向Root对象，可以看到#this是会变化的
        list = parser.parseExpression("#root.list.?[#this > 10]").getValue(context,List.class);
        System.out.println(list);
        list = parser.parseExpression("#this.list.?[#this > 10]").getValue(context,List.class);
        System.out.println(list);

    }

    /**
     * 方法
     */
    public static void functions() throws NoSuchMethodException {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        ExpressionParser parser = new SpelExpressionParser();
        MyMath myMath = new MyMath();
        context.setVariable("myPrint",MyMath.class.getDeclaredMethod("print", String.class));
        Object value = parser.parseExpression("#myPrint('hello')").getValue(context);
        System.out.println(value);
        // 成员方法不能像静态方法那样使用
        value = parser.parseExpression("add('you')").getValue(myMath);
        System.out.println(value);
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
    }

    /**
     * 解析Bean
     */
    public static void beanReferences(){
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean("myName",MyFactoryBean.class);
        applicationContext.refresh();

        StandardEvaluationContext context = new StandardEvaluationContext();
        // 设置Bean解析器
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));
        ExpressionParser parser = new SpelExpressionParser();
        // 获得Bean
        String value = parser.parseExpression("@myName").getValue(context, String.class);
        System.out.println(value);
        // 获得FactoryBean
        FactoryBean factoryBean = parser.parseExpression("&myName").getValue(context, FactoryBean.class);
        System.out.println(factoryBean.getClass());
    }

    /**
     * 三元运算符
     */
    public static void ternaryOperator(){
        ExpressionParser parser = new SpelExpressionParser();
        String value = parser.parseExpression("false ? 'a': 'b'").getValue(String.class);
        System.out.println(value);
        // 短的运算符
        value = parser.parseExpression("address ?:'this is null'").getValue(new School(),String.class);
        System.out.println(value);
    }

    /**
     * 安全操作
     */
    public static void safeOperator(){
        Inventor inventor = new Inventor();
        // 打印null，不会抛出NPE
        String city = parser.parseExpression("placeOfBirth?.city").getValue(inventor, String.class);
        System.out.println(city);
    }

    /**
     * 集合条件选择
     */
    public static void collectionSelection(){
        List<Integer> list = Lists.newArrayList(1, 2, 5, 7);
        list = parser.parseExpression("#this.?[#this > 2]").getValue(list,List.class);
        System.out.println(list);
        // 返回符合条件的第一个元素
        list = parser.parseExpression("#this.^[#this > 2]").getValue(list,List.class);
        System.out.println(list);
        // 返回符合条件的最后一个元素
        list = parser.parseExpression("#this.$[#this > 2]").getValue(list,List.class);
        System.out.println(list);

        Map<Integer, String> map = Maps.toMap(list, k -> k + "key");
        map = parser.parseExpression("#this.?[key > 2]").getValue(map,Map.class);
        System.out.println(map);
        map = parser.parseExpression("#this.?[value=='5key']").getValue(map,Map.class);
        System.out.println(map);
    }

    /**
     * 集合投影
     * 有一组对象，可以获得这组对象中某个属性的集合，支持链式操作，可以不断向下延展
     */
    public static void collectionProjection(){
        PlaceOfBirth placeOfBirth1 = new PlaceOfBirth("beijing");
        PlaceOfBirth placeOfBirth2 = new PlaceOfBirth("qingdao");
        List<PlaceOfBirth> list = Lists.newArrayList(placeOfBirth1,placeOfBirth2);
        List<String> cityList = parser.parseExpression("#this.![city]").getValue(list,List.class);
        System.out.println(cityList);
    }

    /**
     * 自定义表达式模板
     */
    public static void expressionTemplate(){
        String str = parser.parseExpression("sum = #{3 + 4}",
                // 官方提供的模板，可以自定义
                ParserContext.TEMPLATE_EXPRESSION
        ).getValue(String.class);
        System.out.println(str);
    }
    @Data
    private static class School {

        public School() {
        }

        public School(String address) {
            this.address = address;
        }

        public School(String address, String[] names) {
            this.address = address;
            this.names = names;
        }

        private String address;

        private String[] names;

    }

    @Data
    private static class Demo {

        private List<Integer> list;
    }

    @Data
    private static class MyMath {

        public static void print(String value){
            System.out.println(value);
        }

        public String add(String value){
            return value + "add";
        }
    }

    private static class MyFactoryBean extends AbstractFactoryBean<String>{

        @Override
        public Class<?> getObjectType() {
            return String.class;
        }

        @Override
        protected String createInstance() throws Exception {
            return "jen";
        }
    }
}
