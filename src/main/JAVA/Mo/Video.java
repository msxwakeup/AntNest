package Mo;

public class Video {
    private Integer vId;
    private Integer aId;
    private Integer mkId;
    private String videoName;
    private String upTime;
    private String vLink;
    private String knowledge;
    private  String videoimg;
    private  int times;  //观看次数
    private  String introduction;

    public String toString() {
        return "Video{" +
                "vId=" + vId +
                ", aId=" + aId +
                ", mkId=" + mkId +
                ", videoName='" + videoName + '\'' +
                ", upTime='" + upTime + '\'' +
                ", vLink='" + vLink + '\'' +
                ", knowledge='" + knowledge + '\'' +
                ", videoimg='" + videoimg + '\'' +
                ", times=" + times +
                '}';
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getVideoimg() {
        return videoimg;
    }

    public void setVideoimg(String videoimg) {
        this.videoimg = videoimg;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getMkId() {
        return mkId;
    }

    public void setMkId(Integer mkId) {
        this.mkId = mkId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getvLink() {
        return vLink;
    }

    public void setvLink(String vLink) {
        this.vLink = vLink;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }
}
