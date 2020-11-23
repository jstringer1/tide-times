package uk.co.stringerj.tidetimes.service;

import java.util.List;
import uk.co.stringerj.tidetimes.model.Station;
import uk.co.stringerj.tidetimes.model.TidalHistory;
import uk.co.stringerj.tidetimes.model.TidalPrediction;

public interface TideTimesService {
  List<Station> getStations();

  Station getStation(String station);

  List<TidalPrediction> getTidalEvents(String station);

  List<TidalHistory> getTidalHistory(String station, String date);
}
