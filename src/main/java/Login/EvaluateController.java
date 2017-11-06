package Login;

import Data.QueData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("evaluate")
public class EvaluateController {
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    String evaluateAnswers(@RequestBody List<QueData> ans) {
        String response;
        EvaluateDao dao=new EvaluateDao();
        ArrayList<QueData> data = dao.evaluateAnswersDao(ans);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            response = ow.writeValueAsString(data);
            return response;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "getQuestions", headers="Content-Type=application/json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String getQuestions(@RequestBody EvaluateBean bean) {
        String response;
        EvaluateDao dao=new EvaluateDao();
        List<QueData> data = dao.getQuestionsDao(bean);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            response = ow.writeValueAsString(data);
            return response;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
