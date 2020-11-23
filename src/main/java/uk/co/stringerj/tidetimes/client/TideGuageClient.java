package uk.co.stringerj.tidetimes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.co.stringerj.tidetimes.client.model.TideGuageReadings;
import uk.co.stringerj.tidetimes.client.model.TideGuageStations;

@FeignClient(name = "tide", url = "https://environment.data.gov.uk/flood-monitoring")
public interface TideGuageClient {

  @GetMapping("id/stations?qualifier=Tidal%20Level&unitName=m")
  TideGuageStations getStations();

  @GetMapping("id/stations/{station}/readings?_sorted=true&date={date}")
  public TideGuageReadings getReading(@PathVariable("station") String station,
      @PathVariable("date") String date);

}
