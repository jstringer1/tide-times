package uk.co.stringerj.tidetimes.service;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.stringerj.tidetimes.client.AdmiraltyClient;
import uk.co.stringerj.tidetimes.client.TideGuageClient;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyFeature;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyTidalEvent;
import uk.co.stringerj.tidetimes.client.model.TideGuageReading;
import uk.co.stringerj.tidetimes.client.model.TideGuageStation;
import uk.co.stringerj.tidetimes.model.Station;
import uk.co.stringerj.tidetimes.model.TidalHistory;
import uk.co.stringerj.tidetimes.model.TidalPrediction;

@Service
public class TideTimesServiceImpl implements TideTimesService {

  private static final Logger LOGGER = Logger.getLogger(TideTimesService.class.getSimpleName());


  @Autowired
  private TideGuageClient tideGuage;

  @Autowired
  private AdmiraltyClient admiralty;

  private List<Station> stationCache = new ArrayList<>();

  private Map<String, List<TidalPrediction>> eventCache = new HashMap<>();

  @Override
  public List<Station> getStations() {
    synchronized (stationCache) {
      if (stationCache.isEmpty()) {
        List<AdmiraltyFeature> admiraltyStations = admiralty.getStations().getFeatures();
        List<TideGuageStation> tideGuageStations = tideGuage.getStations().getStations();
        stationCache.addAll(translate(admiraltyStations, tideGuageStations));
      }
      return unmodifiableList(stationCache);
    }
  }

  @Override
  public Station getStation(String station) {
    return getStations().stream()
        .filter(s -> s.getName().equalsIgnoreCase(station)
            || s.getAdmiraltyId().equalsIgnoreCase(station)
            || s.getTideGuageId().equalsIgnoreCase(station))
        .findAny().get();
  }

  @Override
  public List<TidalPrediction> getTidalEvents(String station) {
    String id = getStation(station).getAdmiraltyId();
    synchronized (eventCache) {
      if (!eventCache.containsKey(id) || eventCache.get(id).get(0).getDateTime().toInstant()
          .isBefore(Instant.now().truncatedTo(ChronoUnit.DAYS))) {
        eventCache.put(id,
            admiralty.getTidalEvents(id).stream().map(this::translate).collect(toList()));
      }
      return unmodifiableList(eventCache.get(id));
    }
  }

  @Override
  public List<TidalHistory> getTidalHistory(String station, String date) {
    String id = getStation(station).getTideGuageId();
    return tideGuage.getReading(id, date).getItems().stream().map(this::transform)
        .collect(toList());
  }

  private TidalHistory transform(TideGuageReading reading) {
    return new TidalHistory(reading.getDateTime(), reading.getValue());
  }

  private List<Station> translate(List<AdmiraltyFeature> admiraltyStations,
      List<TideGuageStation> tideGuageStations) {
    List<Station> result = new ArrayList<>();
    for (AdmiraltyFeature admiraltyStation : admiraltyStations) {
      tideGuageStations.stream()
          .filter(tideGuageStation -> tideGuageStation.getName()
              .equalsIgnoreCase(admiraltyStation.getName()))
          .findAny().ifPresent(tideGuageStation -> result.add(new Station(admiraltyStation.getId(),
              tideGuageStation.getId(), admiraltyStation.getName())));
    }
    logUnmatchedStations(result, admiraltyStations, tideGuageStations);
    return result;
  }

  private TidalPrediction translate(AdmiraltyTidalEvent event) {
    return new TidalPrediction(TidalPrediction.Type.byAdmiraltyType(event.getEventType()),
        event.getDateTime(), event.getHeight());
  }

  private void logUnmatchedStations(List<Station> stations,
      List<AdmiraltyFeature> admiraltyStations, List<TideGuageStation> tideGuageStations) {
    List<String> admiraltyIds = stations.stream().map(Station::getAdmiraltyId).collect(toList());
    List<String> tideGuageIds = stations.stream().map(Station::getTideGuageId).collect(toList());
    admiraltyStations.stream().filter(station -> !admiraltyIds.contains(station.getId()))
        .forEach(station -> LOGGER.warning(station.getName() + " not found in Tide Guage"));
    tideGuageStations.stream().filter(station -> !tideGuageIds.contains(station.getId()))
        .forEach(station -> LOGGER.warning(station.getName() + " not found in Admiralty"));
  }
}
