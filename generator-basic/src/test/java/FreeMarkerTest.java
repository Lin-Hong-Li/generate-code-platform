import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 设置模板文件的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        // 设置字符集
        configuration.setDefaultEncoding("utf-8");

        Template template = configuration.getTemplate("myweb.html.ftl");

        // 数据模型
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("currentYear", 2024);

        List<String> menuItems = new ArrayList<>();
        menuItems.add("item1");
        menuItems.add("item2");
        menuItems.add("item3");
        dataModel.put("menuItems", menuItems);

        FileWriter output = new FileWriter("myweb.html");
        template.process(dataModel, output);
        output.close();
    }
}
