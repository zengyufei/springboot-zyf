import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zyf.springboot.enums.LevelType;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;

public class Demo {

    private enum TestDemo {
        FIRST(0, "第一"),
        SECOND(1, "第二");

        int index;
        String mark;

        TestDemo(int index, String mark) {
            this.index = index;
            this.mark = mark;
        }
    }

    @Test
    public void test1() {
        Integer a = 1;
        Integer b = 0;
        Integer c = null;
        Integer d = 1;
        Integer e = 0;
        String f = "";

        Console.log(ObjectUtil.equal(a, b));
        Console.log(ObjectUtil.equal(a, c));
        Console.log(ObjectUtil.equal(a, d) + "= ture");
        Console.log(ObjectUtil.equal(a, e));

        Console.log(ObjectUtil.equal(b, c));
        Console.log(ObjectUtil.equal(b, d));
        Console.log(ObjectUtil.equal(b, e) + "= ture");

        Console.log(ObjectUtil.equal(c, d));
        Console.log(ObjectUtil.equal(c, e));

        Console.log(ObjectUtil.equal(d, e));

        Console.log(ObjectUtil.equal(TestDemo.FIRST, TestDemo.FIRST));
        Console.log(ObjectUtil.equal(TestDemo.FIRST, TestDemo.SECOND));

        Console.log(Convert.toInt(c, 3));
        boolean value = StrUtil.hasBlank(f);
        Console.log(Convert.toInt(value, null) == null);

    }


    @Test
    public void test2() {
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteDateUseDateFormat.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.PrettyFormat.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullNumberAsZero.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteMapNullValue.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullBooleanAsFalse.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullListAsEmpty.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteBigDecimalAsPlain.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullStringAsEmpty.getMask();
        JSONObject.DEFAULT_GENERATE_FEATURE |= SerializerFeature.config(JSONObject.DEFAULT_GENERATE_FEATURE, SerializerFeature.WriteEnumUsingName, false);

        Console.log(JSONObject.toJSONString(new DemoEnum(LevelType.TWO)));
        Console.log(JSONObject.parseObject("{levelType: 2}", DemoEnum.class).getLevelType());
    }


    public static class DemoEnum {
        LevelType levelType;
        @JSONField(serialize = false)
        String levelTypeName;

        public DemoEnum(LevelType levelType) {
            this.levelType = levelType;
        }

        public LevelType getLevelType() {
            return this.levelType;
        }

        public void setLevelType(LevelType levelType) {
            this.levelType = levelType;
        }

        public String getLevelTypeName() {
            return this.levelTypeName;
        }

        public void setLevelTypeName(String levelTypeName) {
            this.levelTypeName = levelTypeName;
        }
    }

    @Test
    public void testDate() {
        long l = DateUtil.betweenDay(new Date(), new Date(), true);
        System.out.println(l);
    }

    @Test
    public void testLinkHashSet() {
        // 创建集合对象
        LinkedHashSet<String> hs = new LinkedHashSet<String>();
        // 创建并添加元素
        hs.add(null);
        // 遍历
        for (String s : hs) {
            System.out.println(s);
        }
    }

    @Test
    public void testTreeSet() {
        // 创建集合对象
        TreeSet<String> hs = new TreeSet<>();
        // 创建并添加元素
        hs.add(null);
        // 遍历
        for (String s : hs) {
            System.out.println(s);
        }
    }

    @Test
    public void testCreateMap() {
        Map<Object, Object> map = CollUtil.toMap(new String[]{"1", "2"});
        for (Map.Entry<Object, Object> objectObjectEntry : map.entrySet()) {
            Object key = objectObjectEntry.getKey();
            Object value = objectObjectEntry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    @Test
    public void testCreateMapArray() {
        Map<Object, Object> map = CollUtil.toMap(new String[][]{{"1", "2"}, {"3", "4"}});
        for (Map.Entry<Object, Object> objectObjectEntry : map.entrySet()) {
            Object key = objectObjectEntry.getKey();
            Object value = objectObjectEntry.getValue();
            System.out.println(key + "=" + value);
        }
    }

}
