package Mo;

public class Finishitem {
    private Integer fiId;
    private  Integer memId;
    private  Integer itId;
    private  String Yanswer;   //你的答案
    private   String itcatagroy;
    private Integer  fiIdnum;  //完成第几次的第几题
    private  Integer finishtimes;

    public String toString() {
        return "Finishitem{" +
                "fiId=" + fiId +
                ", memId=" + memId +
                ", itId=" + itId +
                ", Yanswer='" + Yanswer + '\'' +
                ", itcatagroy='" + itcatagroy + '\'' +
                ", fiIdnum='" + fiIdnum + '\'' +
                ", finishtimes='" + finishtimes + '\'' +
                '}';
    }

    public String getItcatagroy() {
        return itcatagroy;
    }

    public void setItcatagroy(String itcatagroy) {
        this.itcatagroy = itcatagroy;
    }

    public Integer getFiIdnum() {
        return fiIdnum;
    }

    public void setFiIdnum(Integer fiIdnum) {
        this.fiIdnum = fiIdnum;
    }

    public Integer getFinishtimes() {
        return finishtimes;
    }

    public void setFinishtimes(Integer finishtimes) {
        this.finishtimes = finishtimes;
    }

    public Integer getFiId() {
        return fiId;
    }

    public void setFiId(Integer fiId) {
        this.fiId = fiId;
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


    public String getYanswer() {
        return Yanswer;
    }

    public void setYanswer(String yanswer) {
        Yanswer = yanswer;
    }
}
