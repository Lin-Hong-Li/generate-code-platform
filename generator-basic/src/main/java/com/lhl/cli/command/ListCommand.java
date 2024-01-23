package com.lhl.cli.command;

import cn.hutool.core.io.FileUtil;
import lombok.Data;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@Data
@CommandLine.Command(name = "list", description = "复制的文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
//        String projectPath = System.getProperty("user.dir");
        // 输入路径（输入拷贝的文件）
//        String inputPath = projectPath + File.separator + "generate-code-platform-demo" + File.separator + "acm-template";
        String inputPath = "D:\\project\\generate-code-platform\\generate-code-platform-demo\\acm-template";
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
