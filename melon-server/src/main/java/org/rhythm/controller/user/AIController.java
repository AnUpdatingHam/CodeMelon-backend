package org.rhythm.controller.user;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.rhythm.dto.QuestionDTO;
import org.rhythm.entity.Question;
import org.rhythm.result.Result;
import org.rhythm.service.AIService;
import org.rhythm.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//AI询问接口
@RequestMapping("/user/ai")
@Api(tags = "AI接口")
@RestController
@Slf4j
public class AIController {
    @Autowired
    private AIService aiService;

    /**
     * 向AI模型提问
     * @param questionDTO
     * @return
     */
    @PostMapping("/ask")
    public Result<QuestionVO> ask(@RequestBody QuestionDTO questionDTO){
        Question question = new Question(questionDTO.getQuestion());
        QuestionVO ans = aiService.answer(question);
        return Result.success(ans);
    }
}
