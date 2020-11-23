package uk.co.stringerj.tidetimes.client.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdmiraltyTidalEvent {

  @JsonProperty("EventType")
  private String eventType;
  @JsonProperty("DateTime")
  private Date dateTime;
  @JsonProperty("IsApproximateTime")
  private boolean isApproximateTime;
  @JsonProperty("Height")
  private double height;
  @JsonProperty("IsApproximateHeight")
  private boolean isApproximateHeight;
  @JsonProperty("Filtered")
  private boolean filtered;
  @JsonProperty("Date")
  private Date date;

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public boolean isApproximateTime() {
    return isApproximateTime;
  }

  public void setApproximateTime(boolean isApproximateTime) {
    this.isApproximateTime = isApproximateTime;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public boolean isApproximateHeight() {
    return isApproximateHeight;
  }

  public void setApproximateHeight(boolean isApproximateHeight) {
    this.isApproximateHeight = isApproximateHeight;
  }

  public boolean isFiltered() {
    return filtered;
  }

  public void setFiltered(boolean filtered) {
    this.filtered = filtered;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
