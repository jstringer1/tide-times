package uk.co.stringerj.tidetimes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.stringerj.tidetimes.model.Station;
import uk.co.stringerj.tidetimes.model.TidalHistory;
import uk.co.stringerj.tidetimes.model.TidalPrediction;
import uk.co.stringerj.tidetimes.service.TideTimesService;

@RestController
public class TideTimesController {

  @Autowired
  TideTimesService service;

  @GetMapping("/stations")
  public List<Station> getStations() {
    return service.getStations();
  }

  @GetMapping("/station/{station}")
  public Station getStation(@PathVariable("station") String station) {
    return service.getStation(station);
  }

  @GetMapping("/station/{station}/predictions")
  public List<TidalPrediction> getTidalPredictions(@PathVariable("station") String station) {
    return service.getTidalEvents(station);
  }

  @GetMapping("/station/{station}/history")
  public List<TidalHistory> getTidalHistory(@PathVariable("station") String station,
      @RequestParam("date") String date) {
    return service.getTidalHistory(station, date);
  }
}
