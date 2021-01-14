package uk.co.stringerj.tidetimes.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import uk.co.stringerj.tidetimes.client.AdmiraltyClient;
import uk.co.stringerj.tidetimes.client.TideGuageClient;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyFeature;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyFeatureCollection;
import uk.co.stringerj.tidetimes.client.model.AdmiraltyProperties;
import uk.co.stringerj.tidetimes.client.model.TideGuageStation;
import uk.co.stringerj.tidetimes.client.model.TideGuageStations;
import uk.co.stringerj.tidetimes.model.Station;

public class TideTimesServiceImplTest {

  private TideTimesServiceImpl testSubject;

  @Mock private TideGuageClient tideGuage;
  @Mock private AdmiraltyClient admiralty;

  @Test
  public void testGetStations() throws Exception {
    when(tideGuage.getStations())
        .thenReturn(
            new TideGuageStations(
                new TideGuageStation("A1234", "Holyhead"),
                new TideGuageStation("A1235", "Llandudno")));
    when(admiralty.getStations())
        .thenReturn(
            new AdmiraltyFeatureCollection(
                "",
                new AdmiraltyFeature(
                    "", null, new AdmiraltyProperties("B1234", "Liverpool", "", false)),
                new AdmiraltyFeature(
                    "", null, new AdmiraltyProperties("B1235", "Holyhead", "", false))));

    List<Station> result = testSubject.getStations();
    assertThat(result.size(), equalTo(2));
    assertThat(result, hasItem(new Station("B1235", "A1234", "Holyhead")));
    assertThat(result, hasItem(new Station("B1234", null, "Liverpool")));
  }

  @Test
  public void testGetStationsResultIsCached() throws Exception {
    when(tideGuage.getStations())
        .thenReturn(new TideGuageStations(new TideGuageStation("C1234", "Llandudno")))
        .thenThrow(new RuntimeException("Should have cached result"));
    when(admiralty.getStations())
        .thenReturn(
            new AdmiraltyFeatureCollection(
                "",
                new AdmiraltyFeature(
                    "", null, new AdmiraltyProperties("D4321", "Llandudno", "", false))))
        .thenThrow(new RuntimeException("Should have cached result"));

    testSubject.getStations();
    assertThat(testSubject.getStations(), hasItem(new Station("D4321", "C1234", "Llandudno")));
  }

  @BeforeEach
  public void setup() throws Exception {
    initMocks(this);
    testSubject = new TideTimesServiceImpl(tideGuage, admiralty);
  }
}
