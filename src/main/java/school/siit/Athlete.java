package school.siit;


public class Athlete{
    private String athleteNumber;
    private String athleteName;
    private String countryCode;
    private Integer baseTimeInSeconds;
    private Integer penaltyTimeInSeconds;
    private Integer totalTime;

    public Athlete(String line){
        String[] athleteArray = line.trim().split("\\s*,\\s*");
        this.athleteNumber = athleteArray[0];
        this.athleteName = athleteArray[1];
        this.countryCode = athleteArray[2];
        this.baseTimeInSeconds = calculateBaseTime(athleteArray[3]);
        this.penaltyTimeInSeconds = calculatePenaltyTime(athleteArray[4] + athleteArray[5] + athleteArray[6]);
        this.totalTime = this.baseTimeInSeconds + this.penaltyTimeInSeconds;
    }

    public Integer calculateBaseTime(String timeStr){

        String[] skiTimeResultSplit = timeStr.split("\\s*:\\s*");
        Integer secondsTotal = (Integer.parseInt(skiTimeResultSplit[0]) * 60) + Integer.parseInt(skiTimeResultSplit[1]);
        return secondsTotal;
    }

    public Integer calculatePenaltyTime(String penaltyTimeStr){
        char ch = 'o';
        Integer penalties = (int)(penaltyTimeStr.chars().filter(c -> c == ch).count());
        Integer totalPenaltyTime = penalties * 10;
        return totalPenaltyTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public String getAthleteSummary(){
        return this.athleteName + " " +
                this.totalTime / 60 + ":" + this.totalTime % 60 +
                " (" + this.baseTimeInSeconds / 60 + ":" + this.baseTimeInSeconds % 60 + " + " + this.penaltyTimeInSeconds + ")";

             //   Piotr Smitzer 30:10 (30:10 + 0)
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber='" + athleteNumber + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", baseTimeInSeconds=" + baseTimeInSeconds +
                ", penaltyTimeInSeconds=" + penaltyTimeInSeconds +
                ", totalTime=" + totalTime +
                '}';
    }

    public String getName(){
        return this.athleteName;
    }
}