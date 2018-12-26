package Mo;

public class ErrorItem {
    private Integer eId;
    private  Integer memId;
    private  Integer itId;
    private  String time;    //时间
    private  String Yanswer;   //你的答案
    private  Integer times;  //做错次数


    public String toString() {
        return "ErrorItem{" +
                "eId=" + eId +
                ", memId=" + memId +
                ", itId=" + itId +
                ", time='" + time + '\'' +
                ", Yanswer='" + Yanswer + '\'' +
                ", times=" + times +
                '}';
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getItId() {
        return itId;
    }

    public void setItId(Integer itId) {
        this.itId = itId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYanswer() {
        return Yanswer;
    }

    public void setYanswer(String yanswer) {
        Yanswer = yanswer;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
