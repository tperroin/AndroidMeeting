package epsi.nantes.fr.meeting.model;

/**
 * Created by Thibault on 29/10/2015.
 */
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

@Generated("org.jsonschema2pojo")
public class MeetingWS {

    @SerializedName("id")
    @Expose
    private UUID id;
    @SerializedName("author")
    @Expose
    private UUID author;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("begin")
    @Expose
    private String begin;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("end")
    @Expose
    private String end;
    /**
     *
     * (Required)
     *
     */
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = new ArrayList<Participant>();

    /**
     *
     * @return
     * The id
     */
    public UUID getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    public MeetingWS withId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The author
     */
    public UUID getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(UUID author) {
        this.author = author;
    }

    public MeetingWS withAuthor(UUID author) {
        this.author = author;
        return this;
    }

    /**
     *
     * (Required)
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * (Required)
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public MeetingWS withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public MeetingWS withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     *
     * (Required)
     *
     * @return
     * The begin
     */
    public String getBegin() {
        return begin;
    }

    /**
     *
     * (Required)
     *
     * @param begin
     * The begin
     */
    public void setBegin(String begin) {
        this.begin = begin;
    }

    public MeetingWS withBegin(String begin) {
        this.begin = begin;
        return this;
    }

    /**
     *
     * (Required)
     *
     * @return
     * The end
     */
    public String getEnd() {
        return end;
    }

    /**
     *
     * (Required)
     *
     * @param end
     * The end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    public MeetingWS withEnd(String end) {
        this.end = end;
        return this;
    }

    /**
     *
     * (Required)
     *
     * @return
     * The participants
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     *
     * (Required)
     *
     * @param participants
     * The participants
     */
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public MeetingWS withParticipants(List<Participant> participants) {
        this.participants = participants;
        return this;
    }

}