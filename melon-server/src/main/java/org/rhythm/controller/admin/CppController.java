package org.rhythm.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.rhythm.result.Result;
import org.rhythm.service.AIService;
import org.rhythm.service.CppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.Enumeration;

@CrossOrigin
@RequestMapping("/admin/cpp")
@Tag(name = "cpp接口", description = "编译、运行等")
@RestController
@Slf4j
public class CppController {

    @Autowired
    private CppService cppService;

    @Operation(summary = "编译")
    @GetMapping("/compile")
    public Result<String> compileCppFile() {
        // 或者使用 HttpServletRequest 对象获取请求头
        String resultStr = cppService.compile();
        return Result.success(resultStr);
    }

    @Operation(summary = "运行")
    @GetMapping("/execute")
    public Result<String> executeCppFile() {
        // 或者使用 HttpServletRequest 对象获取请求头
        String resultStr = cppService.executeCppFile();
        return Result.success(resultStr);
    }
}
