package Mo;

public class Items {
    private Integer itId;
    private Integer aId;
    private String answer;
    private String catagroy;   //类型
    private String itContent;  //问题
    private String aKey;
    private String bKey;
    private String cKey;
    private String dKey;
    private String analyse;  //解析
    private String knowledge;
    private  String itStatus;

    public String toString() {
        return "Items{" +
                "itId=" + itId +
                ", aId=" + aId +
                ", answer='" + answer + '\'' +
                ", catagroy='" + catagroy + '\'' +
                ", itContent='" + itContent + '\'' +
                ", aKey='" + aKey + '\'' +
                ", bKey='" + bKey + '\'' +
                ", cKey='" + cKey + '\'' +
                ", dKey='" + dKey + '\'' +
                ", analyse='" + analyse + '\'' +
                ", knowledge='" + knowledge + '\'' +
                ", itStatus='" + itStatus + '\'' +
                '}';
    }

    public Integer getItId() {
        return itId;
    }

    public void setItId(Integer itId) {
        this.itId = itId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCatagroy() {
        return catagroy;
    }

    public void setCatagroy(String catagroy) {
        this.catagroy = catagroy;
    }

    public String getItContent() {
        return itContent;
    }

    public void setItContent(String itContent) {
        this.itContent = itContent;
    }

    public String getaKey() {
        return aKey;
    }

    public void setaKey(String aKey) {
        this.aKey = aKey;
    }

    public String getbKey() {
        return bKey;
    }

    public void setbKey(String bKey) {
        this.bKey = bKey;
    }

    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey;
    }

    public String getdKey() {
        return dKey;
    }

    public void setdKey(String dKey) {
        this.dKey = dKey;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getItStatus() {
        return itStatus;
    }

    public void setItStatus(String itStatus) {
        this.itStatus = itStatus;
    }
}
