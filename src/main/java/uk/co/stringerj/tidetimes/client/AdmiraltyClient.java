package uk.co.stringerj.tidetimes.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyFeatureCollection;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyTidalEvent;

@FeignClient(name = "admiralty", url = "https://admiraltyapi.azure-api.net/uktidalapi/api/V1")
public interface AdmiraltyClient {

  @GetMapping("Stations")
  AdmiraltyFeatureCollection getStations();

  @GetMapping("Stations/{station}/TidalEvents")
  List<AdmiraltyTidalEvent> getTidalEvents(@PathVariable("station") String station);
}
