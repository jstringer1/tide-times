package uk.co.stringerj.tidetimes.model;

import java.util.Date;

public class TidalHistory {
  private final Date date;
  private final double height;

  public TidalHistory(Date date, double height) {
    this.date = date;
    this.height = height;
  }

  public Date getDate() {
    return date;
  }

  public double getHeight() {
    return height;
  }
}
