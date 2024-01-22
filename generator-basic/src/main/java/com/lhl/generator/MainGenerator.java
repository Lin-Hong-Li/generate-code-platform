package com.lhl.generator;

import com.lhl.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // 静态文件生成
        // 获取项目根目录
        String projectPath = System.getProperty("user.dir");
        // 输入路径（输入拷贝的文件）
        String inputPath = projectPath + File.separator + "generate-code-platform-demo" + File.separator + "acm-template";
        // 输出位置
        String outputPath = projectPath;
        StaticGenerator.copyFileByRecursive(inputPath, outputPath);

        // 动态文件生成
        String dynamicInputPath = projectPath + File.separator + "generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/lhl/acm/MainTemplate.java";
        // 数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("lhl");
        mainTemplateConfig.setOutputText("求和结果为：");
        mainTemplateConfig.setLoop(true);

        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
