package com.lhl.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成
 */
public class StaticGenerator {

    public static void main(String[] args) {
        // 获取项目根目录
        String projectPath = System.getProperty("user.dir");
        // 输入路径（输入拷贝的文件）
        String inputPath = projectPath + File.separator + "generate-code-platform-demo" + File.separator + "acm-template";
        // 输出位置
        String outputPath = projectPath;

//        copyFileBuHutoolUtil(inputPath, outputPath);
        copyFileByRecursive(inputPath, outputPath);
    }

    /**
     * copy文件
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileBuHutoolUtil(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    /**
     * 递归拷贝文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFileByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (IOException e) {
            System.out.println("文件复制失败！");
            e.printStackTrace();
        }
        System.out.println("文件复制成功！");
    }

    /**
     * 递归拷贝文件（若是目录，就递归其下面的子文件；若是文件，就复制文件）
     * @param inputFile
     * @param outputFile
     */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        if (inputFile.isDirectory()) {
            // 目录
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 目录不存在，创建目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            // 该输入目录下，没有子文件
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            // 文件
            // 若是为文件，直接进行复制
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            //  如果文件存在，就替换
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
