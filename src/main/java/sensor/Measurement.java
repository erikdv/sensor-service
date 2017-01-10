package sensor;


import java.sql.Timestamp;

public class Measurement {

    private Timestamp timestamp;
    private long value;


    public Measurement() {

    }
    public Measurement(Timestamp timestamp, long value) {
        this.timestamp = timestamp;
        this.value = value;
    }
    

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp =  timestamp;
    }

    public long getValue() {
        return value;
    }
    
    public void setValue(long value) {
        this.value =  value;
    }
    
}
