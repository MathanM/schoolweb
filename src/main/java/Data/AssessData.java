package Data;

public class AssessData {
    private int assId;
    private int assDuration;
    private int marks;
    private int courId;
    private int chapId;
    private String assType;
    private String assName;
    private String assStatus;
    private String createdBy;

    public int getCourId() {
        return courId;
    }

    public void setCourId(int courId) {
        this.courId = courId;
    }

    public int getChapId() {
        return chapId;
    }

    public void setChapId(int chapId) {
        this.chapId = chapId;
    }

    public int getAssId() {
        return assId;
    }

    public void setAssId(int assId) {
        this.assId = assId;
    }

    public int getAssDuration() {
        return assDuration;
    }

    public void setAssDuration(int assDuration) {
        this.assDuration = assDuration;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public String getAssName() {
        return assName;
    }

    public void setAssName(String assName) {
        this.assName = assName;
    }

    public String getAssStatus() {
        return assStatus;
    }

    public void setAssStatus(String assStatus) {
        this.assStatus = assStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
