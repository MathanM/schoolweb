package Login;

import Data.ChapData;
import Data.UserData;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;

@RestController
@RequestMapping("login")
public class LoginController {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "", headers="Content-Type=application/json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String userLogin(@RequestBody LoginBean user) {
        String response;
        LoginDao dao=new LoginDao();
        UserData data = dao.userLoginDao(user);
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
    @RequestMapping(value = "/forgotPassword", headers="Content-Type=application/json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String forgotPassword(@RequestBody LoginBean user) {
        String response;
        LoginDao dao=new LoginDao();
        boolean data = dao.forgotPasswordDao(user);
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
    @RequestMapping(value = "/updateUserDetails", headers="Content-Type=application/json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String updateUserDetails(@RequestBody LoginBean user) {
        String response;
        LoginDao dao=new LoginDao();
        boolean data = dao.updateUserDetailsDao(user);
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
    @RequestMapping(value = "/getChapters", headers="Content-Type=application/json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String getChapters(@RequestBody int courseId) {
        String response;
        LoginDao dao=new LoginDao();
        ArrayList<ChapData> data = dao.getChaptersDao(courseId);
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
    @RequestMapping(value = "/ansMatching", headers="Content-Type=application/json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String ansMatching(@RequestBody String ans) {
        String response;
        LoginDao dao=new LoginDao();
        String data = dao.ansMatching(ans);
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
