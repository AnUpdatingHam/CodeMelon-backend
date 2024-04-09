package org.rhythm.service.impl;

import org.rhythm.service.CppService;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CppServiceImpl implements CppService {
    @Override
    public String compile() {
        String result = "";
        try {
            // 编译命令
            String command = "cl /EHsc temp.cpp";

            // 创建 ProcessBuilder 对象
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));
            pb.redirectErrorStream(true);

            // 执行命令
            Process process = pb.start();

            // 获取命令输出
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                result.concat(line);
                System.out.println(line);
            }

            // 等待命令执行完成
            int exitCode = process.waitFor();
            result.concat("\"\nExit Code: \" + exitCode");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public String executeCppFile() {
        String resultStr = "";
        try {
            // 执行命令
            String command = "temp.exe";
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));
            pb.redirectErrorStream(true);
            Process process = pb.start();

            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

            // 在进程执行完毕后读取输出文件内容
            String outputFilePath = "out";
            try (InputStream inputStream = new FileInputStream(outputFilePath)) {
                if (inputStream != null) {
                    resultStr = readOutputFile(inputStream);
                } else {
                    resultStr = "Output file not found.";
                    System.out.println("Output file not found.");
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

    @Override
    public String readOutputFile(InputStream inputStream) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            System.out.println("Output: " + content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
