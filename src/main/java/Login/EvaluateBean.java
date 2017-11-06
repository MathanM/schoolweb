package Login;

import Data.QueData;

import java.util.ArrayList;

public class EvaluateBean {
    private String courseId;
    private String chapterId;
    private ArrayList<QueData> results;

    public ArrayList<QueData> getResults() {
        return results;
    }

    public void setResults(ArrayList<QueData> results) {
        this.results = results;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }
}
