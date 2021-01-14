package uk.co.stringerj.tidetimes.client.model;

import java.util.Date;

public class TideGuageReading {
  private Date dateTime;
  private double value;

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

}
