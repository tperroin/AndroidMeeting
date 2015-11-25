package epsi.nantes.fr.meeting.model;

/**
 * Created by Thibault on 29/10/2015.
 */
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Participant {

    /**
     *
     * (Required)
     *
     */
    @SerializedName("id")
    @Expose
    private String id;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("status")
    @Expose
    private Participant.Status status;

    /**
     *
     * (Required)
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * (Required)
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Participant withId(String id) {
        this.id = id;
        return this;
    }

    /**
     *
     * (Required)
     *
     * @return
     * The status
     */
    public Participant.Status getStatus() {
        return status;
    }

    /**
     *
     * (Required)
     *
     * @param status
     * The status
     */
    public void setStatus(Participant.Status status) {
        this.status = status;
    }

    public Participant withStatus(Participant.Status status) {
        this.status = status;
        return this;
    }

    @Generated("org.jsonschema2pojo")
    public static enum Status {

        @SerializedName("present")
        PRESENT("present"),
        @SerializedName("absent")
        ABSENT("absent"),
        @SerializedName("unknown")
        UNKNOWN("unknown");
        private final String value;
        private static Map<String, Participant.Status> constants = new HashMap<String, Participant.Status>();

        static {
            for (Participant.Status c: values()) {
                constants.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static Participant.Status fromValue(String value) {
            Participant.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}