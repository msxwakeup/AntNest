package Mo;

public class Adminer {
    private Integer aId;
    private String  aName;
    private String aSex;
    private Integer aAge;
    private String aPwd;
    private String aPhoto;

    public String toString() {
        return "Adminer{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aSex='" + aSex + '\'' +
                ", aAge=" + aAge +
                ", aPwd='" + aPwd + '\'' +
                ", aPhoto='" + aPhoto + '\'' +
                '}';
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaSex() {
        return aSex;
    }

    public void setaSex(String aSex) {
        this.aSex = aSex;
    }

    public Integer getaAge() {
        return aAge;
    }

    public void setaAge(Integer aAge) {
        this.aAge = aAge;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public String getaPhoto() {
        return aPhoto;
    }

    public void setaPhoto(String aPhoto) {
        this.aPhoto = aPhoto;
    }
}
