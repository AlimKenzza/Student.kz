package model;

public class Clubs {
    private int clubId;
    private String clubName;
    private int memberCount;
    private String leader;

    public Clubs(int clubId, String clubName, int memberCount, String leader) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.memberCount = memberCount;
        this.leader = leader;
    }

    public Clubs() {
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
}
